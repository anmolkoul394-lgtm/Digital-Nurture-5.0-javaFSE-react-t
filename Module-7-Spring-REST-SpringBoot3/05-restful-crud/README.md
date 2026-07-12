# RESTful CRUD Operations

This is where the in-memory list from earlier topics gets replaced with a real
(if in-memory H2) database, using Spring Data JPA from Module 6 - the REST layer just
sits on top of a `TaskRepository`.

## Mapping HTTP methods to CRUD

| HTTP Method | Operation | Endpoint |
|---|---|---|
| POST | Create | `/tasks` |
| GET | Read (all / one) | `/tasks`, `/tasks/{id}` |
| PUT | Update (full replace) | `/tasks/{id}` |
| DELETE | Delete | `/tasks/{id}` |

## Validating input

`@Valid` combined with Bean Validation annotations on the DTO rejects bad input before
it ever reaches your business logic:

```java
public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;
}
```

```java
@PostMapping("/tasks")
public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest request) { ... }
```

If validation fails, Spring throws `MethodArgumentNotValidException` automatically -
handled here with a `@ControllerAdvice`, same pattern as topic 3.

## Optimistic locking for concurrent updates

If two people fetch the same task, both edit it, and both save - one of those updates
would silently overwrite the other's without any protection. `@Version` adds a column
that Hibernate checks on every update; if the version doesn't match what's in the
database anymore, it throws `OptimisticLockException` instead of silently overwriting.

```java
@Version
private Long version;
```

## Files

- `src/main/java/Task.java` - now a real `@Entity`, includes `@Version`.
- `src/main/java/TaskRequest.java` - has `@NotBlank` validation.
- `src/main/java/TaskRepository.java` - extends `JpaRepository`.
- `src/main/java/TaskController.java` - full CRUD, `@Valid` on create/update.
- `src/main/java/GlobalExceptionHandler.java` - handles validation errors + optimistic lock conflicts.

## Running it

```bash
mvn spring-boot:run
```

```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":""}'
```

## Output

```
HTTP/1.1 400 Bad Request
Title is required
```

Reference: https://blog.treblle.com/understanding-restful-api-crud-operations/
