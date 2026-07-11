# Week 3 — Spring REST using Spring Boot 3 (Module 7)

DN5.0 Java FSE learning plan ke **Week 3 / Module 7** ke saare subtopics ka
complete, runnable Spring Boot 3 REST API — ek Book Management system ke roop mein.

## Tech stack
Java 17 · Spring Boot 3.2.5 · Spring Data JPA (H2) · Spring HATEOAS ·
Spring Security + JWT · Spring Boot Actuator · Springdoc OpenAPI (Swagger) ·
JUnit 5 + Mockito + MockMvc

## Har subtopic kahan implement hai

| Key Topic | Sub-topic | File(s) |
|---|---|---|
| Intro to Spring REST / Boot 3 | Setup, Jakarta EE annotations | `Week3Application.java`, `pom.xml` |
| Simple REST Controller | Request mappings, HTTP methods, JSON response | `controller/BookController.java` |
| Request/Response Handling | Path vars, query params, custom headers/status, exception handling | `BookController.java`, `exception/RestExceptionHandler.java` |
| DTOs | Request/response DTOs, entity mapping, XML serialization | `dto/*`, `mapper/BookMapper.java` |
| RESTful CRUD | Create/Read/Update/Delete, validation, optimistic locking | `BookController.java`, `service/BookService.java`, `entity/Book.java` (`@Version`) |
| HATEOAS | Self/collection links | `mapper/BookModelAssembler.java` |
| Content Negotiation | JSON + XML, Accept header / `?mediaType=` | `application.properties`, `BookController.java` produces |
| Actuator | Health, metrics, custom info | `application.properties` (`management.*`, `info.*`) |
| Security & Auth | Spring Security, JWT, CORS | `config/SecurityConfig.java`, `security/JwtUtil.java`, `security/JwtAuthFilter.java`, `controller/AuthController.java` |
| Testing | JUnit + Mockito + MockMvc unit tests, integration tests | `test/.../controller/BookControllerTest.java`, `test/.../integration/BookApiIntegrationTest.java` |
| Documentation | Swagger / OpenAPI | `config/OpenApiConfig.java`, `@Tag`/`@Operation` in controllers |

## Run locally
```bash
mvn spring-boot:run
```
- API base: `http://localhost:8080/api/books`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- Actuator health: `http://localhost:8080/actuator/health`
- H2 console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:week3db`)

## Auth flow
1. `POST /api/auth/login` with `{"username":"admin","password":"admin123"}` → returns a JWT.
2. Use it as `Authorization: Bearer <token>` for `POST/PUT/DELETE /api/books/**` (GET is public for the demo).

## Content negotiation demo
```
GET /api/books?mediaType=xml     -> XML response
GET /api/books                   -> JSON response (default)
```

## Run tests
```bash
mvn test
```

## GitHub pe push karna
```bash
git init
git add .
git commit -m "Week 3: Spring REST using Spring Boot 3 (Module 7)"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## Reference (source plan)
Har topic ke original learning links Week 3 sheet ke `Learning Reference Links`
column mein already hain — is project ko unke saath side-by-side padhein.
