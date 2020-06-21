package com.test.integration;

import com.test.productsprices.IProductsInfoDB;
import com.test.productsprices.Price;
import com.test.productsprices.Product;
import com.test.productsprices.ProductsInfoDB;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;

public class DataForTestUtility {

    public static Collection<Object[]> getData() {
        Collection<Object[]> inputData = new LinkedList<>();
        inputData.add(new Object[] { splitToTheLetters("ABCDAB"), new BigDecimal(13.00)});
        inputData.add(new Object[] { splitToTheLetters("CCCCC"), new BigDecimal(15.0)});
        inputData.add(new Object[] { splitToTheLetters("ABCD"), new BigDecimal(10.00)});
        return inputData;
    }

    public static IProductsInfoDB getProductsInfoDB() {
        return new ProductsInfoDB(getProducts());
    }

    public static Collection<Product> getProducts() {
        Collection<Product> products = new LinkedList<>();
        products.add(getProductA());
        products.add(getProductB());
        products.add(getProductC());
        products.add(getProductD());
        return products;
    }

    public static Product getProductA() {
        Price price = new Price(new BigDecimal(1.00));
        Product product = new Product ("A", "Apple", price);
        return product;
    }

    public static Product getProductB() {
        Price price = new Price(new BigDecimal(2.00));
        Product product = new Product ("B", "Banan", price);
        return product;
    }

    public static Product getProductC() {
        Price price = new Price(new BigDecimal(3.00));
        Product product = new Product ("C", "Cucumber", price);
        return product;
    }

    public static Product getProductD() {
        Price price = new Price(new BigDecimal(4.00));
        Product product = new Product ("D", "Dirol", price);
        return product;
    }

    public static String[] splitToTheLetters(String source) {
        String splittedLetters[] = new String[source.length()];
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            splittedLetters[i] = Character.toString(chars[i]);
        }
        return splittedLetters;
    }
}