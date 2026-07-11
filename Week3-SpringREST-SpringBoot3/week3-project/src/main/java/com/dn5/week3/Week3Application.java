package com.dn5.week3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Module 7 -> "Introduction to Spring REST and Spring Boot 3" subtopic.
 * Spring Boot 3 requires Java 17+ and moved to Jakarta EE (jakarta.* instead
 * of javax.*) — used throughout this project's entity/validation annotations.
 */
@SpringBootApplication
public class Week3Application {
    public static void main(String[] args) {
        SpringApplication.run(Week3Application.class, args);
    }
}
