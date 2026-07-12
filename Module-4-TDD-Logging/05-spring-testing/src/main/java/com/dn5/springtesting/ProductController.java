// ProductController.java
// Web (REST) layer - handles HTTP requests, depends on ProductService.

package com.dn5.springtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}/description")
    public String getDescription(@PathVariable int id) {
        return productService.getProductDescription(id);
    }
}
