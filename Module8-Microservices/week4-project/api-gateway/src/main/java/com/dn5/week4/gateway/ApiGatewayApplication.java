package com.dn5.week4.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Module 8 -> "API Gateway and Edge Services" subtopic:
 * "Configuring API Gateway with Spring Cloud Gateway" - single entry point
 * that routes to product-service / order-service by their Eureka service
 * ids (lb://product-service, lb://order-service), which also gives
 * client-side load balancing for free.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
