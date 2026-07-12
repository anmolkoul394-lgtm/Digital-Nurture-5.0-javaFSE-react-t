// PaymentGatewayClient.java
// Represents an EXTERNAL dependency - a real implementation would call a payment
// provider's REST API over the network. We depend on this INTERFACE, not a concrete
// HTTP client, so it can be mocked in tests (Dependency Inversion Principle).

public interface PaymentGatewayClient {
    boolean charge(String cardNumber, double amount);
}
