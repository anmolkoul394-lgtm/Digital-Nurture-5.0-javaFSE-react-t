# Building a Simple REST Controller

## @RestController

Marks a class as a controller where every method's return value goes straight into
the HTTP response body (as JSON, by default), instead of being resolved to a view
template like a traditional `@Controller` would do.

## Request mappings

```java
@GetMapping("/tasks")        // handles GET  /tasks
@PostMapping("/tasks")       // handles POST /tasks
@PutMapping("/tasks/{id}")   // handles PUT  /tasks/{id}
@DeleteMapping("/tasks/{id}")// handles DELETE /tasks/{id}
```

These are all shorthand for the more general `@RequestMapping(method = ...)`.

## Returning JSON automatically

Return a Java object from a controller method, and Spring (via Jackson, bundled in
`spring-boot-starter-web`) serializes it into JSON automatically - no manual
`JSONObject` building required.

```java
@GetMapping("/tasks")
public List<Task> getAllTasks() {
    return tasks; // becomes a JSON array in the response body
}
```

## Files

- `src/main/java/Task.java` - a plain model class (no database yet - that comes in
  `05-restful-crud`; for now it's just an in-memory list, so the focus stays purely
  on the controller/HTTP layer).
- `src/main/java/TaskController.java` - GET, POST, PUT, DELETE all handled.
- `src/main/java/TaskApiApplication.java` - Boot entry point.

## Running it

```bash
mvn spring-boot:run
```

```bash
curl http://localhost:8080/tasks
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Buy milk"}'
```

## Output

```
$ curl http://localhost:8080/tasks
[{"id":1,"title":"Learn Spring Boot","done":false}]

$ curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Buy milk"}'
{"id":2,"title":"Buy milk","done":false}
```

Reference: https://www.geeksforgeeks.org/easiest-way-to-create-rest-api-using-spring-boot/
