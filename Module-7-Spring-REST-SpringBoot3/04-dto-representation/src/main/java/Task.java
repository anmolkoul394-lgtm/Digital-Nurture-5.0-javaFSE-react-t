// Task.java
// Our internal model - has a field ("internalNotes") that should NEVER be exposed
// through the API. This is exactly the kind of leak DTOs are meant to prevent.

public class Task {
    private Long id;
    private String title;
    private boolean done;
    private String internalNotes; // e.g. internal ops notes - not for public consumption

    public Task(Long id, String title, boolean done, String internalNotes) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.internalNotes = internalNotes;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public String getInternalNotes() { return internalNotes; }
}
