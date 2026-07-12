# Introduction to Spring REST and Spring Boot 3

## What REST actually means

REST (Representational State Transfer) isn't a library or a protocol - it's a set of
conventions for designing HTTP APIs:
- Resources are identified by URLs (`/tasks`, `/tasks/5`)
- HTTP methods carry meaning (GET = read, POST = create, PUT/PATCH = update, DELETE = remove)
- Responses are usually JSON, and the server doesn't keep session state between requests
  (each request carries everything needed to process it - "stateless")

## Why Spring for this

Spring Boot removes almost all the plumbing - routing, JSON conversion, exception
handling - so you write a method, annotate it, and it becomes a working endpoint.
No servlet config, no manual JSON parsing.

## What changed in Spring Boot 3

A few things matter if you're coming from Boot 2:
- **Java 17 baseline** - Boot 3 requires at least Java 17 (this whole repo already
  targets 17, so nothing changes for us here)
- **Jakarta EE namespace** - `javax.*` packages became `jakarta.*`
  (`javax.persistence.Entity` → `jakarta.persistence.Entity`) - you'll notice this in
  every `@Entity` import across this module
- **Spring Framework 6** underneath, with native/AOT compilation support for GraalVM
  (not something we need for these small examples, but worth knowing it exists)
- **Observability improvements** - Actuator and Micrometer got tighter integration
  (see `08-actuator-monitoring`)

## Setting up a Spring Boot 3 project for REST

Just one starter needed to begin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

This pulls in Spring MVC, an embedded Tomcat server, and Jackson (for JSON
serialization) - everything needed for a basic REST API, in one dependency.

This topic is conceptual - the actual controller shows up in the next folder,
`02-simple-rest-controller`.

Reference: https://www.geeksforgeeks.org/spring-boot-introduction-to-restful-web-services/
