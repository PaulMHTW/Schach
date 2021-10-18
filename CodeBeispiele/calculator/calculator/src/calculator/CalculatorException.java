package calculator;

public class CalculatorException extends Exception {
    public CalculatorException() { super(); }
    public CalculatorException(String message) { super(message); }
    public CalculatorException(String message, Throwable t) { super(message, t); }
}
