# Mockito Basics

## Theory

### Introduction to Mockito
**Mockito** is a popular Java mocking framework used in unit tests to create **fake ("mock")**
versions of objects that a class depends on. This lets you test a class **in isolation**,
without needing real databases, network calls, or other slow/unpredictable dependencies.

### Mocking and Stubbing
- **Mocking** – creating a fake object: `UserRepository mockRepo = mock(UserRepository.class);`
- **Stubbing** – telling the mock what to return when a method is called:
  `when(mockRepo.findById(1)).thenReturn(new User("Alice"));`

### Verifying Interactions
`verify(mockRepo).findById(1);` checks that a method was actually CALLED on the mock — useful
to confirm your code interacts with dependencies as expected.

### Argument Matching
Instead of exact values, you can match by TYPE/pattern: `when(mockRepo.findById(anyInt()))...`
`anyInt()`, `anyString()`, `eq(value)` are common argument matchers.

### Handling Void Methods
Methods that return `void` can't use `when(...).thenReturn(...)`. Instead use:
`doNothing().when(mockRepo).delete(1);` or `doThrow(...).when(mockRepo).delete(1);`

## Files
- `src/main/java/User.java` – simple data class.
- `src/main/java/UserRepository.java` – interface representing a dependency (e.g. a database layer).
- `src/main/java/UserService.java` – class under test; DEPENDS on `UserRepository`.
- `src/test/java/UserServiceTest.java` – uses Mockito to mock `UserRepository` and test `UserService` in isolation.

## ▶️ How to run
```bash
mvn test
```

## Expected Output (summary)
```
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 📚 Reference
https://www.javacodegeeks.com/mockito-tutorials
