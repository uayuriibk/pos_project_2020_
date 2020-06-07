package com.test.handlers;

public abstract class Handler {

    protected Handler nextHandler;

    public void setNext(Handler nextInChain) {
        this.nextHandler = nextInChain;
    }

    public abstract void process(String scannedCode);

}
