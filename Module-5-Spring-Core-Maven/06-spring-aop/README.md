# Spring AOP

Some concerns cut across your entire application - logging, security checks,
transaction handling - and don't really belong inside your business logic methods.
AOP (Aspect-Oriented Programming) lets you pull that logic out into a separate module
called an **aspect**, and have Spring "weave" it into your methods automatically.

## Key vocabulary

- **Aspect** - a class containing cross-cutting logic (e.g. `LoggingAspect`)
- **Advice** - the actual code that runs, and WHEN it runs relative to the target method
  (`@Before`, `@After`, `@Around`, `@AfterReturning`, `@AfterThrowing`)
- **Join point** - a point during execution where advice could run (basically, a method call)
- **Pointcut** - an expression that says WHICH join points to match, e.g.
  `execution(* com.example.service.*.*(..))` matches every method in every class in that package

## How it actually works under the hood

Spring AOP is proxy-based. When a bean matches a pointcut, Spring wraps it in a proxy
object. Calls to that bean go through the proxy first, which runs the advice, then
delegates to the real method. This is why AOP in plain Spring only works on **Spring
beans** called through the container - calling a method directly on `this` from inside
the same class bypasses the proxy entirely.

## Files

- `src/main/java/OrderService.java` - the target class being advised.
- `src/main/java/LoggingAspect.java` - `@Before` and `@AfterReturning` advice around any method in `OrderService`.
- `src/main/java/AppConfig.java` - `@EnableAspectJAutoProxy` turns on AOP proxying.
- `src/main/java/SpringAopDemo.java` - runs it and shows the aspect firing.

## Running it

```bash
mvn compile exec:java -Dexec.mainClass="SpringAopDemo"
```

## Output

```
[LoggingAspect] Before calling: placeOrder
Order #5001 placed for amount 799.0
[LoggingAspect] After calling: placeOrder, returned: Order placed successfully
```

Reference: https://www.geeksforgeeks.org/aspect-oriented-programming-and-aop-in-spring-framework/
