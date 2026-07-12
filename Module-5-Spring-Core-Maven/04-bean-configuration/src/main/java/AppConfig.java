// AppConfig.java
// Java-based configuration class - replaces beans.xml entirely.
// @ComponentScan with no arguments scans the package of this class itself (the
// default/unnamed package here, since we kept these examples simple with no package statement).

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    // No @Bean methods needed here - RazorpayGateway and OrderService are already
    // discovered automatically through component scanning.
}
