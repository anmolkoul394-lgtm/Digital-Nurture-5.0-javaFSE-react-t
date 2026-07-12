# Module 7 - Spring REST using Spring Boot 3

REST APIs are how most modern applications talk to each other over HTTP - a mobile
app calling a backend, one microservice calling another, a React frontend calling a
Java backend. Spring Boot 3 (built on Spring Framework 6 and Jakarta EE 9+ namespaces)
is the current standard way to build these in the Java ecosystem.

| Topic | Folder |
|---|---|
| Intro to REST + what's new in Boot 3 | `01-intro-rest-spring-boot3` |
| A basic REST controller | `02-simple-rest-controller` |
| Request/response handling | `03-request-response-handling` |
| DTOs | `04-dto-representation` |
| Full CRUD | `05-restful-crud` |
| HATEOAS | `06-hateoas` |
| Content negotiation | `07-content-negotiation` |
| Actuator | `08-actuator-monitoring` |
| Security (JWT, CORS) | `09-security-authentication` |
| Testing | `10-testing-rest-apis` |
| API docs (Swagger) | `11-documenting-swagger` |

The example running through most of this module is a small **Task Manager API** - one
`Task` entity, growing a bit more capable with every topic (plain controller, then a
DTO layer, then full CRUD against a real repository, then HATEOAS links, security, and
so on).
