# Test Driven Development (TDD) – Introduction

## What is TDD?
**Test Driven Development** is a software development approach where you **write the test
BEFORE writing the actual code**. Only after you have a failing test do you write the minimum
code needed to make it pass.

## TDD vs Traditional Testing
| Traditional Testing | TDD |
|---|---|
| Write code first, then test it | Write the test first, then the code |
| Testing often happens late / as an afterthought | Testing drives the design from the start |
| Bugs found later, more expensive to fix | Bugs caught immediately, cheaper to fix |

## Benefits of TDD
- Forces you to think about **requirements** before writing code.
- Gives you a **safety net** of tests so you can refactor confidently.
- Naturally leads to more **modular, testable** designs.
- Provides living **documentation** of what the code is supposed to do.

## The TDD Cycle: Red → Green → Refactor
1. **RED**   – Write a test for a feature that doesn't exist yet. It FAILS (there's no code to make it pass).
2. **GREEN** – Write the SIMPLEST possible code that makes the test PASS. Don't over-engineer.
3. **REFACTOR** – Clean up the code (remove duplication, improve names) while keeping the test green.
4. Repeat for the next small piece of functionality.

## Introduction to Unit Testing
A **Unit Test** verifies a single, small "unit" of code (usually one method) in isolation from
the rest of the system.

### Unit Testing vs Integration Testing
| Unit Testing | Integration Testing |
|---|---|
| Tests ONE class/method in isolation | Tests how MULTIPLE components work together |
| Fast, no database/network involved | Slower, may involve real DB/network/services |
| Dependencies are usually mocked | Real (or close-to-real) dependencies are used |

## Test Structure: Arrange-Act-Assert (AAA)
Every good unit test follows 3 steps:
1. **Arrange** – set up the objects and data needed for the test.
2. **Act** – call the method being tested.
3. **Assert** – check that the actual result matches the expected result.

### Test Fixtures, Setup & Teardown
A **test fixture** is the fixed environment/state needed before a test runs (e.g. a fresh
object, test data). **Setup** code prepares the fixture before each test; **teardown** code
cleans up after each test (closing connections, releasing resources). (JUnit's `@BeforeEach`
and `@AfterEach` annotations automate this — see `../02-junit5`.)

## Files
- `src/TDDCycleDemo.java` – A hand-rolled (no framework) simulation of the Red-Green-Refactor
  cycle for a `Calculator.add()` method, using simple custom assertions, so beginners can see
  the concept before we introduce the JUnit 5 framework in the next topic.

## Expected Output
```
--- RED phase: running test before implementation exists ---
Test FAILED: add(2, 3) returned 0 but expected 5
--- GREEN phase: minimal implementation added ---
Test PASSED: add(2, 3) = 5
--- REFACTOR phase: code cleaned up, test still passes ---
Test PASSED: add(2, 3) = 5
```

## 📚 References
- https://www.geeksforgeeks.org/test-driven-development-tdd/
- https://developer.ibm.com/articles/5-steps-of-test-driven-development/
- https://www.geeksforgeeks.org/unit-testing-software-testing/
- https://semaphore.io/blog/aaa-pattern-test-automation
