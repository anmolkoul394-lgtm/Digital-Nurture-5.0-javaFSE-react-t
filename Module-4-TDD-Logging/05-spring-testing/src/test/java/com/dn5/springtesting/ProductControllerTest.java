// ProductControllerTest.java
// CONTROLLER (WEB) LAYER TEST - uses @WebMvcTest to load ONLY the web layer
// (much faster than a full @SpringBootTest), and @MockBean to replace ProductService
// with a Mockito mock that is automatically registered in the (sliced) Spring context.

package com.dn5.springtesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc; // simulates HTTP requests WITHOUT starting a real server

    @MockBean
    private ProductService productService; // fake service, registered into the Spring test context

    @Test
    void testGetDescriptionEndpoint() throws Exception {
        when(productService.getProductDescription(1)).thenReturn("Laptop costs $55000.0");

        mockMvc.perform(get("/products/1/description"))
                .andExpect(status().isOk())
                .andExpect(content().string("Laptop costs $55000.0"));
    }
}
