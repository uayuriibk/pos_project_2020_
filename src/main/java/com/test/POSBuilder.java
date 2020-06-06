package com.test;

import lombok.Getter;

public abstract class POSBuilder {

    @Getter
    protected POS pos;

    public void createNewPointOfSale(){
        pos = POS.getInstance();
    }

    public abstract void buildDisplay();
    public abstract void buildPrinter();
    public abstract void buildScanner();
    public abstract void buildHandlersChain();
}
