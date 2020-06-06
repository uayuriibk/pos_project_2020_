package com.test;

import com.test.devices.IDisplay;
import com.test.devices.IPrinter;
import com.test.devices.IScanner;
import com.test.handlers.Handler;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class POS {

    private static POS instance = new POS();

    private IDisplay display;
    private IPrinter printer;
    private IScanner scanner;
    private List<Handler> handlers;

    private POS(){}

    public static synchronized POS getInstance(){
        return instance;
    }

    public void setHandlersChain(List<Handler> handlersList){
        this.handlers = handlersList;
        for (int i = 0; i< handlers.size()-1; i++){
            handlers.get(i).setNext(handlers.get(i+1));
        }
    }
    
    public void processInput(String input) {
        handlers.get(0).process(input);
    }
}
