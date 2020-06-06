package com.test.module;

import com.test.devices.IDisplay;
import com.test.devices.LCDDisplay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DisplayTest {

    @Spy
    private IDisplay displaySpy = new LCDDisplay();

    @Test
    public void checkMessageShowingByDisplay(){
        displaySpy.showMessage("Test");
        verify(displaySpy).showMessage("Test");
    }
}
