# Request and Response Handling

## Path variables and query parameters (quick recap)

```java
@GetMapping("/tasks/{id}")
public Task getTask(@PathVariable Long id) { ... }

@GetMapping("/tasks/search")
public List<Task> search(@RequestParam String keyword) { ... }
```

## Request body vs form data

`@RequestBody` deserializes a JSON body into a Java object (the common case for a
JSON API). If you're handling classic HTML form submissions instead, Spring binds
form fields with `@ModelAttribute` or plain `@RequestParam` per field - less common
in a pure REST API, but worth knowing it's there.

## Customizing response status and headers

By default a successful controller method returns HTTP 200. Use `ResponseEntity` when
you need more control:

```java
@PostMapping("/tasks")
public ResponseEntity<Task> createTask(@RequestBody Task task) {
    Task saved = save(task);
    return ResponseEntity
            .status(HttpStatus.CREATED)          // 201, not 200 - more correct for a creation
            .header("X-Custom-Header", "task-api")
            .body(saved);
}
```

## Exception handling in REST controllers

Without any handling, an unexpected exception turns into a generic 500 error with a
raw stack trace leaking to the client - not great. `@ExceptionHandler` (scoped to one
controller) or a `@ControllerAdvice` class (applies globally, across every controller)
lets you turn exceptions into proper, structured error responses.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TaskNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

## Files

- `src/main/java/Task.java`, `TaskNotFoundException.java`
- `src/main/java/TaskController.java` - uses `ResponseEntity` for status/headers,
  throws `TaskNotFoundException` when a task doesn't exist
- `src/main/java/GlobalExceptionHandler.java` - `@ControllerAdvice`
- `src/main/java/TaskApiApplication.java`

## Running it

```bash
mvn spring-boot:run
```

```bash
curl -i http://localhost:8080/tasks/99
```

## Output

```
HTTP/1.1 404 Not Found
Content-Type: text/plain;charset=UTF-8

Task with id 99 was not found
```

Reference: https://medium.com/@tericcabrel/validate-request-body-and-parameter-in-spring-boot-53ca77f97fe9
