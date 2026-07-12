# Introduction to Spring Data JPA

## JPA vs Hibernate vs Spring Data JPA - these three names get mixed up a lot

- **JPA (Jakarta Persistence API)** - just a specification (a set of interfaces/annotations).
  It doesn't do anything by itself.
- **Hibernate** - an actual implementation of JPA. This is the library doing the real
  work of turning your Java objects into SQL and back.
- **Spring Data JPA** - a layer on top of JPA that removes even more boilerplate. Instead
  of writing `EntityManager` code yourself, you declare a repository interface and Spring
  generates the implementation at runtime.

```
Your Code
   |
Spring Data JPA   <- you write an interface, Spring implements it
   |
JPA               <- the specification/contract
   |
Hibernate         <- the actual ORM engine that talks to the DB
   |
JDBC / Database
```

## What you get for free

Without Spring Data JPA, even a simple "find a book by id" needs an `EntityManager`,
a query, transaction handling, and exception translation - written by hand, in every
DAO class, for every entity. With Spring Data JPA:

```java
public interface BookRepository extends JpaRepository<Book, Long> {
    // findById(), save(), delete(), findAll() all already exist - nothing to implement
}
```

That's genuinely the whole repository. Spring generates a working implementation of this
interface at application startup.

## Why this matters in a real project

- Way less repetitive DAO code across a big application
- Consistent transaction handling out of the box
- Query methods derived from method names (see `06-query-methods-named-queries`)
- Works nicely with Spring Boot's auto-configuration - just add the starter dependency
  and a datasource URL, and the rest configures itself

This topic is theory only - the actual working project starts in the next folder,
`02-project-setup`.

Reference: https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
