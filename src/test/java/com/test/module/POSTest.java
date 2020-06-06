package com.test.module;

import com.test.POS;
import com.test.handlers.ExitHandler;
import com.test.handlers.Handler;
import com.test.handlers.ScanBarCodeHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class POSTest {

    private POS pos;

    @Mock
    private ExitHandler exitHandlerMock;

    @Mock
    private ScanBarCodeHandler scanBarCodeHandlerMock;

    @Before
    public void setUp(){
        pos = POS.getInstance();
    }

    @Test
    public void testInputProcessingByFirstHandlerInTheChain() {
        List<Handler> handlersCollection = new ArrayList<>();
        handlersCollection.add(exitHandlerMock);
        handlersCollection.add(scanBarCodeHandlerMock);
        pos.setHandlersChain(handlersCollection);
        pos.processInput("Test Input");

        verify(exitHandlerMock, times(1)).process(anyString());
        verify(scanBarCodeHandlerMock, times(0)).process(anyString());
    }
}
