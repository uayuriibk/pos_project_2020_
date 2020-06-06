package com.test.devices;

public class LCDDisplay implements IDisplay {

    public void showMessage(String message){

        System.out.println("LCDDisplay: " + message);

    }
}
