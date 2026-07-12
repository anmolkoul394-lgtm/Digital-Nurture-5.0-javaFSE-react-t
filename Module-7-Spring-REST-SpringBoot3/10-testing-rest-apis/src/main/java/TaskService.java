// TaskService.java
// Kept as a separate service layer (instead of putting everything in the
// controller) specifically so it's easy to mock out in TaskControllerTest.

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    public Optional<Task> findById(Long id) {
        if (id == 1L) {
            return Optional.of(new Task(1L, "Learn Spring Boot"));
        }
        return Optional.empty();
    }
}
