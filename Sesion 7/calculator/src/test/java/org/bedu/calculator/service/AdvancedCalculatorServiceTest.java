package org.bedu.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@ExtendWith(MockitoExtension.class)
public class AdvancedCalculatorServiceTest {

    @InjectMocks
    private AdvancedCalculatorService service;

    @Test
    @DisplayName("Zero factorial")
    public void zeroFactorial(){
        int result = service.factorial(0);

        assertEquals(result, 1);
    }

    @Test
    @DisplayName("One factorial")
    public void oneFactorial(){
        int result = service.factorial(1);

        assertEquals(result, 1);
    }

    @Test
    @DisplayName("Natural number factorial")
    public void factorial(){
        int result = service.factorial(5);

        assertEquals(result, 120);
    }

    @Test
    @DisplayName("This should throw exception")
    public void errorFactorial(){
        int result = service.factorial(-5);

        assertThrowsExactly(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {

            }
        });
    }



}
