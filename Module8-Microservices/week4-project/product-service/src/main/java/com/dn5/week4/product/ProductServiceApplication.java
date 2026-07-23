package com.dn5.week4.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Module 8 -> "Microservices Architecture Overview" subtopic:
 * @EnableDiscoveryClient registers this service with the Eureka server
 * (discovery-server) so other services / the API Gateway can find it by
 * name ("product-service") instead of a fixed host:port.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
