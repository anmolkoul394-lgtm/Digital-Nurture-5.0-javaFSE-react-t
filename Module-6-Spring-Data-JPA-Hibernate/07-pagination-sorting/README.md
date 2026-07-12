# Pagination and Sorting

Calling `findAll()` on a table with a million rows is a bad idea - you'd load the
whole thing into memory. `Pageable` and `Sort` let the database do the heavy lifting
and only return the slice of data you actually need.

## Pageable

```java
Pageable pageable = PageRequest.of(0, 2); // page index 0, 2 items per page
Page<Book> page = bookRepository.findAll(pageable);
```

`Page<T>` gives you more than just the data - `getTotalElements()`, `getTotalPages()`,
`hasNext()`, etc., all without an extra query on your part (Spring Data runs a COUNT
query behind the scenes for you).

## Sort

```java
Sort sort = Sort.by(Sort.Direction.DESC, "price");
List<Book> sorted = bookRepository.findAll(sort);
```

## Combining both

```java
Pageable pageable = PageRequest.of(0, 2, Sort.by("price").descending());
Page<Book> page = bookRepository.findAll(pageable);
```

## Files

- `src/main/java/Book.java`, `BookRepository.java` - `JpaRepository` already supports
  `findAll(Pageable)` and `findAll(Sort)` out of the box, no extra code needed on the repository.
- `src/main/java/PaginationSortingDemoApplication.java` - seeds 5 books, then fetches
  page 0 (2 items) sorted by price descending.

## Running it

```bash
mvn spring-boot:run
```

## Output

```
Page 0 of 3 total pages (5 books total)
Books on this page, sorted by price desc: [Clean Code (899.0), Effective Java (799.0)]
```

Reference: https://www.baeldung.com/spring-data-jpa-pagination-sorting
