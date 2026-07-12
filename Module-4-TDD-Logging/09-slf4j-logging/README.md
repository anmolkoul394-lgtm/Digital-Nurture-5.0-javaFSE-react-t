# SLF4J Logging Framework

## Theory

### Introduction to Logging Frameworks
**Logging** records what a program is doing while it runs — essential for debugging,
monitoring, and auditing production applications (much better than scattering `System.out.println`
everywhere, which cannot be turned off/on or redirected easily).

### SLF4J (Simple Logging Facade for Java)
SLF4J is NOT a logging implementation itself — it's a **facade (abstraction layer)** that lets
your code call a single, consistent logging API, while the ACTUAL logging work is done by
whichever backend you plug in underneath (Logback, Log4j2, java.util.logging, or — as used
here for simplicity — `slf4j-simple`).

```
Your Code  --calls-->  SLF4J API (Logger, LoggerFactory)
                              |
                      (plugged in at runtime)
                              |
                    Actual Logging Backend (Logback / Log4j2 / slf4j-simple)
```
Benefit: you can SWITCH logging backends later WITHOUT changing any of your application code.

### Configuring SLF4J with Logback (or slf4j-simple)
This example uses `slf4j-simple`, the lightest-weight SLF4J binding, configured via a
`simplelogger.properties` file (`src/main/resources/simplelogger.properties`) — no XML needed.
(In real enterprise projects, `Logback` with `logback.xml` is the most common choice — it
supports file rotation, multiple appenders, and more advanced configuration.)

### Logging Levels
From lowest to highest severity:
| Level | When to use |
|---|---|
| TRACE | Extremely detailed step-by-step diagnostic info |
| DEBUG | Detailed info useful only during development/debugging |
| INFO  | Normal application events (startup, key business events) |
| WARN  | Something unexpected happened, but the app can continue |
| ERROR | A serious problem occurred; an operation failed |

### Best Practices for Logging
- Log at the **right level** — don't log everything as ERROR.
- Include **context** (IDs, key values) in log messages, not just generic text.
- Never log **sensitive data** (passwords, card numbers, tokens).
- Use SLF4J's **parameterized logging** (`log.info("User {} logged in", userId);`) instead of
  string concatenation — it's faster (the string is only built if the level is enabled) and cleaner.
- Log exceptions with their **stack trace**: `log.error("Failed to process order", exception);`

## Files
- `src/main/resources/simplelogger.properties` – configures the log level and output format.
- `src/main/java/OrderService.java` – demonstrates logging at every level, parameterized
  logging, and logging an exception with its stack trace.

## ▶️ How to run
```bash
mvn compile exec:java -Dexec.mainClass="OrderService"
```
(or compile and run with `javac`/`java`, placing the SLF4J + slf4j-simple JARs on the classpath.)

## Expected Output (approximate — slf4j-simple prints timestamps too)
```
[main] INFO OrderService - Application started
[main] DEBUG OrderService - Processing order with id: 101
[main] INFO OrderService - Order 101 processed successfully for amount 2500.0
[main] WARN OrderService - Low stock warning for product: Keyboard
[main] ERROR OrderService - Failed to process order 999
java.lang.ArithmeticException: / by zero
    at OrderService.riskyCalculation(OrderService.java:...)
    ...
```

## 📚 Reference
https://www.tutorialspoint.com/slf4j/index.htm
