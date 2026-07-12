// RazorpayGateway.java
// @Component tells Spring's component scan "manage this class as a bean" -
// no XML, no manual registration needed.

import org.springframework.stereotype.Component;

@Component
public class RazorpayGateway implements PaymentGateway {
    @Override
    public void pay(int orderId, double amount) {
        System.out.println("Annotation-based bean: Order #" + orderId + " paid via Razorpay Gateway");
    }
}
