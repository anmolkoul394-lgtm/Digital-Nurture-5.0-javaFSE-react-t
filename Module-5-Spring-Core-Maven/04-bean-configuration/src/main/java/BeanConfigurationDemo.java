// BeanConfigurationDemo.java
// Boots the container using Java config (AppConfig) instead of an XML file.

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanConfigurationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.checkout(3001, 1999.0);

        context.close();
    }
}
