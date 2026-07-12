// ProductService.java
// Service layer - contains business logic, depends on ProductRepository.

package com.dn5.springtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getProductDescription(int id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            return "Product not found";
        }
        return product.getName() + " costs $" + product.getPrice();
    }
}
