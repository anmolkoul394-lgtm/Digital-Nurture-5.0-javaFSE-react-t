# Mocking External Dependencies

## Theory

### Why mock external dependencies?
Code often depends on things OUTSIDE our control: databases, REST APIs, file systems, network
calls. In unit tests we want to be:
- **Fast** – no real network/disk I/O.
- **Reliable** – doesn't fail because an external service happened to be down.
- **Isolated** – tests only OUR logic, not the external system's behaviour.

Mockito lets us replace these external dependencies with mocks that we fully control.

### Mocking Databases and Repositories
Covered already in `../04-mockito` — mock the repository interface, stub its methods.

### Mocking External Services (e.g. RESTful APIs)
If our code calls another service through an interface (e.g. `PaymentGatewayClient`), we mock
that interface/client so tests never make a real HTTP call.

### Mocking File I/O and Network Interactions
Wrap file/network operations behind an interface (e.g. `FileStorageService`), then mock that
interface in tests — this is also a great example of the **Dependency Inversion Principle**
from Module 1.

### Strategies for Testing Code with External Dependencies
1. **Wrap the dependency behind an interface** — never call `new FileReader(...)` or
   `HttpClient` directly inside business logic; inject an abstraction instead.
2. **Mock the interface** in unit tests using Mockito.
3. Use a small number of **real integration tests** (with a real file/service/test-container)
   to verify the actual wrapper implementation separately.

## Files
- `src/main/java/PaymentGatewayClient.java` – interface representing an EXTERNAL payment API.
- `src/main/java/FileStorageService.java` – interface representing EXTERNAL file I/O.
- `src/main/java/OrderProcessor.java` – class under test; depends on BOTH external dependencies above.
- `src/test/java/OrderProcessorTest.java` – mocks both external dependencies to test `OrderProcessor` fully in isolation.

## ▶️ How to run
```bash
mvn test
```

## Expected Output (summary)
```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 📚 Reference
https://www.javacodegeeks.com/2024/12/mocking-repositories-and-daos-in-java-with-mockito.html
