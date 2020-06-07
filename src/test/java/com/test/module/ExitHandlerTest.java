package com.test.module;

import com.test.handlers.ExitHandler;
import com.test.handlers.Handler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExitHandlerTest {

    @Spy
    private Handler exitHandler = new ExitHandler();

    @Mock
    private Handler nextHandler;

    @Test(expected = NullPointerException.class)
    public void testExitHandlerIsTheLast(){
        exitHandler.setNext(nextHandler);
        exitHandler.process("Test");
        verify(nextHandler).process("Test");
    }

}
