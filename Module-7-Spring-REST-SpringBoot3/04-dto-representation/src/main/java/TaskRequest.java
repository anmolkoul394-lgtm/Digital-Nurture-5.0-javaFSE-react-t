// TaskRequest.java
// What the CLIENT sends when creating a task - deliberately minimal.
// No "id" field: the server assigns that, the client shouldn't be able to set it.

public class TaskRequest {
    private String title;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
