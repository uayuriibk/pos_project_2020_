package com.test.handlers;

import com.test.POS;
import com.test.exceptions.InvalidBarCodeException;
import com.test.exceptions.ProductNotFoundException;

public class ScanBarCodeHandler extends Handler {

    @Override
    public void setNext(Handler nextInChain){
        this.nextHandler = nextInChain;
    }

    @Override
    public void process(String scannedCode) {
        try {
            POS.getInstance().getScanner().scan(scannedCode);
        } catch (InvalidBarCodeException e) {
            POS.getInstance().getDisplay().showMessage(e.getMessage());
        } catch (ProductNotFoundException e) {
            POS.getInstance().getDisplay().showMessage(e.getMessage());
        }
    }
}
