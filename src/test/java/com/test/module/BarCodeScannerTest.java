package com.test.module;

import com.test.devices.BarCodeScanner;
import com.test.exceptions.InvalidBarCodeException;
import com.test.exceptions.ProductNotFoundException;
import com.test.productsprices.IProductsInfoDB;
import com.test.productsprices.Price;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BarCodeScannerTest {

    private BarCodeScanner scanner;

    @Mock
    private IProductsInfoDB productsInfoDBMock;

    @Before
    public void setUp(){
        scanner = new BarCodeScanner();
        scanner.setProductsPrices(productsInfoDBMock);
    }

    @After
    public void setDown(){
        scanner = null;
    }

    @Test
    public void checkTotalPriceCalculationWillReturn2(){
        when(productsInfoDBMock.getPrice(anyString())).thenReturn(new Price(new BigDecimal(1.00)));

        List<String> testShopCart = new ArrayList<>();
        testShopCart.add("testCode");
        testShopCart.add("testCode2");

        scanner.setShoppingCart(testShopCart);

        BigDecimal expected = new BigDecimal(2.00);
        BigDecimal actual = scanner.calculateTotalPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkResultReceipt(){
        when(productsInfoDBMock.getProductTitle(anyString())).thenReturn("TestProduct");
        when(productsInfoDBMock.getPrice(anyString())).thenReturn(new Price(new BigDecimal(1.00)));

        List<String> testShopCart = new ArrayList<>();
        testShopCart.add("testCode");
        testShopCart.add("testCode2");
        scanner.setShoppingCart(testShopCart);

        Map<String, String> expectedReceipt = new HashMap<>();
        expectedReceipt.put("boughtProducts", "1,TestProduct, price: 1;2,TestProduct, price: 1;");
        expectedReceipt.put("totalPrice", "Total Price: 2;");
        Map<String, String> actualReceipt = scanner.getReceipt();

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

    @Test(expected = InvalidBarCodeException.class)
    public void checkInvalidBarCodeExceptionThrowing() throws InvalidBarCodeException, ProductNotFoundException {
        scanner.scan("");
    }

    @Test(expected = ProductNotFoundException.class)
    public void checkProductNotFoundExceptionThrowing() throws InvalidBarCodeException, ProductNotFoundException {
        when(productsInfoDBMock.isPresentInStorage(anyString())).thenReturn(false);
        scanner.scan("X");
    }

    @Test
    public void checkScanAndCodeAddingIntoCar() throws InvalidBarCodeException, ProductNotFoundException {
        when(productsInfoDBMock.isPresentInStorage(anyString())).thenReturn(true);

        List<String> testShopCart = new ArrayList<>();
        scanner.setShoppingCart(testShopCart);
        scanner.scan("testProduct1");
        scanner.scan("testProduct2");

        int expectedShoppingCartSize = 2;
        int actualShoppingCartSize = scanner.getShoppingCart().size();

        Assert.assertEquals(expectedShoppingCartSize, actualShoppingCartSize);
    }

    @Test
    public void checkShopCartClearing() throws InvalidBarCodeException, ProductNotFoundException {
        when(productsInfoDBMock.isPresentInStorage(anyString())).thenReturn(true);

        List<String> testShopCart = new ArrayList<>();
        scanner.setShoppingCart(testShopCart);
        scanner.scan("testProduct1");
        scanner.clearScanned();

        int expectedShoppingCartSize = 0;
        int actualShoppingSize = scanner.getShoppingCart().size();

        Assert.assertEquals(expectedShoppingCartSize, actualShoppingSize);
    }


}
