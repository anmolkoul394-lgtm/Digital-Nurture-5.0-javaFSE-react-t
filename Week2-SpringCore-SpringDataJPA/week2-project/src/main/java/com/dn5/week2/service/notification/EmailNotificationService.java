package com.dn5.week2.service.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Module 5 -> "Spring Bean Configuration" (Stereotype annotations) +
 * "Dependency Injection in Spring" (Autowiring / conflict resolution).
 *
 * @Service is a stereotype annotation -> discovered by component scanning.
 * @Primary tells the IoC container this is the default NotificationService
 * to inject whenever there is more than one candidate bean.
 */
@Service
@Primary
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("[EMAIL] " + message);
    }
}
