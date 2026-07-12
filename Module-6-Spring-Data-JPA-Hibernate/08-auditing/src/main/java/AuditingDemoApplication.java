// AuditingDemoApplication.java
// Saves a book, then updates it, so you can see createdDate stay fixed while
// lastModifiedDate moves forward - all filled in automatically, no manual timestamp code.

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuditingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditingDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            Book book = bookRepository.save(new Book("Clean Code", 899.0));
            System.out.println("After first save   -> createdBy=" + book.getCreatedBy()
                    + ", createdDate=" + book.getCreatedDate()
                    + ", lastModifiedDate=" + book.getLastModifiedDate());

            book.setPrice(749.0);
            Book updated = bookRepository.save(book);
            System.out.println("After second save   -> lastModifiedDate is now " + updated.getLastModifiedDate());
        };
    }
}
