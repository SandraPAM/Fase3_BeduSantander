package org.bedu.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class AdvancedCalculatorService {

    public int factorial(int n) throws ArithmeticException{

        if (n > 0){
            return (n*factorial(n-1));
        }
        else if (n == 0) {
            return 1;
        }
        else {
            throw new ArithmeticException();
        }
    }
}
