# Spring Boot Actuator for REST Monitoring

## What Actuator gives you

Production-ready endpoints for monitoring your app's health, config, and metrics -
without writing any of that yourself:

| Endpoint | Shows |
|---|---|
| `/actuator/health` | Is the app (and its dependencies - DB, disk space) healthy? |
| `/actuator/info` | Build/version info you configure |
| `/actuator/metrics` | JVM memory, request counts, response times, and more |
| `/actuator/env` | Active configuration/environment properties |
| `/actuator/beans` | Every Spring bean currently loaded |

## Adding it

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

By default, only `/actuator/health` is exposed over HTTP - the rest need to be
explicitly opened up.

## Exposing endpoints

```properties
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
```

## Custom metrics

Beyond the built-in JVM/HTTP metrics, you can register your own using Micrometer
(bundled with Actuator):

```java
@Autowired
public TaskController(MeterRegistry meterRegistry) {
    this.tasksCreatedCounter = meterRegistry.counter("tasks.created");
}
// later: tasksCreatedCounter.increment();
```

## Securing Actuator endpoints

In a real deployment, you don't want `/actuator/env` or `/actuator/beans` open to the
public internet - they can leak configuration and internal structure. Common approach:
put Actuator on a separate management port, and/or require authentication for anything
beyond `/health` (this ties into the next topic, Spring Security).

## Files

- `src/main/resources/application.properties` - exposes health/info/metrics, shows health details.
- `src/main/java/TaskController.java` - increments a custom Micrometer counter on every task created.

## Running it

```bash
mvn spring-boot:run
curl http://localhost:8080/actuator/health
```

## Output

```
{"status":"UP","components":{"diskSpace":{"status":"UP", ...}}}
```

Reference: https://www.geeksforgeeks.org/spring-boot-actuator/
