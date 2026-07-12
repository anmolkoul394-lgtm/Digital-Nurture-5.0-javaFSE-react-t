// BookRepository.java
// Shows all three approaches: derived query methods, a custom @Query, and calling
// a @NamedQuery declared on the Book entity.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Derived query - Spring parses this method name into a working query automatically.
    List<Book> findByTitleContainingIgnoreCase(String keyword);

    // Custom JPQL query, for something the naming convention doesn't express cleanly.
    @Query("SELECT b FROM Book b WHERE b.price BETWEEN :min AND :max")
    List<Book> findBooksInPriceRange(@Param("min") double min, @Param("max") double max);

    // Calls the @NamedQuery declared on the Book entity ("Book.findExpensive").
    // Spring matches this method to the named query by convention (EntityName.methodName).
    List<Book> findExpensive(double threshold);
}
