package com.dn5.week7.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}

@RestController
class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from the Module 12 CI/CD demo!";
    }
}
