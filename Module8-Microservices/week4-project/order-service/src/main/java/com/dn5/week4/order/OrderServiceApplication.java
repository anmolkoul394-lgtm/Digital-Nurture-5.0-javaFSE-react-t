package com.dn5.week4.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Module 8 -> "Microservices Communication with Spring Cloud" subtopic:
 * @EnableFeignClients activates declarative REST clients (see
 * client/ProductClient.java) for calling product-service by its Eureka
 * service name instead of a hard-coded URL.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
