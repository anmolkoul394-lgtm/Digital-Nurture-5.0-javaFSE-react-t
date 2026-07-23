package com.dn5.week4.product.controller;

import com.dn5.week4.product.entity.Product;
import com.dn5.week4.product.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Module 8 -> "Inter-Service Communication" subtopic (Synchronous REST):
 * order-service calls these endpoints through a Feign client.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Injected from config-server's product-service.yml -> demonstrates
    // "Externalized configuration in microservices"
    @Value("${app.discount-percentage:0}")
    private int discountPercentage;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/config-info")
    public String configInfo() {
        return "Discount percentage from Config Server: " + discountPercentage + "%";
    }
}
