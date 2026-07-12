# Automation Testing – Introduction

## Theory

### What is Automation Testing?
**Automation Testing** uses software tools to execute test cases automatically, compare
actual outcomes with expected outcomes, and report results — instead of a human manually
clicking through an application every time.

### Manual Testing vs Automation Testing
| Manual Testing | Automation Testing |
|---|---|
| A human performs each test step | A script/tool performs each test step |
| Slow, repetitive, error-prone for regression | Fast, repeatable, consistent |
| Good for exploratory/usability testing | Good for repetitive regression testing |
| No coding needed | Requires scripting/coding skill |

### Benefits of Automation Testing
- **Speed** – runs hundreds of tests in minutes.
- **Reusability** – the same test suite runs again and again (e.g. every code commit, in CI/CD).
- **Accuracy** – removes human error from repetitive checks.
- **Early bug detection** – can run on every commit/build (continuous testing).

### Where does Unit Testing fit in?
Unit tests (JUnit, Mockito — Modules 2-6 above) are themselves a form of automation testing,
focused on the smallest units of code. **UI automation** (next topic — Selenium) extends this
idea to test through the actual user interface, simulating real user actions in a browser.

### The Automation Testing Pyramid
```
        /\
       /UI\        <- few, slow, expensive (e.g. Selenium)
      /----\
     /Integr.\      <- some, medium speed (e.g. @SpringBootTest)
    /--------\
   /   Unit    \    <- many, fast, cheap (e.g. JUnit + Mockito)
  /--------------\
```
The pyramid shows: write MANY fast unit tests, FEWER integration tests, and only a SMALL
number of slow, expensive UI automation tests.

## Files
- `src/AutomationConceptDemo.java` – a small, framework-free simulation of an automated test
  "runner" that executes a list of test cases and reports PASS/FAIL, illustrating the core
  idea behind automation testing tools before we introduce Selenium in the next topic.

## Expected Output
```
Running automated test suite...
[PASS] Test: Addition check
[PASS] Test: String reverse check
[FAIL] Test: Division check (expected 5, got 4)
Test Summary: 2 passed, 1 failed out of 3
```

## 📚 Reference
https://www.geeksforgeeks.org/automation-testing-software-testing/
