package com.test.handlers;

public abstract class Handler {

    protected Handler nextHandler;

    public abstract void setNext(Handler nextInChain);

    public abstract void process(String scannedCode);

}
