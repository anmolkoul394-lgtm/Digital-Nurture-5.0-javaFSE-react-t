// OrderService.java
public class OrderService {
    private final PaymentGateway gateway;

    // Spring calls this constructor and passes in the gateway bean automatically,
    // based on the <constructor-arg ref="paymentGateway"/> line in beans.xml.
    public OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void checkout(int orderId, double amount) {
        gateway.pay(orderId, amount);
    }
}
