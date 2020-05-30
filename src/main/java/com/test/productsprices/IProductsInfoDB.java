package com.test.productsprices;

public interface IProductsInfoDB {

     void addProduct(Product product);

     void deleteProduct(String productCode);

     Price getPrice(String productCode);

     String getProductTitle(String productCode);

     boolean isPresentInStorage(String productCode);
}
