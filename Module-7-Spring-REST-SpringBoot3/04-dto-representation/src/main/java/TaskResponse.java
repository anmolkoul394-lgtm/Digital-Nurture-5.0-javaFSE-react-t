// TaskResponse.java
// What the API sends BACK - deliberately excludes internalNotes.
// This is the "shape" clients actually see, independent of however Task is modeled internally.

public class TaskResponse {
    private Long id;
    private String title;
    private boolean done;

    public TaskResponse(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
}
