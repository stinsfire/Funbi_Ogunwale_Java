package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }


    // Test for divide method
    @Test
    public void shouldDividePositives() {

        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {

        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

    // Test for add method
    @Test
    public void shouldAddPositives() {

        assertEquals(8, calc.add(5,3));
        assertEquals(76, calc.add(37, 39));
        assertEquals(75, calc.add(15, 60));
    }

    @Test
    public void shouldAddNegatives() {

        assertEquals(-15, calc.add(-8,-7));
        assertEquals(-54, calc.add(-16, -38));
        assertEquals(-216, calc.add(-160, -56));
    }

    @Test
    public void shouldAddBothPosAndNeg() {

        assertEquals(-1, calc.add(-8,+7));
        assertEquals(22, calc.add(-16, +38));
        assertEquals(-104, calc.add(-160, 56));
    }


    // Test for subtract method
    @Test
    public void shouldSubtractPositives() {

        assertEquals(2, calc.subtract(5,3));
        assertEquals(30, calc.subtract(42, 12));
        assertEquals(45, calc.subtract(60, 15));
    }

    @Test
    public void shouldSubtractNegatives() {

        assertEquals(-1, calc.subtract(-8,-7));
        assertEquals(22, calc.subtract(-16, -38));
        assertEquals(-104, calc.subtract(-160, -56));
    }

    @Test
    public void shouldSubtractBothPosAndNeg() {

        assertEquals(-15, calc.subtract(-8,7));
        assertEquals(-54, calc.subtract(-16, 38));
        assertEquals(-216, calc.subtract(-160, 56));
    }


    // Test for multiply method
    @Test
    public void shouldMultiplyPositives() {

        assertEquals(15, calc.multiply(5,3));
        assertEquals(504, calc.multiply(42, 12));
        assertEquals(900, calc.multiply(60, 15));
    }

    @Test
    public void shouldMultiplyNegatives() {

        assertEquals(56, calc.multiply(-8,-7));
        assertEquals(608, calc.multiply(-16, -38));
        assertEquals(8960, calc.multiply(-160, -56));
    }

    @Test
    public void shouldMultiplyBothPosAndNeg() {

        assertEquals(-56, calc.multiply(-8,7));
        assertEquals(-608, calc.multiply(-16, 38));
        assertEquals(-8960, calc.multiply(-160, 56));
    }

    @Test
    public void shouldMultiplyZero() {

        assertEquals(0, calc.multiply(-8,0));
        assertEquals(0, calc.multiply(0, 38));
        assertEquals(0, calc.multiply(0, 56));
    }
}
