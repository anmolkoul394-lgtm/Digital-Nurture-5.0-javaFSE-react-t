// OrderService.java
// @Service is really just @Component with a clearer name for the service layer.
// @Autowired on the constructor tells Spring to inject a matching PaymentGateway bean.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentGateway gateway;

    @Autowired
    public OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void checkout(int orderId, double amount) {
        gateway.pay(orderId, amount);
    }
}
