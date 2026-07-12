# Setting Up a Spring Boot Project with Spring Data JPA

## Dependencies needed

Two things on top of a normal Spring Boot project:
1. `spring-boot-starter-data-jpa` - brings in Hibernate + Spring Data JPA + transaction management
2. A JDBC driver for whichever database you're using - H2 here, since it needs zero setup

## application.properties

This is where the database connection lives:

```properties
spring.datasource.url=jdbc:h2:mem:bookdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

- `ddl-auto=update` tells Hibernate to create/update tables automatically based on your
  `@Entity` classes - handy for learning/dev, but in a real production app you'd normally
  use a proper migration tool (Flyway/Liquibase) instead of letting Hibernate touch the schema.
- The H2 console (`/h2-console`) gives you a browser-based SQL client to poke at the
  in-memory database while the app is running.

## Files

- `pom.xml` - Spring Boot + Spring Data JPA + H2.
- `src/main/resources/application.properties` - the datasource config above.
- `src/main/java/BookCatalogApplication.java` - the Boot entry point.

This folder is just the skeleton - `Book` the entity, and the repository, get added in
the next two topics as the project grows.

## Running it

```bash
mvn spring-boot:run
```

## Output

```
...
Hibernate: create table book (id bigint not null auto_increment, ...)
Started BookCatalogApplication in X.XXX seconds
```

Reference: https://www.javaguides.net/2021/12/how-to-use-spring-data-jpa-in-spring-boot-project.html
