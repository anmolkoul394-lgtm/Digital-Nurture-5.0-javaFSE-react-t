package com.dn5.week2.config;

import com.dn5.week2.service.notification.EmailNotificationService;
import com.dn5.week2.service.notification.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.time.Clock;

/**
 * Module 5 -> "Spring Bean Configuration" subtopic.
 * - @Configuration + @Bean = Java-based configuration.
 * - @ComponentScan = component scanning (also auto-done by @SpringBootApplication,
 *   declared explicitly here just to demonstrate the concept).
 * - @ImportResource shows how Java-config can be MIXED with legacy XML config
 *   (see src/main/resources/spring/applicationContext.xml).
 */
@Configuration
@ComponentScan(basePackages = "com.dn5.week2")
@ImportResource("classpath:spring/applicationContext.xml")
public class AppConfig {

    /**
     * A plain bean, registered manually to show the IoC container can manage
     * ANY object, not just @Component-annotated classes.
     */
    @Bean
    public Clock systemClock() {
        return Clock.systemDefaultZone();
    }

    /**
     * A second implementation of NotificationService, wired only through this
     * @Bean method (no @Component on the class) to show that Java-config beans
     * live in the same IoC container as annotation-discovered beans.
     */
    @Bean(name = "smsNotificationService")
    public NotificationService smsNotificationService() {
        return message -> System.out.println("[SMS] " + message);
    }
}
