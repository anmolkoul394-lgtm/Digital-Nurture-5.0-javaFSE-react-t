# JUnit 5 Framework

## Theory

### Setting Up JUnit 5
JUnit 5 ("Jupiter") is added to a Maven project via the `junit-jupiter` dependency (see
`pom.xml` in this folder). Maven's Surefire plugin automatically discovers and runs any class
whose methods are annotated with `@Test`.

### Writing Basic JUnit Tests
A test class is a plain Java class. Each test method is annotated with `@org.junit.jupiter.api.Test`
and contains no return value (void).

### Assertions in JUnit
Assertions (from `org.junit.jupiter.api.Assertions`) check that actual results match expectations:
- `assertEquals(expected, actual)`
- `assertTrue(condition)` / `assertFalse(condition)`
- `assertNull(obj)` / `assertNotNull(obj)`
- `assertThrows(Exception.class, () -> { ... })`

### Test Structure: Arrange-Act-Assert (AAA)
Every test method below follows this structure:
```java
@Test
void testSomething() {
    // Arrange - set up test data
    Calculator calculator = new Calculator();
    // Act - call the method under test
    int result = calculator.add(2, 3);
    // Assert - verify the result
    assertEquals(5, result);
}
```

### Test Fixtures, Setup and Teardown
- `@BeforeEach` – runs BEFORE every test method (e.g. create a fresh object).
- `@AfterEach`  – runs AFTER every test method (e.g. clean up resources).
- `@BeforeAll`  – runs ONCE before ALL tests in the class (must be `static`).
- `@AfterAll`   – runs ONCE after ALL tests in the class (must be `static`).

## Project Structure
```
02-junit5
├── pom.xml
└── src
    ├── main/java/Calculator.java     <- class under test
    └── test/java/CalculatorTest.java <- JUnit 5 tests
```

## ▶️ How to run
```bash
mvn test
```

## Expected Output (Maven test summary)
```
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 📚 Reference
https://www.geeksforgeeks.org/introduction-to-junit-5/
