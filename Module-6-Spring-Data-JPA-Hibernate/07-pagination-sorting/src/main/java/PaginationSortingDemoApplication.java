// PaginationSortingDemoApplication.java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class PaginationSortingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationSortingDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Clean Code", 899.0));
            bookRepository.save(new Book("Effective Java", 799.0));
            bookRepository.save(new Book("Refactoring", 699.0));
            bookRepository.save(new Book("Design Patterns", 599.0));
            bookRepository.save(new Book("Domain-Driven Design", 999.0));

            // page index 0, 2 books per page, sorted by price descending
            Pageable pageable = PageRequest.of(0, 2, Sort.by("price").descending());
            Page<Book> page = bookRepository.findAll(pageable);

            System.out.println("Page " + page.getNumber() + " of " + page.getTotalPages()
                    + " total pages (" + page.getTotalElements() + " books total)");
            System.out.println("Books on this page, sorted by price desc: " + page.getContent());
        };
    }
}
