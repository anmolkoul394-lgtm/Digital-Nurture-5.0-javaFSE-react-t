// StripeGateway.java
// A SECOND implementation of the same interface - this is exactly the situation
// that causes autowiring conflicts if we don't use @Qualifier.

import org.springframework.stereotype.Component;

@Component
public class StripeGateway implements PaymentGateway {
    @Override
    public void pay(int orderId, double amount) {
        System.out.println("Order #" + orderId + " paid via Stripe Gateway");
    }
}
