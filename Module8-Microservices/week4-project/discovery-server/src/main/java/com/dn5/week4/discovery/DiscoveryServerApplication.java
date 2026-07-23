package com.dn5.week4.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Module 8 -> "Design Patterns" subtopic: "Service Registry and Discovery".
 * This is the Eureka Server all other microservices register themselves
 * with, so the API Gateway / Feign clients can find them by logical name
 * instead of a hard-coded host:port.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
