// OrderProcessor.java
// The class UNDER TEST. Depends on TWO external dependencies:
//   1. PaymentGatewayClient - an external payment API
//   2. FileStorageService   - external file I/O
// Both are injected via the constructor, so both can be mocked in tests.

public class OrderProcessor {
    private final PaymentGatewayClient paymentGatewayClient;
    private final FileStorageService fileStorageService;

    public OrderProcessor(PaymentGatewayClient paymentGatewayClient, FileStorageService fileStorageService) {
        this.paymentGatewayClient = paymentGatewayClient;
        this.fileStorageService = fileStorageService;
    }

    // Processes an order: charges the card (external API call), then saves a receipt (external file I/O).
    // Returns true if the whole process succeeded.
    public boolean processOrder(String orderId, String cardNumber, double amount) {
        boolean paymentSuccessful = paymentGatewayClient.charge(cardNumber, amount);

        if (!paymentSuccessful) {
            return false;
        }

        String receiptContent = "Order " + orderId + ": charged $" + amount;
        fileStorageService.saveReceipt(orderId, receiptContent);

        return true;
    }
}
