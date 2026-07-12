# RESTful HATEOAS

## The idea

HATEOAS (Hypermedia as the Engine of Application State) means a response doesn't just
return data - it also tells the client what it can DO next, by including links. Instead
of the client hardcoding "to delete a task, call DELETE /tasks/{id}", the server
includes that link directly in the response.

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "done": false,
  "_links": {
    "self": { "href": "/tasks/1" },
    "delete": { "href": "/tasks/1" },
    "all-tasks": { "href": "/tasks" }
  }
}
```

## Why bother

In theory, a HATEOAS-driven client doesn't need to know URL structures ahead of time -
it just follows links the server gives it, the same way a browser follows links on a
web page instead of hardcoding every URL on the site. In practice, most APIs skip this
(plain JSON without links is simpler and covers most needs), but it's common enough in
enterprise Spring codebases that it's worth knowing.

## Spring HATEOAS

The `spring-hateoas` library provides `EntityModel<T>` (wraps a single resource plus its
links) and `CollectionModel<T>` (wraps a list plus links), along with a fluent way to
build links without string-concatenating URLs by hand:

```java
EntityModel<Task> model = EntityModel.of(task,
        linkTo(methodOn(TaskController.class).getTask(task.getId())).withSelfRel(),
        linkTo(methodOn(TaskController.class).getAllTasks()).withRel("all-tasks"));
```

`linkTo(methodOn(...))` builds the URL by inspecting the controller method itself, so
if you ever change the mapping path, the link updates automatically instead of going stale.

## Files

- `src/main/java/Task.java`, `TaskRepository.java`
- `src/main/java/TaskController.java` - wraps responses in `EntityModel`/`CollectionModel` with links

## Running it

```bash
mvn spring-boot:run
curl http://localhost:8080/tasks/1
```

## Output

```
{
  "id": 1,
  "title": "Learn Spring Boot",
  "done": false,
  "_links": {
    "self": {"href": "http://localhost:8080/tasks/1"},
    "all-tasks": {"href": "http://localhost:8080/tasks"}
  }
}
```

Reference: https://www.geeksforgeeks.org/hateoas-and-why-its-needed-in-restful-api/
