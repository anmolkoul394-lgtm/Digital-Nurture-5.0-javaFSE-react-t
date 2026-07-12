// Calculator.java
// A simple class under test (CUT) for demonstrating JUnit 5 basics.

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            // Throwing an exception on invalid input - lets us demonstrate assertThrows()
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
