package com.test.module;

import com.test.devices.IPrinter;
import com.test.devices.LaserPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrinterTest {

    @Spy
    private IPrinter printerSpy = new LaserPrinter();

    @Test
    public void checkMessageShowingByDisplay(){
        printerSpy.printMessage("Test");
        verify(printerSpy).printMessage("Test");
    }
}
