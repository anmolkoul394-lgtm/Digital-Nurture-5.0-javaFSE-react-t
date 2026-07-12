// ProjectionsDemoApplication.java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ProjectionsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectionsDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Clean Code", 899.0));
            bookRepository.save(new Book("Effective Java", 799.0));

            List<String> titles = bookRepository.findByPriceGreaterThan(500).stream()
                    .map(BookTitleOnly::getTitle)
                    .collect(Collectors.toList());
            System.out.println("Interface projection (title only): " + titles);

            System.out.println("DTO projection (title + price): " + bookRepository.findSummaries(500));
        };
    }
}
