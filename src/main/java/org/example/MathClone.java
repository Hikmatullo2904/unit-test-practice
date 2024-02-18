package org.example;

import java.util.Arrays;

public class MathClone  {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }

    public int pow(int number, int power) {
        int result = 1;
        for ( int i = 0; i < power; i++ )
            result = result * number;
        return result;
    }

    public int sum(int... args) {
        if ( args == null )
            throw new IllegalArgumentException("Arguments can not be null");
        return Arrays.stream(args)
                .reduce(Integer :: sum)
                .orElse(0);
    }

}
