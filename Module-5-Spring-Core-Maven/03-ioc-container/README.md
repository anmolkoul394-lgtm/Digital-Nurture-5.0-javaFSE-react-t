# Spring IoC Container

This is the part of Spring that actually does the work described in topic 1 -
creates your objects, figures out what each one depends on, and wires it all together.
There are two container interfaces you'll see: `BeanFactory` (the basic one, lazy
loading) and `ApplicationContext` (built on top of BeanFactory, adds things like
event publishing, internationalization, and eager initialization by default). In
practice you almost always use `ApplicationContext`.

## Configuring beans with XML

Before annotations became the norm, beans were declared entirely in an XML file:

```xml
<bean id="paymentGateway" class="RazorpayGateway" />
<bean id="orderService" class="OrderService">
    <constructor-arg ref="paymentGateway" />
</bean>
```

Spring reads this file, creates a `RazorpayGateway` bean, then creates an `OrderService`
bean and passes the gateway bean into its constructor - all without you writing `new`
anywhere in your own code.

## Files

- `src/main/resources/beans.xml` - the bean definitions.
- `src/main/java/PaymentGateway.java`, `RazorpayGateway.java`, `OrderService.java` - the classes being managed.
- `src/main/java/IocContainerDemo.java` - loads `beans.xml` into an `ApplicationContext` and fetches the wired `OrderService` bean.

## Running it

```bash
mvn compile exec:java -Dexec.mainClass="IocContainerDemo"
```

## Output

```
Spring wired it for us: Order #2001 paid via Razorpay Gateway
```

Reference: https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
