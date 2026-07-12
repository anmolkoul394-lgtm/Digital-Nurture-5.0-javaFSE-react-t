# Testing Spring Applications with JUnit and Mockito

## Theory

### Overview of Spring Testing
The `spring-boot-starter-test` dependency bundles JUnit 5, Mockito, AssertJ, and Spring's own
test utilities, giving you everything needed to test Spring Boot applications at different levels.

### Testing Controllers, Services, and Repositories
| Layer | Typical annotation | What it tests |
|---|---|---|
| Service | Plain JUnit + Mockito (`@ExtendWith(MockitoExtension.class)`) | Business logic in isolation, repository mocked |
| Controller | `@WebMvcTest` | Only the web layer (routing, JSON, status codes) — service is mocked |
| Full app | `@SpringBootTest` | Loads the FULL Spring context — true integration test |

### Integration Testing with Spring Boot
`@SpringBootTest` starts the actual Spring application context (or a slice of it), so
components are wired together exactly as they would be in production. Slower than unit tests,
but catches wiring/configuration issues that mocked unit tests cannot.

### Mocking Dependencies in Spring Tests
`@MockBean` (Spring Boot Test) creates a Mockito mock and automatically **registers it in the
Spring context**, replacing the real bean — so a controller test can mock the service layer
without needing a real database.

## Files
- `src/main/java/com/dn5/springtesting/Product.java` – simple model.
- `src/main/java/com/dn5/springtesting/ProductRepository.java` – repository interface.
- `src/main/java/com/dn5/springtesting/ProductService.java` – `@Service` layer, depends on the repository.
- `src/main/java/com/dn5/springtesting/ProductController.java` – `@RestController`, depends on the service.
- `src/main/java/com/dn5/springtesting/SpringTestingDemoApplication.java` – `@SpringBootApplication` entry point.
- `src/test/java/com/dn5/springtesting/ProductServiceTest.java` – **Service layer** unit test (Mockito, no Spring context).
- `src/test/java/com/dn5/springtesting/ProductControllerTest.java` – **Controller layer** test using `@WebMvcTest` + `MockMvc` + `@MockBean`.
- `src/test/java/com/dn5/springtesting/SpringTestingDemoApplicationTests.java` – **Integration test** using `@SpringBootTest` (context-loads smoke test).

## ▶️ How to run
```bash
mvn test
```

## Expected Output (summary)
```
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 📚 References
- https://www.geeksforgeeks.org/testing-in-spring-boot/
- https://www.geeksforgeeks.org/autowired-injectmocks-spring-boot-tests/
