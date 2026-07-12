// BookRepository.java
// Extending JpaRepository is the ENTIRE implementation - Spring generates the rest.

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
