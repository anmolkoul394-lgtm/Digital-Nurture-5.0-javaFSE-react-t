# Strategy Pattern (Behavioral)

## Theory
The **Strategy Pattern** lets you define a **family of algorithms**, put each one in a
separate class, and make them **interchangeable at runtime**. The client picks (or is given)
a strategy object and the context uses it without knowing exactly which algorithm is running.

Real-world analogy: choosing a **payment method** at checkout — Credit Card, PayPal, UPI — the
checkout process is the same, only the payment "strategy" changes.

## When to use it
- When you have multiple ways of doing the same task and want to switch between them easily.
- To avoid huge if-else / switch blocks that pick behaviour based on a type flag.

## Files
- `src/StrategyDemo.java` – `PaymentStrategy` interface with `CreditCardPayment` and `PayPalPayment`, used by `ShoppingCart`.

## Expected Output
```
Paid 1500.0 using Credit Card ending in 1234
Paid 800.0 using PayPal account: user@example.com
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
