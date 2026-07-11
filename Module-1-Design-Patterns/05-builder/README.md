# Builder Pattern (Creational)

## Theory
The **Builder Pattern** helps construct a **complex object step by step**, especially when
the object has many optional fields. It avoids "telescoping constructors" — constructors with
too many parameters that are hard to read and error-prone (e.g. `new Computer("i7", 16, 512, true, true, false)`).

Instead, you chain readable method calls:
```java
Computer computer = new Computer.Builder("i7", 16)
                        .setStorage(512)
                        .setGraphicsCard(true)
                        .build();
```

## When to use it
- When an object requires many parameters, several of which are optional.
- When you want immutable objects with a readable construction process.

## Files
- `src/BuilderDemo.java` – `Computer` class with a nested static `Builder` class.

## Expected Output
```
Computer Configuration: CPU=Intel i7, RAM=16GB, Storage=512GB SSD, GraphicsCard=true, Bluetooth=false
Computer Configuration: CPU=AMD Ryzen 5, RAM=8GB, Storage=256GB SSD, GraphicsCard=false, Bluetooth=true
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
