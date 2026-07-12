# Spring Bean Configuration

XML config (previous topic) works, but it's verbose and easy to lose track of when a
project has hundreds of beans. Modern Spring mostly uses annotations instead, and lets
Spring scan your packages to find beans on its own.

## Stereotype annotations

- `@Component` - generic, "this is a Spring-managed bean"
- `@Service` - a business logic / service layer bean (same as `@Component`, just clearer intent)
- `@Repository` - a data access layer bean, also adds automatic exception translation
- `@Controller` / `@RestController` - web layer beans (used in Spring MVC)

## Component scanning

`@ComponentScan("com.example.app")` tells Spring which packages to scan for classes
marked with the annotations above, so you don't have to declare each bean by hand.

## Java-based configuration

Instead of XML, you can define beans in a plain Java class:

```java
@Configuration
public class AppConfig {
    @Bean
    public PaymentGateway paymentGateway() {
        return new RazorpayGateway();
    }
}
```

`@Configuration` marks the class as a source of bean definitions, and each `@Bean`
method's return value becomes a managed bean.

## Mixing XML and Java config

You can still import XML config from a `@Configuration` class using `@ImportResource`,
useful when migrating an old XML-heavy project to annotations gradually, without a
big-bang rewrite.

## Files

- `src/main/java/RazorpayGateway.java` - marked `@Component` so component scanning picks it up.
- `src/main/java/OrderService.java` - marked `@Service`, depends on `PaymentGateway` via `@Autowired`.
- `src/main/java/AppConfig.java` - `@Configuration` + `@ComponentScan`.
- `src/main/java/BeanConfigurationDemo.java` - boots an `AnnotationConfigApplicationContext` from `AppConfig`.

## Running it

```bash
mvn compile exec:java -Dexec.mainClass="BeanConfigurationDemo"
```

## Output

```
Annotation-based bean: Order #3001 paid via Razorpay Gateway
```

Reference: https://www.baeldung.com/spring-bean-annotations
