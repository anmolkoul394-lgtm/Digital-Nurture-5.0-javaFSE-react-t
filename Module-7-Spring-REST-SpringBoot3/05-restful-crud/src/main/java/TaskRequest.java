// TaskRequest.java
// @NotBlank rejects null, empty, or whitespace-only titles before the controller
// method body even runs, as long as the parameter is annotated with @Valid.

import jakarta.validation.constraints.NotBlank;

public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
