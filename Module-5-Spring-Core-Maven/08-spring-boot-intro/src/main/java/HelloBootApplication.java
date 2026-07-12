// HelloBootApplication.java
// @SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration,
// all in one annotation. This is genuinely the entire setup needed to start a web app.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }
}
