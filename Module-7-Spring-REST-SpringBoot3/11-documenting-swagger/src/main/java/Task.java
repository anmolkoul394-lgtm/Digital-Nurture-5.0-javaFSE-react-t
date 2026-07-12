// Task.java
// @Schema adds example values and descriptions to what shows up in the Swagger UI
// for this model's fields, instead of just bare field names.

import io.swagger.v3.oas.annotations.media.Schema;

public class Task {

    @Schema(description = "Unique identifier of the task", example = "1")
    private Long id;

    @Schema(description = "Short title describing the task", example = "Learn Spring Boot")
    private String title;

    @Schema(description = "Whether the task has been completed", example = "false")
    private boolean done;

    public Task() {}
    public Task(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
}
