# Decorator Pattern (Structural)

## Theory
The **Decorator Pattern** lets you attach new behaviour to an object **dynamically**, by
wrapping it inside another "decorator" object, without changing the original class's code.
It's a flexible alternative to subclassing for extending functionality.

Real-world analogy: **ordering a coffee** and adding milk, sugar, or whipped cream — each
add-on "wraps" the base coffee and adds to its cost/description.

## When to use it
- When you want to add responsibilities to objects without affecting other objects of the same class.
- When subclassing would create too many rigid subclass combinations (e.g. `CoffeeWithMilkAndSugar`, `CoffeeWithMilkAndCream`...).

## Files
- `src/DecoratorDemo.java` – `Coffee` interface, `SimpleCoffee`, and `MilkDecorator` / `SugarDecorator` wrappers.

## Expected Output
```
Simple Coffee: Cost = 50.0
Coffee with Milk: Cost = 60.0
Coffee with Milk and Sugar: Cost = 65.0
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
