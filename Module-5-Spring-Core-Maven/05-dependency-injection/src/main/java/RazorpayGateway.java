// RazorpayGateway.java
// Named "razorpayGateway" bean (default bean name is the class name with a lowercase first letter).

import org.springframework.stereotype.Component;

@Component
public class RazorpayGateway implements PaymentGateway {
    @Override
    public void pay(int orderId, double amount) {
        System.out.println("Qualifier resolved to Razorpay: Order #" + orderId + " paid via Razorpay Gateway");
    }
}
