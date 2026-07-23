package com.dn5.week4.order.controller;

import com.dn5.week4.order.dto.ProductDTO;
import com.dn5.week4.order.entity.Order;
import com.dn5.week4.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestParam Long productId, @RequestParam Integer quantity) {
        return orderService.placeOrder(productId, quantity);
    }

    // Demonstrates the Feign call + Circuit Breaker in isolation
    @GetMapping("/check-product/{productId}")
    public ProductDTO checkProduct(@PathVariable Long productId) {
        return orderService.getProduct(productId);
    }
}
