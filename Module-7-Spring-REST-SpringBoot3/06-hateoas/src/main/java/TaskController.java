// TaskController.java
// Wraps Task in EntityModel/CollectionModel so every response includes hypermedia
// links, instead of returning the plain entity/DTO like earlier topics did.

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        if (taskRepository.count() == 0) {
            taskRepository.save(new Task("Learn Spring Boot"));
        }
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<EntityModel<Task>> getTask(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    EntityModel<Task> model = EntityModel.of(task,
                            linkTo(methodOn(TaskController.class).getTask(id)).withSelfRel(),
                            linkTo(methodOn(TaskController.class).getAllTasks()).withRel("all-tasks"));
                    return ResponseEntity.ok(model);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tasks")
    public CollectionModel<EntityModel<Task>> getAllTasks() {
        List<EntityModel<Task>> tasks = taskRepository.findAll().stream()
                .map(task -> EntityModel.of(task,
                        linkTo(methodOn(TaskController.class).getTask(task.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(tasks,
                linkTo(methodOn(TaskController.class).getAllTasks()).withSelfRel());
    }
}
