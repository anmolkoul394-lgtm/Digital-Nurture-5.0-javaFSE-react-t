// CrudDemoApplication.java
// Walks through Create -> Read -> Update -> Delete, in that order, using only
// JpaRepository's built-in methods.

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            // CREATE
            Book book = bookRepository.save(new Book("Clean Code", 899.0));
            System.out.println("CREATE -> saved book with id " + book.getId());

            // READ
            Optional<Book> found = bookRepository.findById(book.getId());
            found.ifPresent(b -> System.out.println("READ   -> found: " + b.getTitle() + ", price " + b.getPrice()));

            // UPDATE - fetch, change a field, save again (same id -> Hibernate does an UPDATE, not an INSERT)
            Book toUpdate = bookRepository.findById(book.getId()).orElseThrow();
            toUpdate.setPrice(749.0);
            bookRepository.save(toUpdate);
            System.out.println("UPDATE -> new price: " + bookRepository.findById(book.getId()).get().getPrice());

            // DELETE
            bookRepository.deleteById(book.getId());
            System.out.println("DELETE -> remaining books after delete: " + bookRepository.findAll());
        };
    }
}
