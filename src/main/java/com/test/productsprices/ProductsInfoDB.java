package com.test.productsprices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter @Setter
public class ProductsInfoDB implements IProductsInfoDB {

    private Map<String, Product> productsCodesMap = new HashMap<>();

    public ProductsInfoDB(Collection<Product> products){
        products.forEach( product -> productsCodesMap.put(product.getCode(), product));
    }

    @Override
    public void addProduct(Product product) {
        productsCodesMap.put(product.getCode(), product);
    }

    @Override
    public void deleteProduct(String productCode) {
        productsCodesMap.remove(productCode);
    }

    @Override
    public Price getPrice(String productCode) {
        return productsCodesMap.get(productCode).getPrice();
    }

    @Override
    public String getProductTitle(String productCode) {
        return productsCodesMap.get(productCode).getTitle();
    }

    @Override
    public boolean isPresentInStorage(String productCode) {
        if(productsCodesMap.containsKey(productCode)) return true;
        return false;
    }
}
