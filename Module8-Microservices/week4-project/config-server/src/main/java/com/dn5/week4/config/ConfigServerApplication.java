package com.dn5.week4.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Module 8 -> "Spring Cloud Config" subtopic:
 * "Externalized configuration in microservices" + "Managing configuration
 * properties for different environments". Serves property files from
 * ../config-repo (native filesystem backend) to every microservice.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
