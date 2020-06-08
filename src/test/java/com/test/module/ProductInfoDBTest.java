package com.test.module;

import com.test.productsprices.Product;
import com.test.productsprices.ProductsInfoDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class ProductInfoDBTest {

    private ProductsInfoDB productsInfoDB;

    @Before
    public void setUp(){
        productsInfoDB = new ProductsInfoDB();
    }

    @Test
    public void testProductAdding(){
        Product productMock = Mockito.mock(Product.class);
        when(productMock.getCode()).thenReturn("testCode");

        productsInfoDB.addProduct(productMock);

        int expectedSavedProductsCount = 1;
        int actualSavedProductsCount = productsInfoDB.getProductsCodesMap().size();
        Assert.assertEquals(expectedSavedProductsCount, actualSavedProductsCount);
    }

    @Test
    public void testProductDeleting(){
        Product productMock = Mockito.mock(Product.class);
        when(productMock.getCode()).thenReturn("testCode");

        productsInfoDB.addProduct(productMock);
        productsInfoDB.deleteProduct("testCode");

        int expectedSavedProductsCount = 0;
        int actualSavedProductsCount = productsInfoDB.getProductsCodesMap().size();

        Assert.assertEquals(expectedSavedProductsCount, actualSavedProductsCount);
    }


}
