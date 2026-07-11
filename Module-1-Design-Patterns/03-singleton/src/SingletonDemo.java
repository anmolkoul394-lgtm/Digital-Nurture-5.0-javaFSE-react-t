// SingletonDemo.java
// Demonstrates the Singleton Design Pattern.
// Ensures only ONE instance of DatabaseConnection ever exists in the JVM.

class DatabaseConnection {
    // The single instance, shared by the whole application.
    // 'volatile' ensures visibility across threads (needed for double-checked locking).
    private static volatile DatabaseConnection instance;

    private String databaseName;

    // Private constructor -> nobody outside this class can do "new DatabaseConnection()".
    private DatabaseConnection() {
        System.out.println("Creating the single Database Connection instance...");
        this.databaseName = "prod_db";
    }

    // Public global access point.
    // Double-checked locking makes this thread-safe AND efficient
    // (locking only happens the first time the instance is created).
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to database: " + databaseName);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // Both variables point to the SAME object.
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        System.out.println("Same instance? " + (connection1 == connection2));

        connection1.connect();
        connection2.connect();
    }
}
