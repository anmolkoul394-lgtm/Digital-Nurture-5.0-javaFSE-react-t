// Task.java
// Plain model for now - no database. Kept simple on purpose so this topic
// stays focused on the controller/HTTP layer, not persistence.

public class Task {
    private Long id;
    private String title;
    private boolean done;

    public Task() {}

    public Task(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}
