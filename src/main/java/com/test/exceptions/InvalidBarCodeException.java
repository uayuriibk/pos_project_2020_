package com.test.exceptions;

public class InvalidBarCodeException extends Exception {

    public InvalidBarCodeException(){
    }

    public InvalidBarCodeException(String message){
        super(message);
    }
}
