# Module 6 - Spring Data JPA with Spring Boot, Hibernate

Spring Data JPA sits on top of Hibernate (the actual ORM implementation) and removes
almost all the boilerplate you'd normally write by hand with plain JPA/Hibernate -
in most cases you just declare an interface and Spring generates the implementation
for you at runtime.

All the runnable examples in this module use the same running example - a small
"Book" catalog - and build on each other topic by topic. They use H2, an in-memory
database, so everything runs with `mvn spring-boot:run` with zero external setup.

| Topic | Folder |
|---|---|
| Introduction to Spring Data JPA | `01-intro-spring-data-jpa` |
| Project setup | `02-project-setup` |
| Entity Mapping | `03-entity-mapping` |
| Spring Data Repositories | `04-spring-data-repositories` |
| CRUD Operations | `05-crud-operations` |
| Query Methods and Named Queries | `06-query-methods-named-queries` |
| Pagination and Sorting | `07-pagination-sorting` |
| Auditing | `08-auditing` |
| Projections | `09-projections` |
| Spring Data JPA and Hibernate | `10-hibernate-integration` |

Each folder's `pom.xml` includes `spring-boot-starter-data-jpa` + the H2 driver, so
they can each be run independently without needing a shared parent project.
