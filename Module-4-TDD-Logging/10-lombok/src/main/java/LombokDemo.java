// LombokDemo.java
// Demonstrates using the code Lombok generated for us in Employee.java:
// no-args constructor + setters, all-args constructor, the Builder, and equals().
// Also demonstrates @Slf4j for automatic logger creation.

import lombok.extern.slf4j.Slf4j;

@Slf4j // Lombok automatically creates: private static final Logger log = LoggerFactory.getLogger(LombokDemo.class);
public class LombokDemo {
    public static void main(String[] args) {
        // 1) No-args constructor + generated setters
        System.out.println("--- Using no-args constructor + generated setters ---");
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Anitha");
        employee1.setSalary(45000.0);
        System.out.println(employee1); // uses Lombok-generated toString()

        // 2) All-args constructor
        System.out.println("--- Using all-args constructor ---");
        Employee employee2 = new Employee(2, "Ravi", 55000.0);
        System.out.println(employee2);

        // 3) Lombok-generated Builder
        System.out.println("--- Using Lombok-generated Builder ---");
        Employee employee3 = Employee.builder()
                .id(3)
                .name("Kiran")
                .salary(38000.0)
                .build();
        System.out.println(employee3);

        // 4) Generated equals() - two objects with the same data are equal
        Employee employee3Copy = Employee.builder()
                .id(3)
                .name("Kiran")
                .salary(38000.0)
                .build();
        System.out.println("Equals check (same data, different objects): " + employee3.equals(employee3Copy));

        // 5) @Slf4j - the 'log' field was generated automatically by Lombok
        log.info("LombokDemo finished running successfully");
    }
}
