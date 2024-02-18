package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MathCloneTest {

    private MathClone mathClone;

    @BeforeEach
    void setUp() {
        mathClone = new MathClone();
    }

    @AfterAll
    static void tearDown() {
        System.out.println("All tests passed");
    }

    @Test
    @DisplayName("Test add method : correct result")
    void add() {
        assertEquals(5, mathClone.add(2, 3));
        assertEquals(3, mathClone.add(1, 2));
        assertEquals(0, mathClone.add(0, 0));
    }

    @Test
    @DisplayName("Test add method : incorrect result")
    void addIncorrect() {
        assertNotEquals(6, mathClone.add(2, 3));
        assertNotEquals(4, mathClone.add(1, 2));
        assertNotEquals(1, mathClone.add(0, 0));
    }


    @Test
    @DisplayName("Test subtract method : correct result")
    void subtract() {
        assertEquals(94, mathClone.subtract(234, 140));
        assertEquals(-1, mathClone.subtract(1, 2));
        assertEquals(0, mathClone.subtract(0, 0));
    }

    @Test
    @DisplayName("Test subtract method : incorrect result")
    void subtractIncorrect() {
        assertNotEquals(93, mathClone.subtract(234, 140));
        assertNotEquals(-2, mathClone.subtract(1, 2));
        assertNotEquals(1, mathClone.subtract(0, 0));
    }


    @Test
    @DisplayName("Test multiply method : correct result")
    void multiply() {
        assertEquals(6, mathClone.multiply(2, 3));
        assertEquals(2, mathClone.multiply(1, 2));
        assertEquals(0, mathClone.multiply(0, 0));
    }

    @Test
    @DisplayName("Test multiply method : incorrect result")
    void multiplyIncorrect() {
        assertNotEquals(5, mathClone.multiply(2, 3));
        assertNotEquals(3, mathClone.multiply(1, 2));
        assertNotEquals(1, mathClone.multiply(0, 0));
    }

    @ParameterizedTest(name = "{index} : {0} * {1} = {2}")
    @CsvFileSource(resources = "/multiply.csv", useHeadersInDisplayName = true, numLinesToSkip = 1)
    @DisplayName("Test multiply method : correct result")
    void multiplyCsvFileSource(int a, int b, int expected) {
        assertEquals(expected, mathClone.multiply(a, b));
    }


    @Test
    @DisplayName("Test divide method : correct result")
    void divide() {
        assertEquals(2, mathClone.divide(6, 3));
        assertEquals(0, mathClone.divide(1, 2));
    }

    @ParameterizedTest(name = "{displayName} => {index} : {arguments}")
    @CsvFileSource(resources = "/division.csv", useHeadersInDisplayName = true, numLinesToSkip = 1)
    @DisplayName("Test divide method : correct result")
    void divideCsvFileSource(int a, int b, int expected) {
        assertEquals(expected, mathClone.divide(a, b));
    }


    @Test
    @DisplayName("Test divide method : incorrect result")
    void divideIncorrect() {
        assertNotEquals(3, mathClone.divide(6, 3));
        assertNotEquals(2, mathClone.divide(1, 2));
    }

    @Test
    @DisplayName("Test divide method : divide by zero")
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> mathClone.divide(1, 0));
    }

    @Test
    @DisplayName("Test pow method : correct result")
    void pow() {
        assertEquals(8, mathClone.pow(2, 3));
        assertEquals(1, mathClone.pow(1, 1));
    }

    @Test
    @DisplayName("Test pow method : incorrect result")
    void powIncorrect() {
        assertNotEquals(7, mathClone.pow(2, 3));
        assertNotEquals(0, mathClone.pow(1, 1));
    }

    @Test
    @DisplayName("Test mod method : correct result")
    void mod() {
        assertEquals(3, mathClone.mod(7, 4));
        assertEquals(1, mathClone.mod(1, 4));
    }

    @Test
    @DisplayName("Test mod method : incorrect result")
    void modIncorrect() {
        assertNotEquals(2, mathClone.mod(7, 4));
        assertNotEquals(0, mathClone.mod(1, 4));
    }

    @Test
    void argsSum() {
        int[] args = {1, 2, 3};
        assertEquals(6, mathClone.sum(args));
        assertEquals(0, mathClone.sum());
    }

    @Test
    void argsException() {
        assertThrows(IllegalArgumentException.class, () -> mathClone.sum(null));
    }





}