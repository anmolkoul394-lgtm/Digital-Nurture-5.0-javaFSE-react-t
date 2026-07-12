# Testing RESTful APIs

Same layered approach as Module 4 in Week 1, applied specifically to a REST
controller - unit test the controller in isolation, then a full integration test
that hits real HTTP endpoints against an in-memory server.

## Unit testing the controller with JUnit and Mockito

`@WebMvcTest` loads only the web layer (fast), and `@MockBean` replaces the service
with a mock so the test never touches a real database:

```java
@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired MockMvc mockMvc;
    @MockBean TaskService taskService;
    ...
}
```

## MockMvc

Simulates HTTP requests against your controllers WITHOUT starting a real server -
much faster than firing actual HTTP calls, while still exercising routing, JSON
(de)serialization, and status codes exactly as they'd behave in production.

```java
mockMvc.perform(get("/tasks/1"))
       .andExpect(status().isOk())
       .andExpect(jsonPath("$.title").value("Learn Spring Boot"));
```

## Integration testing with a real (random) port

`@SpringBootTest(webEnvironment = RANDOM_PORT)` starts the full app on a random free
port, and `TestRestTemplate` makes actual HTTP calls against it - closer to a real
client, slower than `MockMvc`, but catches wiring issues a pure unit test can't.

## Test coverage and best practices

- Unit test the controller logic (validation, status codes, error handling) with
  `MockMvc` + mocks - these should be the majority of your tests, they're fast
- A handful of `@SpringBootTest` integration tests to confirm the whole thing wires
  together and actually talks to the database correctly
- Test the unhappy paths too (404s, validation failures) - not just the happy path

## Files

- `src/main/java/Task.java`, `TaskService.java`, `TaskController.java`
- `src/test/java/TaskControllerTest.java` - `@WebMvcTest` + `MockMvc`, service mocked
- `src/test/java/TaskApiIntegrationTest.java` - `@SpringBootTest` with a real random port

## Running it

```bash
mvn test
```

## Output (summary)

```
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

Reference: https://www.baeldung.com/integration-testing-a-rest-api
