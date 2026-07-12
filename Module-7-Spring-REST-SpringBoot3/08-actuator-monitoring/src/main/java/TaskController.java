// TaskController.java
// Registers a custom Micrometer counter ("tasks.created") - shows up alongside
// the built-in JVM/HTTP metrics at /actuator/metrics/tasks.created.

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {

    private final AtomicLong idCounter = new AtomicLong();
    private final Counter tasksCreatedCounter;

    public TaskController(MeterRegistry meterRegistry) {
        this.tasksCreatedCounter = meterRegistry.counter("tasks.created");
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        tasksCreatedCounter.increment(); // now visible at /actuator/metrics/tasks.created
        return new Task(idCounter.incrementAndGet(), task.getTitle());
    }
}
