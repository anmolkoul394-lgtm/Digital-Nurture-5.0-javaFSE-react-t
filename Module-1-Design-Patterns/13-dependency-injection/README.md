# Dependency Injection (DI) (Architectural)

## Theory
**Dependency Injection** is a technique where an object's dependencies (the other objects it
needs to do its job) are **provided ("injected") from the outside**, instead of the object
creating them itself with `new`. This is a practical application of the **Dependency Inversion
Principle** (see `../01-solid-principles`).

## Three common types of DI
1. **Constructor Injection** – dependency is passed through the constructor (most recommended).
2. **Setter Injection** – dependency is set through a public setter method.
3. **Interface/Field Injection** – dependency is provided through a special method or annotation
   (this is what frameworks like Spring do automatically with `@Autowired`).

## Why it matters
- Makes code **loosely coupled** – classes don't need to know how to construct their dependencies.
- Makes code **easy to test** – you can inject a mock/fake dependency during unit testing.
- Foundation of the **Spring Framework's IoC (Inversion of Control) Container**.

## Files
- `src/DependencyInjectionDemo.java` – Shows Constructor Injection and Setter Injection with a `Car` and `Engine`.

## Expected Output
```
Constructor Injection -> Petrol Engine started
Setter Injection -> Diesel Engine started
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
