package com.dn5.week7.hello;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A real test so the CI pipeline's "mvn test" step has something to run.
 */
@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void helloControllerReturnsGreeting() {
        HelloController controller = new HelloController();
        assert controller.hello().contains("Hello");
    }
}
