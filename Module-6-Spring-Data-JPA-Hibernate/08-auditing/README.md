# Auditing with Spring Data JPA

Auditing automatically tracks WHO created/modified a record and WHEN, without you
writing that logic yourself in every service method.

## Turning it on

```java
@EnableJpaAuditing
@SpringBootApplication
public class MyApplication { ... }
```

## The annotations

- `@CreatedDate` - set once, when the entity is first saved
- `@LastModifiedDate` - updated every time the entity is saved again
- `@CreatedBy` - the user who created the record (needs an `AuditorAware` bean to say
  who the "current user" is)
- `@LastModifiedBy` - same idea, for the most recent update

The entity also needs `@EntityListeners(AuditingEntityListener.class)` so Hibernate
actually calls into the auditing machinery on save/update.

## AuditorAware - telling Spring who's "logged in"

In a real app this would read the authenticated user from Spring Security. Here, to
keep the example self-contained, it just returns a fixed name.

```java
@Bean
public AuditorAware<String> auditorProvider() {
    return () -> Optional.of("system-user");
}
```

## Files

- `src/main/java/Book.java` - has `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, `@LastModifiedBy`.
- `src/main/java/AuditConfig.java` - the `AuditorAware` bean + `@EnableJpaAuditing`.
- `src/main/java/BookRepository.java`
- `src/main/java/AuditingDemoApplication.java` - saves a book, then updates it, and prints
  the audit fields to show they were filled in automatically.

## Running it

```bash
mvn spring-boot:run
```

## Output

```
After first save   -> createdBy=system-user, createdDate=2026-07-12T..., lastModifiedDate=2026-07-12T...
After second save   -> lastModifiedDate is now LATER than createdDate
```

Reference: https://docs.spring.io/spring-data/jpa/reference/auditing.html
