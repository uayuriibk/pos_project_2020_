package com.test.handlers;

import com.test.POS;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class ExitHandler extends Handler {

    @Override
    public void setNext(Handler nextInChain){
        this.nextHandler = nextInChain;
    }

    @Override
    public void process(String input){
        if((StringUtils.isNotBlank(input)) && (input.equals("exit"))){
            Map<String, String> receipt = POS.getInstance().getScanner().getReceipt();
            String boughtProducts = receipt.get("boughtProducts");
            String totalPriceInReceipt =  receipt.get("totalPrice");
            POS.getInstance().getDisplay().showMessage(boughtProducts + totalPriceInReceipt);
            POS.getInstance().getPrinter().printMessage(totalPriceInReceipt);
        } else {
            nextHandler.process(input);
        }
    }
}
