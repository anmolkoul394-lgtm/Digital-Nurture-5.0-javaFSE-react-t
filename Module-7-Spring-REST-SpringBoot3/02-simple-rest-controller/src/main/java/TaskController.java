// TaskController.java
// Basic REST controller - GET, POST, PUT, DELETE against an in-memory list.
// (No real database here yet - see 05-restful-crud for that.)

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public TaskController() {
        // seed one task so GET /tasks returns something on first run
        tasks.add(new Task(idCounter.incrementAndGet(), "Learn Spring Boot", false));
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        task.setId(idCounter.incrementAndGet());
        tasks.add(task);
        return task;
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setTitle(updatedTask.getTitle());
                task.setDone(updatedTask.isDone());
                return task;
            }
        }
        return null;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
