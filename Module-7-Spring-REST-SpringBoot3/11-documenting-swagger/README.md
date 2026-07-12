# Documenting RESTful APIs with Swagger / OpenAPI

## OpenAPI vs Swagger - which name means what

**OpenAPI** is the specification - a standard, language-agnostic format (JSON/YAML)
for describing a REST API's endpoints, request/response shapes, and auth requirements.
**Swagger** is the older name for the same ecosystem, and now mostly refers to the
tooling built around the spec (Swagger UI, the interactive browser-based docs page).

## springdoc-openapi

The library that generates an OpenAPI spec directly from your Spring annotations -
you barely have to write documentation by hand, most of it comes from the code
that already exists:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

Add this one dependency, run the app, and `/swagger-ui.html` already shows a working,
interactive page listing every endpoint - no extra config required to get started.

## Adding richer descriptions

The auto-generated docs are a good starting point, but usually need a bit of
annotation to be genuinely useful:

```java
@Operation(summary = "Get a task by id", description = "Returns a single task or 404 if not found")
@ApiResponse(responseCode = "200", description = "Task found")
@ApiResponse(responseCode = "404", description = "Task not found")
@GetMapping("/tasks/{id}")
public ResponseEntity<Task> getTask(@PathVariable Long id) { ... }
```

`@Schema` on model fields adds descriptions/examples to the request/response bodies
shown in the docs.

## Best practices

- Keep the docs close to the code (annotations, not a separate hand-maintained wiki
  page) so they don't silently go stale
- Document error responses, not just the happy path - `404`, `400` matter to whoever's
  integrating with the API
- Give the whole API a title/description/version via `@OpenAPIDefinition` so the docs
  page isn't just a bare list of endpoints

## Files

- `src/main/java/Task.java` - `@Schema` on fields for example values in the docs.
- `src/main/java/TaskController.java` - `@Operation` / `@ApiResponse` annotations.
- `src/main/java/OpenApiConfig.java` - overall API title/description/version.

## Running it

```bash
mvn spring-boot:run
```

Then open `http://localhost:8080/swagger-ui.html` in a browser - a full interactive
page listing every endpoint, with "try it out" buttons that fire real requests
against the running app.

## Output

```
Raw spec available at: http://localhost:8080/v3/api-docs
Interactive docs at:   http://localhost:8080/swagger-ui.html
```

Reference: https://www.geeksforgeeks.org/spring-boot-rest-api-documentation-using-swagger/
