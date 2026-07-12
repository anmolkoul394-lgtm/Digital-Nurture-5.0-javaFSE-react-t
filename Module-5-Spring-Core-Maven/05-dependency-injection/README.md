# Dependency Injection in Spring

Week 1 covered DI as a general concept (constructor vs setter injection, plain Java).
This topic is the same idea, but shows how Spring specifically implements it, plus a
couple of Spring-only concerns: what happens when there's more than one bean of the
same type, and the difference between `@Autowired`, `@Resource` and `@Inject`.

## Constructor injection (preferred)

```java
@Service
public class OrderService {
    private final PaymentGateway gateway;

    @Autowired
    public OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }
}
```

Preferred because the object is never in a half-initialized state, and it works well
with `final` fields and immutability.

## Setter injection

```java
@Autowired
public void setGateway(PaymentGateway gateway) {
    this.gateway = gateway;
}
```

Useful for optional dependencies, but generally constructor injection is recommended
for anything the bean actually requires to function.

## The autowiring conflict problem

If you have two beans implementing `PaymentGateway` (say `RazorpayGateway` and
`StripeGateway`), Spring won't know which one to inject and will throw
`NoUniqueBeanDefinitionException`. You resolve this with `@Qualifier`:

```java
@Autowired
public OrderService(@Qualifier("razorpayGateway") PaymentGateway gateway) { ... }
```

## @Resource and @Inject

These are alternatives to `@Autowired`:
- `@Resource` (from `jakarta.annotation`) - resolves **by name** first, then by type.
- `@Inject` (from `jakarta.inject`) - the standard JSR-330 annotation, behaves like `@Autowired` but without Spring-specific extras like `required=false`.

Functionally similar in most cases; `@Autowired` is what you'll see most often in
Spring-only codebases.

## Files

- `src/main/java/PaymentGateway.java`, `RazorpayGateway.java`, `StripeGateway.java` - two competing implementations.
- `src/main/java/OrderService.java` - uses `@Qualifier` to pick `RazorpayGateway` specifically.
- `src/main/java/AppConfig.java`, `DependencyInjectionDemo.java` - wiring + demo.

## Running it

```bash
mvn compile exec:java -Dexec.mainClass="DependencyInjectionDemo"
```

## Output

```
Qualifier resolved to Razorpay: Order #4001 paid via Razorpay Gateway
```

Reference: https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html
