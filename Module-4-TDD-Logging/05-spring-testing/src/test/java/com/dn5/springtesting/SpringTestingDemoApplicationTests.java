// SpringTestingDemoApplicationTests.java
// INTEGRATION TEST - @SpringBootTest loads the FULL Spring application context,
// wiring real beans together (ProductController -> ProductService -> ProductRepositoryImpl).
// This is slower than the unit tests above, but verifies the whole app actually wires up correctly.

package com.dn5.springtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringTestingDemoApplicationTests {

    @Autowired
    private ProductController productController; // real bean, fully wired

    // "Context loads" smoke test - fails automatically if any bean fails to wire.
    @Test
    void contextLoads() {
        assertNotNull(productController);
    }

    @Test
    void testEndToEndDescription() {
        // Product with id=1 ("Laptop") was seeded in ProductRepositoryImpl.
        String description = productController.getDescription(1);
        assertEquals("Laptop costs $55000.0", description);
    }
}
