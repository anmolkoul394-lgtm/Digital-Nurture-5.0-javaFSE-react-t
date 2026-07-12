// CalculatorTest.java
// Demonstrates JUnit 5 basics: @Test, assertions, and the AAA (Arrange-Act-Assert) pattern,
// plus @BeforeEach / @AfterEach lifecycle hooks (test fixtures / setup & teardown).

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    private Calculator calculator; // the "test fixture" - fresh instance for every test

    // Runs BEFORE each test method - guarantees every test starts with a clean object.
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: created a new Calculator instance");
    }

    // Runs AFTER each test method - used here just to demonstrate the hook.
    @AfterEach
    void tearDown() {
        System.out.println("Teardown: test finished");
    }

    @Test
    void testAdd() {
        // Arrange
        int a = 2, b = 3;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void testSubtract() {
        // Arrange
        int a = 10, b = 4;
        // Act
        int result = calculator.subtract(a, b);
        // Assert
        assertEquals(6, result, "10 - 4 should equal 6");
    }

    @Test
    void testIsEvenTrue() {
        assertTrue(calculator.isEven(8), "8 should be even");
    }

    @Test
    void testIsEvenFalse() {
        assertFalse(calculator.isEven(7), "7 should NOT be even");
    }

    @Test
    void testDivideByZeroThrowsException() {
        // assertThrows checks that the given code block throws the expected exception type.
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
