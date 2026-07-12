# Query Methods and Named Queries

## Derived query methods

Spring Data JPA can parse a method name into a working query, as long as you follow its
keyword conventions:

```java
List<Book> findByTitle(String title);
List<Book> findByPriceGreaterThan(double price);
List<Book> findByTitleContainingIgnoreCase(String keyword);
List<Book> findByTitleAndPriceLessThan(String title, double maxPrice);
```

Common keywords: `findBy`, `And`, `Or`, `Between`, `LessThan`, `GreaterThan`, `Like`,
`Containing`, `OrderBy`, `IgnoreCase`. Spring parses these at startup and builds the
actual SQL/JPQL automatically - no query text anywhere in your code.

## @Query - for anything the naming convention can't express well

```java
@Query("SELECT b FROM Book b WHERE b.price BETWEEN :min AND :max")
List<Book> findBooksInPriceRange(@Param("min") double min, @Param("max") double max);
```

This is JPQL (Java Persistence Query Language) - similar to SQL, but written against
entity names/fields instead of table/column names.

## Named queries

Instead of putting the query on the repository method itself, you can define it once
on the entity using `@NamedQuery`, and reference it by name:

```java
@NamedQuery(name = "Book.findExpensive", query = "SELECT b FROM Book b WHERE b.price > :threshold")
```

Less common in modern Spring Data JPA code (method-level `@Query` and derived methods
cover most cases), but still shows up in older codebases, so worth recognising.

## Files

- `src/main/java/Book.java` - includes a `@NamedQuery`.
- `src/main/java/BookRepository.java` - derived query methods, a custom `@Query`, and calling the named query.
- `src/main/java/QueryMethodsDemoApplication.java`

## Running it

```bash
mvn spring-boot:run
```

## Output

```
Derived query (findByTitleContainingIgnoreCase 'clean'): [Clean Code]
Custom @Query (price between 700 and 900): [Clean Code, Effective Java]
Named query (Book.findExpensive > 800): [Clean Code]
```

Reference: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
