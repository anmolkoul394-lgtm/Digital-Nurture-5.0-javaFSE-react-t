// BookRepository.java
// findAll(Pageable) and findAll(Sort) both come free from JpaRepository - no custom code needed.

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
