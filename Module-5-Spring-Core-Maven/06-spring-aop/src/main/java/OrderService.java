// OrderService.java
// The "target" bean - has no idea an aspect is watching it. That's the point of AOP:
// cross-cutting logic (logging here) is kept completely out of the business logic.

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String placeOrder(int orderId, double amount) {
        System.out.println("Order #" + orderId + " placed for amount " + amount);
        return "Order placed successfully";
    }
}
