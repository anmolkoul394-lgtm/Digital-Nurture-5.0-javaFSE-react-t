// IocContainerDemo.java
// Loads beans.xml into a Spring ApplicationContext and lets the container
// build + wire the objects, instead of us doing it with "new".

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocContainerDemo {
    public static void main(String[] args) {
        // The container reads beans.xml, creates every <bean> defined there,
        // and resolves their dependencies.
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // We just ASK the container for the bean we want - we never called "new OrderService(...)".
        OrderService orderService = (OrderService) context.getBean("orderService");

        orderService.checkout(2001, 4599.0);
    }
}
