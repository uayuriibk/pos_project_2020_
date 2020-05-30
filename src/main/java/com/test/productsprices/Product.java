package com.test.productsprices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class Product {

    private String code;
    private String title;
    private Price price;

}
