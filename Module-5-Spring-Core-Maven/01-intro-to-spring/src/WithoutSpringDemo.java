// WithoutSpringDemo.java
// Plain Java, no framework - shows the "manual wiring" problem Spring is built to solve.
// Compare this with 03-ioc-container, where Spring itself creates and wires these objects.

interface PaymentGateway {
    void pay(int orderId, double amount);
}

class RazorpayGateway implements PaymentGateway {
    @Override
    public void pay(int orderId, double amount) {
        System.out.println("Manually wired: Order #" + orderId + " paid via Razorpay Gateway");
    }
}

class OrderService {
    private final PaymentGateway gateway;

    // We have to manually pass the dependency in ourselves - nobody is doing this for us.
    public OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void checkout(int orderId, double amount) {
        gateway.pay(orderId, amount);
    }
}

public class WithoutSpringDemo {
    public static void main(String[] args) {
        // We have to know exactly which implementation to build, every single time.
        PaymentGateway gateway = new RazorpayGateway();
        OrderService orderService = new OrderService(gateway);

        orderService.checkout(1001, 2599.0);
    }
}
