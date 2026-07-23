package com.dn5.week4.order.service;

import com.dn5.week4.order.client.ProductClient;
import com.dn5.week4.order.dto.ProductDTO;
import com.dn5.week4.order.entity.Order;
import com.dn5.week4.order.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Module 8 -> "Design Patterns" subtopic: "Circuit Breaker" +
 * "Fault Tolerance and Resilience" subtopic: fallback mechanisms.
 *
 * If product-service is down/slow, the circuit trips and callers get the
 * fallbackProduct() response instead of hanging or cascading the failure.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Value("${app.product-service-fallback-message:Product service unavailable}")
    private String fallbackMessage;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackProduct")
    public ProductDTO getProduct(Long productId) {
        return productClient.getProductById(productId);
    }

    // Fallback signature must match: same params + a Throwable
    public ProductDTO fallbackProduct(Long productId, Throwable throwable) {
        return new ProductDTO(productId, fallbackMessage, 0.0, 0);
    }

    public Order placeOrder(Long productId, Integer quantity) {
        // Calls product-service (through the circuit breaker) to confirm
        // the product exists before creating the order.
        ProductDTO product = getProduct(productId);

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus(product.stock() != null && product.stock() >= quantity ? "CONFIRMED" : "PENDING_STOCK");
        return orderRepository.save(order);
    }
}
