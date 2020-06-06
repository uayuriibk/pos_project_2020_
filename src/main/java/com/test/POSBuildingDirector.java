package com.test;

import lombok.Setter;

public class POSBuildingDirector {

    @Setter
    private POSBuilder posBuilder;

    public POS getPointOfSale(){
        return posBuilder.getPos();
    }

    public void constructPointOfSale(){
        posBuilder.createNewPointOfSale();
        posBuilder.buildScanner();
        posBuilder.buildDisplay();
        posBuilder.buildPrinter();
        posBuilder.buildHandlersChain();
    }

}
