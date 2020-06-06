package com.test.devices;

import com.test.exceptions.InvalidBarCodeException;
import com.test.exceptions.ProductNotFoundException;
import com.test.productsprices.IProductsInfoDB;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class BarCodeScanner implements IScanner {

    private IProductsInfoDB productsInfoDB;

    private List<String> shoppingCart = new ArrayList<>();

    public void scan(String productCode) throws ProductNotFoundException, InvalidBarCodeException {
        if (StringUtils.isBlank(productCode)) {
            throw new InvalidBarCodeException("Invalid bar-code");
        } else if (!productsInfoDB.isPresentInStorage(productCode)){
            throw new ProductNotFoundException("Product not found");
        } else shoppingCart.add(productCode);
    }

    public BigDecimal calculateTotalPrice() {

        BigDecimal totalProductsPrice = new BigDecimal(0.00);

        for (String itemCode : shoppingCart){
            BigDecimal productPrice = null;
            productPrice = productsInfoDB.getPrice(itemCode).getValue();
            totalProductsPrice = totalProductsPrice.add(productPrice);
        }

        return totalProductsPrice;
    }

    public Map<String, String> getReceipt() {
        Map<String, String> resultReceipt = new HashMap<>();
        StringBuffer receipt = new StringBuffer();
        int itemNumber = 1;

        for (String itemCode : shoppingCart){
            BigDecimal productPrice = null; String productName = null;
            productName = productsInfoDB.getProductTitle(itemCode);
            productPrice = productsInfoDB.getPrice(itemCode).getValue();
            receipt.append(itemNumber + "," + productName + ", price: " + productPrice + ";");
            ++itemNumber;
        }

        BigDecimal totalProductsPrice = calculateTotalPrice();
        resultReceipt.put("boughtProducts", receipt.toString());
        resultReceipt.put("totalPrice", "Total Price: " + totalProductsPrice.toString() + ";");
        clearScanned();
        return resultReceipt;
    }

    public void clearScanned() {
        shoppingCart.clear();
    }

    @Override
    public void setProductsPrices(IProductsInfoDB productsInfoDB) {
        this.productsInfoDB = productsInfoDB;
    }
}
