# Security and Authentication in RESTful APIs

## Spring Security basics for a REST API

Spring Security intercepts every request before it reaches your controller and
decides whether it's allowed through. For a REST API (no login forms/sessions), the
usual setup is **stateless** - no server-side session, every request proves who it is
on its own, typically via a token.

## Token-based authentication (JWT)

A JWT (JSON Web Token) is a signed, self-contained token - it carries the user's
identity and claims directly inside it, so the server can verify it without a
database lookup on every request (just checking the signature).

```
Client logs in -> server returns a JWT
Client sends "Authorization: Bearer <token>" on every later request
Server validates the token's signature and expiry, extracts the username, proceeds
```

This example keeps things minimal - a login endpoint issues a token, and a filter
checks it on every other request, without pulling in extra libraries beyond
`spring-boot-starter-security` plus the `jjwt` library for token creation/parsing.

## CORS (Cross-Origin Resource Sharing)

If your frontend (say, running on `localhost:3000`) calls this API (`localhost:8080`),
the browser blocks the request by default unless the server explicitly allows it -
that's CORS. Spring lets you configure this centrally:

```java
@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(List.of("http://localhost:3000"));
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    ...
}
```

## Files

- `src/main/java/AuthController.java` - a `/login` endpoint that issues a JWT for a hardcoded demo user.
- `src/main/java/JwtUtil.java` - creates and validates tokens.
- `src/main/java/JwtAuthFilter.java` - runs on every request, checks the `Authorization` header.
- `src/main/java/SecurityConfig.java` - wires the filter in, configures CORS, and marks `/tasks/**` as protected.
- `src/main/java/TaskController.java` - a protected endpoint.

## Running it

```bash
mvn spring-boot:run
```

```bash
curl -X POST http://localhost:8080/login -d '{"username":"admin","password":"admin123"}' -H "Content-Type: application/json"
curl http://localhost:8080/tasks -H "Authorization: Bearer <token from above>"
```

## Output

```
$ curl http://localhost:8080/tasks
{"error":"Unauthorized"}

$ curl http://localhost:8080/tasks -H "Authorization: Bearer eyJhbGciOi..."
[{"id":1,"title":"Learn Spring Security"}]
```

Reference: https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection
