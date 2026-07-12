# Lombok

## Theory

### Introduction to Lombok
**Lombok** is a Java library that uses annotations to **generate boilerplate code
automatically at compile time** — getters, setters, constructors, `toString()`, `equals()`,
`hashCode()`, and more — so you don't have to write (or maintain) them by hand.

### Reducing Boilerplate Code with Lombok
Without Lombok, a simple class needs dozens of lines for getters/setters/constructors. With
Lombok, a single annotation replaces all of it (see the "Before vs After" comparison inside
`src/main/java/EmployeeWithoutLombok.java` vs `src/main/java/Employee.java`).

### Common Lombok Annotations
| Annotation | Generates |
|---|---|
| `@Getter` / `@Setter` | Getter / setter methods for all fields |
| `@ToString` | A readable `toString()` method |
| `@EqualsAndHashCode` | `equals()` and `hashCode()` methods |
| `@NoArgsConstructor` | A no-argument constructor |
| `@AllArgsConstructor` | A constructor with all fields as parameters |
| `@Data` | Shortcut for `@Getter` + `@Setter` + `@ToString` + `@EqualsAndHashCode` + a required-args constructor |
| `@Builder` | Generates a Builder pattern (see Module 1's Builder pattern) for the class |
| `@Slf4j` | Automatically creates an SLF4J `Logger log` field (no manual `LoggerFactory.getLogger(...)` needed!) |

### Lombok's Builder and Data Annotations
`@Builder` combines beautifully with the Builder Pattern covered in
`../../Module-1-Design-Patterns/05-builder` — Lombok generates the ENTIRE builder class for
you automatically.

### IDE Setup Considerations
Lombok works by hooking into the Java compiler (via annotation processing), so most IDEs
(IntelliJ IDEA, Eclipse) need the **Lombok plugin** installed, and annotation processing
enabled in project settings, for the generated code to be recognized while editing (compiling
with Maven/Gradle works out of the box once the dependency is added — see `pom.xml`).

## Files
- `src/main/java/EmployeeWithoutLombok.java` – the SAME class written by hand (no Lombok), to show the boilerplate Lombok removes.
- `src/main/java/Employee.java` – the same class using `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, and `@Builder`.
- `src/main/java/LombokDemo.java` – demonstrates using the generated getters/setters/toString/builder, and `@Slf4j` logging.

## ▶️ How to run
```bash
mvn compile exec:java -Dexec.mainClass="LombokDemo"
```

## Expected Output
```
--- Using no-args constructor + generated setters ---
Employee(id=1, name=Anitha, salary=45000.0)
--- Using all-args constructor ---
Employee(id=2, name=Ravi, salary=55000.0)
--- Using Lombok-generated Builder ---
Employee(id=3, name=Kiran, salary=38000.0)
Equals check (same data, different objects): true
```

## 📚 Reference
https://www.baeldung.com/intro-to-project-lombok
