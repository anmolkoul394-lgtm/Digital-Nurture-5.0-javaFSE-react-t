// HelloController.java
// Standard REST controller - Boot's auto-configuration wires up everything needed
// (DispatcherServlet, embedded Tomcat, JSON message converters) so this "just works".

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Spring Boot app is running - no manual server setup needed.";
    }
}
