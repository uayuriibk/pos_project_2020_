package com.test.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message){
        super(message);
    }
}
