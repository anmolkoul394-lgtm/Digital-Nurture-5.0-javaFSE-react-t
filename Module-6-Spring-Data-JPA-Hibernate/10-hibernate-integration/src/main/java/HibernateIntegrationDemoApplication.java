// HibernateIntegrationDemoApplication.java
// Saves a handful of books in a loop - with batch_size configured in
// application.properties, Hibernate groups these into fewer round-trips instead
// of one INSERT per save() call. Also shows @CreationTimestamp filling in
// automatically, without any Spring Data auditing setup.

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateIntegrationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateIntegrationDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            Book first = bookRepository.save(new Book("Clean Code", 899.0));
            bookRepository.save(new Book("Effective Java", 799.0));
            bookRepository.save(new Book("Refactoring", 699.0));

            System.out.println("Saved 3 books using batched inserts (see console for grouped Hibernate SQL statements)");
            System.out.println("First book createdAt (set by Hibernate automatically): " + first.getCreatedAt());
        };
    }
}
