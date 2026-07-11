// StrategyDemo.java
// Demonstrates the Strategy Design Pattern.
// ShoppingCart (the "context") delegates the actual payment logic
// to a PaymentStrategy object, which can be swapped at runtime.

// Strategy interface - common contract for every payment algorithm.
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategy #1
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        String last4Digits = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid " + amount + " using Credit Card ending in " + last4Digits);
    }
}

// Concrete strategy #2
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal account: " + email);
    }
}

// Context class - uses a PaymentStrategy but doesn't care WHICH one.
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // The strategy can be set (or changed) at runtime.
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card strategy
        cart.setPaymentStrategy(new CreditCardPayment("1111222233331234"));
        cart.checkout(1500.0);

        // Switch to PayPal strategy at runtime - ShoppingCart code doesn't change
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(800.0);
    }
}
