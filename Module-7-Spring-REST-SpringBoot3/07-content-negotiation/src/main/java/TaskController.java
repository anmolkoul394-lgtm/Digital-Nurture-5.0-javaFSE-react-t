// TaskController.java
// Same GET /tasks endpoint, but the response format depends entirely on the
// client's Accept header - "produces" lists every format this method supports.

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @GetMapping(value = "/tasks", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Task> getAllTasks() {
        return List.of(new Task(1L, "Learn Spring Boot", false));
    }
}
