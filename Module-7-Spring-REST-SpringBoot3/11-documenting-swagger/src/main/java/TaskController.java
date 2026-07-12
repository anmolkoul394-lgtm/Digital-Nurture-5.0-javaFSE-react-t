// TaskController.java
// @Operation and @ApiResponse turn the auto-generated docs from "just a list of
// endpoints" into something that actually explains what each one does and what
// each possible response means.

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Operation(summary = "Get a task by id", description = "Returns a single task, or 404 if it doesn't exist")
    @ApiResponse(responseCode = "200", description = "Task found and returned")
    @ApiResponse(responseCode = "404", description = "No task exists with the given id")
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        if (id == 1L) {
            return ResponseEntity.ok(new Task(1L, "Learn Spring Boot", false));
        }
        return ResponseEntity.notFound().build();
    }
}
