# CRUD Operations with Spring Data JPA

The four basic operations, all provided by `JpaRepository` without writing a single
line of SQL or JDBC code.

| Operation | Method |
|---|---|
| Create | `save(entity)` |
| Read (one) | `findById(id)` |
| Read (all) | `findAll()` |
| Update | `save(entity)` again, on an entity that already has an id |
| Delete | `deleteById(id)` or `delete(entity)` |

## A subtlety worth knowing: save() does both create AND update

`save()` checks whether the entity's id is already set. If it's null, Hibernate does an
INSERT. If it's already set (and a row with that id exists), it does an UPDATE instead.
This is why there's no separate `update()` method - `save()` covers both.

## Files

- `src/main/java/Book.java` - the entity (kept a bit simpler here, no Author relation, to
  keep the CRUD example focused).
- `src/main/java/BookRepository.java`
- `src/main/java/CrudDemoApplication.java` - runs through create, read, update, delete in order.

## Running it

```bash
mvn spring-boot:run
```

## Output

```
CREATE -> saved book with id 1
READ   -> found: Clean Code, price 899.0
UPDATE -> new price: 749.0
DELETE -> remaining books after delete: []
```

Reference: https://medium.com/javarevisited/spring-boot-jpa-crud-with-example-bbd219b5d4a6
