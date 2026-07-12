// TaskNotFoundException.java
// A custom, meaningful exception instead of letting a NullPointerException
// or generic RuntimeException leak out of the controller.

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task with id " + id + " was not found");
    }
}
