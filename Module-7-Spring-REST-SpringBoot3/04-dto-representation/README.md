# RESTful Resource Representation with DTOs

## Why not just return the entity directly

It's tempting to return your JPA `@Entity` straight from a controller, but that
usually leaks things you don't want exposed - internal fields, lazy-loaded
relationships that blow up when Jackson tries to serialize them, password hashes,
audit columns. A **DTO (Data Transfer Object)** is a separate, plain class shaped
exactly like what the API should expose.

```
Entity (Task)  --mapped to-->  DTO (TaskResponse)  --serialized to-->  JSON sent to client
```

## Mapping entities to DTOs

For a small project, mapping by hand in a converter method is perfectly fine (and
easy to follow, no extra library needed):

```java
public TaskResponse toDto(Task task) {
    return new TaskResponse(task.getId(), task.getTitle(), task.isDone());
}
```

For larger projects, libraries like MapStruct generate this mapping code for you at
compile time - not used here, to keep the example dependency-free and easy to read.

## Customizing JSON serialization

Jackson annotations control exactly how a DTO turns into JSON:
- `@JsonProperty("custom_name")` - rename a field in the JSON output
- `@JsonIgnore` - exclude a field entirely
- `@JsonFormat` - control how dates/numbers are formatted

## Separate request vs response DTOs

Notice `TaskRequest` (what the client sends) and `TaskResponse` (what the API
returns) are two different classes here, even though they look similar - this keeps
input and output independently versionable. A request DTO might not need an `id`
field at all (the server assigns it), while a response DTO always includes one.

## Managing versioning and backward compatibility

Adding a new field to a DTO is safe (older clients just ignore fields they don't
know about). Removing or renaming a field is a breaking change - common ways to
handle it: version the URL (`/v1/tasks`, `/v2/tasks`) or version via a custom
`Accept` header (tied into the next topic, content negotiation).

## Files

- `src/main/java/Task.java` - the internal entity-like model (has a field we don't
  want exposed: `internalNotes`).
- `src/main/java/TaskRequest.java` - what the client sends when creating a task.
- `src/main/java/TaskResponse.java` - what the API sends back (no `internalNotes`).
- `src/main/java/TaskController.java` - converts between entity and DTOs.

## Running it

```bash
mvn spring-boot:run
curl http://localhost:8080/tasks
```

## Output

```
[{"id":1,"title":"Learn Spring Boot","done":false}]
```

Notice `internalNotes` never appears in the response - it's simply not part of `TaskResponse`.

Reference: https://www.moesif.com/blog/technical/api-design/REST-API-Design-Best-Practices-for-Sub-and-Nested-Resources/
