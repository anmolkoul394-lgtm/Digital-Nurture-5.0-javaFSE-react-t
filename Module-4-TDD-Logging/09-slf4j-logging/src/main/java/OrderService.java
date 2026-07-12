// OrderService.java
// Demonstrates SLF4J logging: obtaining a Logger, logging at every level,
// parameterized logging (efficient, avoids unnecessary string building),
// and logging an exception together with its stack trace.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    // Standard way to obtain an SLF4J logger for this class.
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void processOrder(int orderId, double amount) {
        // DEBUG - detailed info, useful only during development
        log.debug("Processing order with id: {}", orderId);

        // Simulate successful processing
        log.info("Order {} processed successfully for amount {}", orderId, amount);
    }

    public void checkStock(String productName, int quantity) {
        if (quantity < 5) {
            // WARN - something worth noticing, but not breaking anything
            log.warn("Low stock warning for product: {}", productName);
        }
    }

    public void riskyCalculation(int orderId) {
        try {
            int result = 100 / 0; // deliberately causes an exception
        } catch (ArithmeticException exception) {
            // ERROR - log the message AND the exception (includes the stack trace)
            log.error("Failed to process order " + orderId, exception);
        }
    }

    public static void main(String[] args) {
        log.info("Application started");

        OrderService orderService = new OrderService();
        orderService.processOrder(101, 2500.0);
        orderService.checkStock("Keyboard", 2);
        orderService.riskyCalculation(999);
    }
}
