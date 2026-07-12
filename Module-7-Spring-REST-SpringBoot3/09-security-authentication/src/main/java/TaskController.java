// TaskController.java
// Protected by SecurityConfig - only reachable with a valid JWT in the
// Authorization header (anything under "anyRequest().authenticated()" needs one).

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @GetMapping("/tasks")
    public List<Map<String, Object>> getTasks() {
        return List.of(Map.of("id", 1, "title", "Learn Spring Security"));
    }
}
