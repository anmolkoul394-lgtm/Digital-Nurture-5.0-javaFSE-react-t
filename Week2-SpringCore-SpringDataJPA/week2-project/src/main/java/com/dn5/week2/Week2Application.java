package com.dn5.week2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Module 5 - "Spring Boot (Introduction)" subtopic:
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 * This single annotation demonstrates "convention over configuration".
 *
 * @EnableJpaAuditing turns on Module 6 -> "Auditing with Spring Data JPA".
 */
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class Week2Application {

    public static void main(String[] args) {
        SpringApplication.run(Week2Application.class, args);
    }
}
