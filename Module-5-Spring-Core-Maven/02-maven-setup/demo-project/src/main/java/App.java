// App.java
// Nothing fancy here - just confirms the Maven project is set up correctly
// and that the Spring dependency in pom.xml actually resolves.

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // We're not loading any real config here, just proving the Spring class
        // is on the classpath by referencing it - this line alone confirms Maven
        // successfully pulled in spring-context.
        Class<?> springClass = ClassPathXmlApplicationContext.class;

        System.out.println("Maven project is set up and Spring dependency resolved correctly.");
        System.out.println("Loaded class from classpath: " + springClass.getName());
    }
}
