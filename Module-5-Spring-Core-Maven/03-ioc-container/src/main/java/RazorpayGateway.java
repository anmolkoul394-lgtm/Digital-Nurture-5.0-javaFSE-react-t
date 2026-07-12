// RazorpayGateway.java
public class RazorpayGateway implements PaymentGateway {
    @Override
    public void pay(int orderId, double amount) {
        System.out.println("Spring wired it for us: Order #" + orderId + " paid via Razorpay Gateway");
    }
}
