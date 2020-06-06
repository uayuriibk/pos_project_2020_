package com.test;

import com.test.devices.BarCodeScanner;
import com.test.devices.LCDDisplay;
import com.test.devices.LaserPrinter;
import com.test.handlers.ExitHandler;
import com.test.handlers.Handler;
import com.test.handlers.ScanBarCodeHandler;

import java.util.ArrayList;
import java.util.List;

public class StandartPOSBuilder extends POSBuilder {

    @Override
    public void buildDisplay() {
        pos.setDisplay(new LCDDisplay());
    }

    @Override
    public void buildPrinter() {
        pos.setPrinter(new LaserPrinter());
    }

    @Override
    public void buildScanner() {
        pos.setScanner(new BarCodeScanner());
    }

    @Override
    public void buildHandlersChain() {
        List<Handler> handlers = new ArrayList<>();
        handlers.add(new ExitHandler());
        handlers.add(new ScanBarCodeHandler());
        pos.setHandlersChain(handlers);
    }
}
