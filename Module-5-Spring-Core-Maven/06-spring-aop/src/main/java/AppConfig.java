// AppConfig.java
// @EnableAspectJAutoProxy tells Spring to actually create the AOP proxies for
// beans that match any @Aspect's pointcuts.

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
}
