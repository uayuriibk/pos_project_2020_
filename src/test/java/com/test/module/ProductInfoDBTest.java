package com.test.module;

import com.test.productsprices.Price;
import com.test.productsprices.Product;
import com.test.productsprices.ProductsInfoDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Matchers.booleanThat;
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

    @Test
    public void testProductPriceReceiving(){
        Product productMock = Mockito.mock(Product.class);
        Price priceMock = Mockito.mock(Price.class);

        when(productMock.getCode()).thenReturn("testCode");
        when(priceMock.getValue()).thenReturn(new BigDecimal(1.25));
        when(productMock.getPrice()).thenReturn(priceMock);

        productsInfoDB.addProduct(productMock);

        BigDecimal expectedSavedProductPrice = new BigDecimal(1.25);
        BigDecimal actualSavedProductPrice = productsInfoDB.getPrice("testCode").getValue();

        Assert.assertEquals(expectedSavedProductPrice, actualSavedProductPrice);
    }

    @Test
    public void testProductTitleReceiving(){
        Product productMock = Mockito.mock(Product.class);
        when(productMock.getCode()).thenReturn("testCode");
        when(productMock.getTitle()).thenReturn("testTitle");

        productsInfoDB.addProduct(productMock);

        String expectedSavedProductTitle = "testTitle";
        String actualSavedProductTitle = productsInfoDB.getProductTitle("testCode");

        Assert.assertEquals(expectedSavedProductTitle, actualSavedProductTitle);
    }


}
