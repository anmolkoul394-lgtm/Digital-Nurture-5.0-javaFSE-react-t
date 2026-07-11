package com.dn5.week2.service.notification;

/**
 * Module 5 -> "Dependency Injection in Spring" subtopic.
 * Having an interface with multiple implementations is what makes
 * @Autowired + @Qualifier / @Primary meaningful.
 */
public interface NotificationService {
    void send(String message);
}
