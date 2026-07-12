// ProductServiceTest.java
// SERVICE LAYER TEST - a pure unit test using plain JUnit 5 + Mockito.
// Does NOT load the Spring context at all (fast!). ProductRepository is mocked manually.

package com.dn5.springtesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository; // mocked dependency

    @InjectMocks
    private ProductService productService; // Mockito injects the mock above into this

    @Test
    void testGetProductDescription_found() {
        when(productRepository.findById(1)).thenReturn(new Product(1, "Keyboard", 1500.0));

        String description = productService.getProductDescription(1);

        assertEquals("Keyboard costs $1500.0", description);
    }

    @Test
    void testGetProductDescription_notFound() {
        when(productRepository.findById(999)).thenReturn(null);

        String description = productService.getProductDescription(999);

        assertEquals("Product not found", description);
    }
}
