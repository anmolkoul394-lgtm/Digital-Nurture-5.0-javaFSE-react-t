// TaskController.java
// Demonstrates ResponseEntity for custom status codes/headers, and throwing a
// custom exception that GlobalExceptionHandler turns into a proper 404 response.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public TaskController() {
        tasks.add(new Task(idCounter.incrementAndGet(), "Learn Spring Boot", false));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task task = findOrThrow(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setId(idCounter.incrementAndGet());
        tasks.add(task);

        // 201 Created is more correct than the default 200 for a creation, plus a custom header
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("X-Custom-Header", "task-api")
                .body(task);
    }

    private Task findOrThrow(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
