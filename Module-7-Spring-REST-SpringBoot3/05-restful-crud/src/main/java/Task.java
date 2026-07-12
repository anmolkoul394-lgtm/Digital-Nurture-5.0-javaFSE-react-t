// Task.java
// A real JPA entity now, backed by H2. @Version enables optimistic locking -
// Hibernate checks this column on every UPDATE and throws if it's been changed
// by someone else since we last read it.

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean done;

    @Version
    private Long version;

    public Task() {}
    public Task(String title) {
        this.title = title;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
    public Long getVersion() { return version; }
}
