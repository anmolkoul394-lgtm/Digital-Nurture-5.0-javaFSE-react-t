# Spring Data JPA Projections

Sometimes you don't need the whole entity back - just a couple of fields. Fetching
the entire `Book` (and any related `Author` data) when you only need the title is
wasteful. Projections let a repository method return a smaller, purpose-built shape
of the data instead.

## Interface-based projections

```java
public interface BookTitleOnly {
    String getTitle();
}
```

Spring Data proxies this interface at runtime and only pulls back the `title` column
needed to satisfy it - not the whole entity.

```java
List<BookTitleOnly> findByPriceGreaterThan(double price);
```

## Class-based (DTO) projections

Instead of an interface, you can project directly into a plain constructor:

```java
@Query("SELECT new BookSummary(b.title, b.price) FROM Book b WHERE b.price > :min")
List<BookSummary> findSummaries(@Param("min") double min);
```

This is a "constructor expression" - JPQL calls the `BookSummary` constructor directly
with the selected columns.

## Interface vs class-based - when to use which

- **Interface projections** - simpler, less code, good for read-only "just some fields" views.
- **Class (DTO) projections** - needed when you want to combine/transform data (e.g. computed
  fields), or when the projection needs to travel outside the persistence layer as a proper object.

## Files

- `src/main/java/Book.java`
- `src/main/java/BookTitleOnly.java` - interface projection
- `src/main/java/BookSummary.java` - DTO/class projection
- `src/main/java/BookRepository.java` - one method for each style
- `src/main/java/ProjectionsDemoApplication.java`

## Running it

```bash
mvn spring-boot:run
```

## Output

```
Interface projection (title only): [Clean Code, Effective Java]
DTO projection (title + price): [Clean Code costs 899.0, Effective Java costs 799.0]
```

Reference: https://docs.spring.io/spring-data/jpa/reference/repositories/projections.html
