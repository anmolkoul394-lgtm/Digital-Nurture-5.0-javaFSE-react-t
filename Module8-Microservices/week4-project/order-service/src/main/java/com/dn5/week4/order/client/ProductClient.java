package com.dn5.week4.order.client;

import com.dn5.week4.order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Module 8 -> "Microservices Communication with Spring Cloud" subtopic:
 * "Using Spring Cloud Feign for declarative REST clients".
 * "product-service" is resolved through Eureka (Service Discovery) - no
 * hard-coded host:port needed.
 */
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}
