// Task.java
// @JacksonXmlRootElement gives the XML output a clean root tag name -
// without it, Jackson's XML module falls back to a generic name.

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "task")
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
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
}
