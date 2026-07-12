// OrderService.java
// With TWO PaymentGateway beans in the context, @Autowired alone would be ambiguous.
// @Qualifier tells Spring exactly which bean name to inject.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentGateway gateway;

    @Autowired
    public OrderService(@Qualifier("razorpayGateway") PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void checkout(int orderId, double amount) {
        gateway.pay(orderId, amount);
    }
}
