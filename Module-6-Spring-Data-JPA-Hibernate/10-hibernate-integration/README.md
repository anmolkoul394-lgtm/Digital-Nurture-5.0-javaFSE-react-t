# Spring Data JPA and Hibernate

Everything in this module has actually been running on Hibernate the whole time -
Spring Data JPA is a layer on top, Hibernate is the engine doing the real work
underneath. This last topic pulls back the curtain a bit and uses some
Hibernate-specific features directly, instead of staying purely inside the
JPA-standard API.

## Hibernate-specific annotations worth knowing

- `@DynamicUpdate` - by default Hibernate's UPDATE statement includes every column,
  even ones that didn't change. This annotation makes it only update columns that
  actually changed - useful on wide entities.
- `@Fetch(FetchMode.SUBSELECT)` / `@BatchSize` - control how related collections are
  loaded, to avoid the classic "N+1 query" problem (one query per parent to fetch its
  children, instead of one batched query).
- `org.hibernate.annotations.CreationTimestamp` / `@UpdateTimestamp` - a simpler,
  Hibernate-only alternative to Spring Data's `@CreatedDate`/`@LastModifiedDate` from
  the auditing topic - handled by Hibernate itself, no `@EnableJpaAuditing` needed.

## Hibernate dialect

Hibernate needs to know which flavour of SQL to generate - `spring.jpa.database-platform`
(or Boot's auto-detection based on the datasource URL) sets this. Different databases
have different quirks (e.g. `LIMIT` vs `ROWNUM`), and the dialect abstracts that away.

## Batch processing

For bulk inserts/updates, Hibernate can batch multiple statements into fewer round-trips
to the database:

```properties
spring.jpa.properties.hibernate.jdbc.batch_size=20
spring.jpa.properties.hibernate.order_inserts=true
```

Without this, saving 1000 entities in a loop sends 1000 separate INSERT statements.

## Files

- `src/main/java/Book.java` - uses `@CreationTimestamp` (Hibernate-specific, not the
  Spring Data auditing annotations from the earlier topic) and `@DynamicUpdate`.
- `src/main/resources/application.properties` - batch size + dialect settings.
- `src/main/java/HibernateIntegrationDemoApplication.java` - saves several books in a
  loop to show batching configured, and prints the Hibernate-managed timestamp.

## Running it

```bash
mvn spring-boot:run
```

## Output

```
Saved 3 books using batched inserts (see console for grouped Hibernate SQL statements)
First book createdAt (set by Hibernate automatically): 2026-07-12T...
```

Reference: https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac
