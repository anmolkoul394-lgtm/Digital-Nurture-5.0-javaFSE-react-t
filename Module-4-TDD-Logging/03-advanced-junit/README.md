# Advanced JUnit Features

## Theory

### Parameterized Tests
Instead of writing a separate `@Test` method for each input, `@ParameterizedTest` lets you run
the SAME test logic against MULTIPLE sets of input data, supplied via `@ValueSource`,
`@CsvSource`, `@MethodSource`, etc.

### Test Suites and Categories
JUnit 5 lets you group and select tests using **Tags** (`@Tag("fast")`, `@Tag("slow")`) and
the JUnit Platform Suite engine, so you can run only a subset of tests (e.g. only fast unit
tests during development, full suite in CI).

### Test Execution Order
By default, JUnit 5 test method order is **not guaranteed**. You can force a specific order
using `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)` combined with `@Order(n)` on
each method — useful when tests must run in sequence (though independent tests are usually
better practice).

### Exception Testing
`assertThrows(ExceptionType.class, executable)` verifies that a block of code throws the
expected exception (see also `../02-junit5/src/test/java/CalculatorTest.java`).

### Timeout and Performance Testing
`assertTimeout(Duration, executable)` fails the test if the code takes LONGER than the given
duration to run — useful for catching performance regressions or infinite loops early.

## Files
- `src/main/java/StringUtils.java` – class under test.
- `src/test/java/AdvancedJUnitTest.java` – demonstrates parameterized tests, ordered tests,
  tags, exception testing, and timeout testing.

## ▶️ How to run
```bash
mvn test
```

## Expected Output (summary)
```
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 📚 References
- https://www.geeksforgeeks.org/junit-5-how-to-write-parameterized-tests/
- https://www.geeksforgeeks.org/junit-5-test-suites-with-example/
- https://www.geeksforgeeks.org/junit-5-test-execution-order/
- https://www.geeksforgeeks.org/junit-5-timeout/
