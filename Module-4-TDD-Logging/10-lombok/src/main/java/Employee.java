// Employee.java
// The SAME class as EmployeeWithoutLombok.java, but using Lombok annotations to generate
// all the boilerplate (getters, setters, constructors, toString, equals/hashCode, builder)
// automatically at compile time.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                // generates getters, setters, toString(), equals(), hashCode()
@NoArgsConstructor    // generates a no-argument constructor
@AllArgsConstructor   // generates a constructor with all fields
@Builder              // generates a Builder (see Module 1's Builder pattern)
public class Employee {
    private int id;
    private String name;
    private double salary;
}
