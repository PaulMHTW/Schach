package calculator;

import org.junit.*;
import org.junit.Test;

public class CalculatorTests {
    @Test
    public void test1() throws CalculatorException {
        Calculator myCalculator = new CalculatorImpl();
        int result = myCalculator.plus(1,1);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test2() throws CalculatorException {
        Calculator myCalculator = new CalculatorImpl();
        int result = myCalculator.plus(2,1);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test3() throws CalculatorException {
        Calculator myCalculator = new CalculatorImpl();
        int result = myCalculator.plus(Integer.MAX_VALUE,0);
        Assert.assertEquals(Integer.MAX_VALUE, result);
    }


    @Test(expected = CalculatorException.class)
    public void testBad1() throws CalculatorException {
        Calculator myCalculator = new CalculatorImpl();
        int result = myCalculator.plus(Integer.MAX_VALUE,1);
    }

    @Test(expected = CalculatorException.class)
    public void testBad2() throws CalculatorException {
        Calculator myCalculator = new CalculatorImpl();
        int result = myCalculator.plus(Integer.MIN_VALUE,-1);
    }

    @Test
    public void test4() throws CalculatorException {
        Calculator myCalculator = new CalculatorImpl();
        int result = myCalculator.plus(Integer.MIN_VALUE,1);
        Assert.assertEquals(Integer.MIN_VALUE+1, result);

        int[][] feld =
    }


}
