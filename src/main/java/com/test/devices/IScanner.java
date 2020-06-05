package com.test.devices;

import com.test.exceptions.InvalidBarCodeException;
import com.test.exceptions.ProductNotFoundException;
import com.test.productsprices.IProductsInfoDB;

import java.math.BigDecimal;
import java.util.Map;

public interface IScanner {

    void scan(String productCode) throws ProductNotFoundException, InvalidBarCodeException;

    void clearScanned();

    Map<String, String> getReceipt();

    BigDecimal calculateTotalPrice();

    void setProductsPrices(IProductsInfoDB productsInfoDB);

}
