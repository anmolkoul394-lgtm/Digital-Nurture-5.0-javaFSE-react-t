// TDDCycleDemo.java
// Simulates the TDD Red-Green-Refactor cycle WITHOUT any testing framework,
// so beginners can see the concept clearly before learning JUnit 5 (next topic).
//
// We "simulate" the 3 phases:
//   RED      - a test runs against code that doesn't work yet -> test FAILS.
//   GREEN    - minimal working code is added -> test PASSES.
//   REFACTOR - code is cleaned up/improved -> test STILL PASSES.

class Calculator {
    // GREEN phase implementation: the simplest code that makes the test pass.
    public int add(int a, int b) {
        return a + b;
    }
}

// A very small hand-written assertion helper, standing in for a real test framework.
class SimpleAssert {
    public static void assertEquals(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println("Test PASSED: " + testName + " = " + actual);
        } else {
            System.out.println("Test FAILED: " + testName + " returned " + actual + " but expected " + expected);
        }
    }
}

public class TDDCycleDemo {

    // This method represents the "before any implementation exists" state (RED phase).
    // A brand-new/incomplete method that always returns 0, standing in for "no code written yet".
    private static int addNotImplementedYet(int a, int b) {
        return 0; // intentionally wrong / incomplete - this is what makes the RED test fail
    }

    public static void main(String[] args) {
        // ---------------- RED phase ----------------
        // Arrange: we write the test FIRST, before real code exists.
        System.out.println("--- RED phase: running test before implementation exists ---");
        int a = 2, b = 3;
        // Act: call the (currently broken/incomplete) method
        int resultBeforeImplementation = addNotImplementedYet(a, b);
        // Assert: this will FAIL, because addNotImplementedYet always returns 0
        SimpleAssert.assertEquals("add(2, 3)", 5, resultBeforeImplementation);

        // ---------------- GREEN phase ----------------
        // Now we write the MINIMAL real implementation (see Calculator.add above) to pass the test.
        System.out.println("--- GREEN phase: minimal implementation added ---");
        Calculator calculator = new Calculator();
        int resultAfterImplementation = calculator.add(a, b);
        SimpleAssert.assertEquals("add(2, 3)", 5, resultAfterImplementation);

        // ---------------- REFACTOR phase ----------------
        // In a real project we might rename variables, remove duplication, improve
        // performance, etc. Here, Calculator.add() is already simple, so "refactoring"
        // just means re-running the SAME test to prove behaviour did not change.
        System.out.println("--- REFACTOR phase: code cleaned up, test still passes ---");
        int resultAfterRefactor = calculator.add(a, b);
        SimpleAssert.assertEquals("add(2, 3)", 5, resultAfterRefactor);
    }
}
