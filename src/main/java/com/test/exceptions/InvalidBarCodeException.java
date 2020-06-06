package com.test.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidBarCodeException extends Exception {

    public InvalidBarCodeException(String message){
        super(message);
    }
}
