// BookRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Interface projection - the return type itself tells Spring what to select.
    List<BookTitleOnly> findByPriceGreaterThan(double price);

    // Class/DTO projection via a JPQL constructor expression.
    @Query("SELECT new BookSummary(b.title, b.price) FROM Book b WHERE b.price > :min")
    List<BookSummary> findSummaries(@Param("min") double min);
}
