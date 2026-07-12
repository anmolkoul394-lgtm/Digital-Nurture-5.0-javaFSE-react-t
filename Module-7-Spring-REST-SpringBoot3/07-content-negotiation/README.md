# Content Negotiation and Media Types

## What it is

The same endpoint returning different formats (JSON vs XML) depending on what the
client asks for, via the `Accept` header:

```
Accept: application/json   -> server returns JSON
Accept: application/xml    -> server returns XML
```

Spring picks the right `HttpMessageConverter` for the job automatically, as long as
the right library is on the classpath (Jackson for JSON, which is already included by
`spring-boot-starter-web`; Jackson's XML module for XML).

## Enabling XML support

Just adding the dependency is enough - Spring Boot's auto-configuration detects it and
registers an XML converter automatically, no extra config needed:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

## Producing/consuming specific media types explicitly

You can restrict a mapping to only handle (or only respond with) certain types:

```java
@GetMapping(value = "/tasks", produces = MediaType.APPLICATION_XML_VALUE)
public List<Task> getTasksAsXml() { ... }
```

## Custom media types

Sometimes an API defines its own versioned media type instead of relying purely on
URL versioning:

```
Accept: application/vnd.taskapi.v1+json
```

Spring can match on this exact string in `produces`/`consumes`, letting you serve
different response shapes for the same URL based on API version.

## Files

- `src/main/java/Task.java` - needs `@JacksonXmlRootElement` so the XML output has a sensible root tag.
- `src/main/java/TaskController.java` - same endpoint responds with JSON or XML depending on `Accept`.

## Running it

```bash
mvn spring-boot:run
```

```bash
curl -H "Accept: application/json" http://localhost:8080/tasks
curl -H "Accept: application/xml"  http://localhost:8080/tasks
```

## Output

```
$ curl -H "Accept: application/json" http://localhost:8080/tasks
[{"id":1,"title":"Learn Spring Boot","done":false}]

$ curl -H "Accept: application/xml" http://localhost:8080/tasks
<List><item><id>1</id><title>Learn Spring Boot</title><done>false</done></item></List>
```

Reference: https://maheshbonagiri.medium.com/spring-boot-and-content-negotiation-183b20eaa425
