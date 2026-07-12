// SpringAopDemo.java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // This is actually a PROXY wrapping the real OrderService bean.
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder(5001, 799.0);

        context.close();
    }
}
