// ProductRepositoryImpl.java
// A simple in-memory implementation of ProductRepository, so the Spring context
// has a real bean to wire into ProductService (needed for @SpringBootTest to load).

package com.dn5.springtesting;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Integer, Product> store = new HashMap<>();

    public ProductRepositoryImpl() {
        // Seed with some sample data
        store.put(1, new Product(1, "Laptop", 55000.0));
        store.put(2, new Product(2, "Mouse", 500.0));
    }

    @Override
    public Product findById(int id) {
        return store.get(id);
    }
}
