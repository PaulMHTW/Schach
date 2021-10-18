package calculator;

public interface Calculator {
    /**
     * Adds two integer values and returns the sum.
     * @param a first value
     * @param b second value
     * @return sum
     * @throws CalculatorException overflow detected
     */
    int plus(int a, int b) throws CalculatorException;
}
