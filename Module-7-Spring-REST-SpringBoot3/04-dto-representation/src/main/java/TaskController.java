// TaskController.java
// Converts between the internal Task model and the public-facing DTOs by hand -
// simple, explicit, and easy to follow for a project this size.

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public TaskController() {
        tasks.add(new Task(idCounter.incrementAndGet(), "Learn Spring Boot", false,
                "Assigned during onboarding week - internal only"));
    }

    @GetMapping("/tasks")
    public List<TaskResponse> getAllTasks() {
        return tasks.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/tasks")
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        Task task = new Task(idCounter.incrementAndGet(), request.getTitle(), false, null);
        tasks.add(task);
        return toResponse(task);
    }

    // The hand-written mapping - Task (internal) -> TaskResponse (public)
    private TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId(), task.getTitle(), task.isDone());
    }
}
