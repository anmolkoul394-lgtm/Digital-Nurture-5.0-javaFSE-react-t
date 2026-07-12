// AutomationConceptDemo.java
// A small, framework-free simulation of how an automation testing TOOL works internally:
// it runs a list of test cases, compares actual vs expected results, and reports a summary.
// (Real tools like Selenium/JUnit do this at massive scale with much more functionality.)

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

// Represents one automated test case: a name, an "actual" value producer, and an expected value.
class TestCase {
    String name;
    Supplier<Integer> actualValueProvider;
    int expectedValue;

    TestCase(String name, Supplier<Integer> actualValueProvider, int expectedValue) {
        this.name = name;
        this.actualValueProvider = actualValueProvider;
        this.expectedValue = expectedValue;
    }
}

// A minimal "test runner" - the core idea behind every automation testing tool.
class TestRunner {
    private List<TestCase> testCases = new ArrayList<>();
    private int passed = 0;
    private int failed = 0;

    public void addTest(TestCase testCase) {
        testCases.add(testCase);
    }

    public void runAll() {
        System.out.println("Running automated test suite...");
        for (TestCase test : testCases) {
            int actual = test.actualValueProvider.get();
            if (actual == test.expectedValue) {
                System.out.println("[PASS] Test: " + test.name);
                passed++;
            } else {
                System.out.println("[FAIL] Test: " + test.name
                        + " (expected " + test.expectedValue + ", got " + actual + ")");
                failed++;
            }
        }
        System.out.println("Test Summary: " + passed + " passed, " + failed
                + " failed out of " + testCases.size());
    }
}

public class AutomationConceptDemo {
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();

        // Test 1: passes
        runner.addTest(new TestCase("Addition check", () -> 2 + 3, 5));

        // Test 2: passes
        runner.addTest(new TestCase("String reverse check",
                () -> new StringBuilder("abc").reverse().toString().equals("cba") ? 1 : 0, 1));

        // Test 3: intentionally fails, to show a FAIL report (e.g. integer division truncates)
        runner.addTest(new TestCase("Division check", () -> 9 / 2, 5));

        runner.runAll();
    }
}
