# Introduction to Spring Framework

Spring is a framework for building Java applications, built around one core idea:
**Inversion of Control (IoC)**. Instead of your code creating and wiring its own
dependencies, you hand that job to a container, and the container gives your objects
whatever they need.

## The problem Spring solves

Without a framework, if `OrderService` needs a `PaymentGateway`, you'd normally write:

```java
PaymentGateway gateway = new RazorpayGateway();
OrderService service = new OrderService(gateway);
```

This is fine in a toy program, but in a real application with hundreds of classes, this
gets messy fast - every class has to know how to build every dependency it needs, and
swapping an implementation means hunting down every `new` call.

## Inversion of Control (IoC) and Dependency Injection (DI)

IoC flips this: you just declare what a class needs (usually via constructor parameters),
and the **container** figures out how to build and inject that dependency at runtime.
DI is the mechanism that makes this happen - Spring literally "injects" the required
object into your class instead of your class going and fetching it.

## The main Spring modules

- **Core** - the IoC container itself (`ApplicationContext`, `BeanFactory`)
- **AOP** - lets you add cross-cutting behaviour (logging, security, transactions) without
  cluttering your business logic
- **Data Access** - JDBC templates, transaction management
- **ORM** - integration with Hibernate/JPA (this is where Module 6 lives)
- **MVC** - web layer, controllers, view resolution

## Why bother with Spring at all

- Less boilerplate wiring code
- Dependencies are easy to swap (mock them in tests, change implementations in prod)
- Encourages loosely coupled, testable design (this ties back directly into the
  Dependency Injection pattern from Week 1, Module 1)
- Huge ecosystem - Spring Boot, Spring Security, Spring Data, all built on this same core

## Files

`src/WithoutSpringDemo.java` - a plain Java program with no framework, showing manual
wiring, so you can compare it against the Spring-managed version in the next topic
(`../03-ioc-container`) once the container is actually doing the wiring for you.

## Output

```
Manually wired: Order #1001 paid via Razorpay Gateway
```

Reference: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/overview.html
