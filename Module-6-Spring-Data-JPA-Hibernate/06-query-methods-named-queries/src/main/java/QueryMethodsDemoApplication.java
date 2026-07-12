// QueryMethodsDemoApplication.java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueryMethodsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryMethodsDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Clean Code", 899.0));
            bookRepository.save(new Book("Effective Java", 799.0));

            System.out.println("Derived query (findByTitleContainingIgnoreCase 'clean'): "
                    + bookRepository.findByTitleContainingIgnoreCase("clean"));

            System.out.println("Custom @Query (price between 700 and 900): "
                    + bookRepository.findBooksInPriceRange(700, 900));

            System.out.println("Named query (Book.findExpensive > 800): "
                    + bookRepository.findExpensive(800));
        };
    }
}
