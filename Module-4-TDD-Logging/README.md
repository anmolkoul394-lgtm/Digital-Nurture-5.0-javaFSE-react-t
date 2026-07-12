# Module 4 – Test Driven Development and Logging Framework

## 📁 Topics

| # | Topic | Folder |
|---|---|---|
| 1 | Introduction to TDD, TDD Cycle, Unit Testing basics | `01-tdd-intro` |
| 2 | JUnit 5 (Setup, Basic Tests, Assertions, AAA Pattern) | `02-junit5` |
| 3 | Advanced JUnit (Parameterized tests, order, exceptions, timeouts) | `03-advanced-junit` |
| 4 | Mockito (Mocking, Stubbing, Verifying) | `04-mockito` |
| 5 | Testing Spring Applications with JUnit & Mockito | `05-spring-testing` |
| 6 | Mocking External Dependencies | `06-mocking-external-deps` |
| 7 | Automation Testing basics | `07-automation-testing-intro` |
| 8 | Selenium Introduction | `08-selenium-intro` |
| 9 | SLF4J Logging | `09-slf4j-logging` |
| 10 | Lombok | `10-lombok` |

## ⚙️ Maven Dependencies Used in this Module

Some examples (JUnit 5, Mockito, Spring Testing, Selenium, SLF4J, Lombok) require a Maven
project since they use external libraries. Each relevant topic's `README.md` lists the exact
`pom.xml` dependency needed. A consolidated `pom.xml` snippet is shown below for convenience:

```xml
<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>5.11.0</version>
        <scope>test</scope>
    </dependency>

    <!-- Spring Boot Test (for Module 5) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <version>3.2.5</version>
        <scope>test</scope>
    </dependency>

    <!-- Selenium (for Module 8) -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.20.0</version>
    </dependency>

    <!-- SLF4J + simple binding (for Module 9) -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.13</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.13</version>
    </dependency>

    <!-- Lombok (for Module 10) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.32</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## 📚 References
- https://www.geeksforgeeks.org/test-driven-development-tdd/
- https://www.geeksforgeeks.org/introduction-to-junit-5/
- https://www.javacodegeeks.com/mockito-tutorials
- https://www.geeksforgeeks.org/testing-in-spring-boot/
- https://www.geeksforgeeks.org/automation-testing-software-testing/
- https://www.tutorialspoint.com/slf4j/index.htm
- https://www.baeldung.com/intro-to-project-lombok
