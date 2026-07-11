# SOLID Principles

## What & Why

**SOLID** is an acronym for five design principles that help developers write object-oriented code that is easy to **maintain, extend, and test**. They were popularized by Robert C. Martin ("Uncle Bob"). Following SOLID reduces "spaghetti code" and makes future changes cheaper and safer.

| Letter | Principle | One-line idea |
|---|---|---|
| S | Single Responsibility Principle (SRP) | A class should have only **one reason to change**. |
| O | Open-Closed Principle (OCP) | Classes should be **open for extension, closed for modification**. |
| L | Liskov Substitution Principle (LSP) | Subclasses must be **substitutable** for their base class without breaking behaviour. |
| I | Interface Segregation Principle (ISP) | Prefer many **small, specific interfaces** over one large interface. |
| D | Dependency Inversion Principle (DIP) | Depend on **abstractions**, not concrete implementations. |

Each principle below has its own runnable Java example inside `src/`, showing a "Bad" (violating) design and a "Good" (fixed) design.

---

### 1. Single Responsibility Principle — `src/SRPDemo.java`
A class should do **one job only**. Example: an `Invoice` class should not also know how to print itself or save itself to a database — those are separate responsibilities handled by separate classes (`InvoicePrinter`, `InvoiceRepository`).

**Expected Output:**
```
Invoice calculated: Total = 500.0
Printing invoice for: Customer - Raj, Total - 500.0
Saving invoice to database for customer: Raj
```

### 2. Open-Closed Principle — `src/OCPDemo.java`
Add new behaviour (new shapes) **without modifying** existing, tested code. We use an abstract `Shape` class and add new shapes by extending it, instead of editing an `AreaCalculator` with if-else chains.

**Expected Output:**
```
Area of Circle: 78.53981633974483
Area of Rectangle: 24.0
Area of Triangle: 6.0
Total Area: 108.53981633974483
```

### 3. Liskov Substitution Principle — `src/LSPDemo.java`
A subclass object should be usable wherever the parent type is expected, without surprising behaviour. Classic example: `Ostrich` should NOT extend a `Bird` that has a `fly()` method, since ostriches can't fly. We fix it by separating `FlyingBird` from `Bird`.

**Expected Output:**
```
Sparrow flies high in the sky
Ostrich runs fast on land
```

### 4. Interface Segregation Principle — `src/ISPDemo.java`
Don't force a class to implement methods it doesn't need. Instead of one fat `Worker` interface with `work()` and `eat()`, split into `Workable` and `Eatable`.

**Expected Output:**
```
Human working...
Human eating...
Robot working...
```

### 5. Dependency Inversion Principle — `src/DIPDemo.java`
High-level modules should depend on abstractions (interfaces), not concrete low-level classes. A `NotificationService` depends on a `MessageSender` interface, so we can swap `EmailSender` for `SmsSender` without changing `NotificationService`.

**Expected Output:**
```
Sending EMAIL: Welcome to our platform!
Sending SMS: Welcome to our platform!
```

## 📚 Reference
https://www.baeldung.com/solid-principles
