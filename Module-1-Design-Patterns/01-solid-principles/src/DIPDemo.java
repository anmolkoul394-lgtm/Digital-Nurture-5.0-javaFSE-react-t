// DIPDemo.java
// Demonstrates the Dependency Inversion Principle (DIP).
// High-level modules should not depend on low-level modules directly;
// both should depend on abstractions (interfaces).

// Abstraction that both high-level and low-level modules depend on.
interface MessageSender {
    void sendMessage(String message);
}

// Low-level module #1
class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

// Low-level module #2
class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// High-level module: depends ONLY on the MessageSender abstraction,
// not on EmailSender or SmsSender directly.
// The dependency is "injected" through the constructor (Constructor Injection).
class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void notifyUser(String message) {
        messageSender.sendMessage(message);
    }
}

public class DIPDemo {
    public static void main(String[] args) {
        // We can swap the implementation without changing NotificationService at all.
        NotificationService emailNotification = new NotificationService(new EmailSender());
        emailNotification.notifyUser("Welcome to our platform!");

        NotificationService smsNotification = new NotificationService(new SmsSender());
        smsNotification.notifyUser("Welcome to our platform!");
    }
}
