package org.bedu.calculator.service;


import org.bedu.calculator.service.BasicCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class BasicCalculatorServiceTest {

    @InjectMocks
    private BasicCalculatorService service;

    @Test
    @DisplayName("Should return 0 when both values are 0")
    public void sumZeros(){
        int result = service.sum(0,0);

        assertEquals(result, 0);
    }

    @Test
    @DisplayName("should return the same number when second argument is zero")
    public void sumWithRightZero(){
        int result = service.sum(100, 0);

        assertEquals(result, 100);
    }

    @Test

    public void sumWithLeftZero(){
        int result = service.sum(0, 80);

        assertEquals(result, 80);
    }
}
