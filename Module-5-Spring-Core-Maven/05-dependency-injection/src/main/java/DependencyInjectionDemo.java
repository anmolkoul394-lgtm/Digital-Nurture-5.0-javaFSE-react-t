// DependencyInjectionDemo.java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.checkout(4001, 3299.0);

        context.close();
    }
}
