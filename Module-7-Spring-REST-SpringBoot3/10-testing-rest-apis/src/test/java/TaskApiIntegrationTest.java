// TaskApiIntegrationTest.java
// Starts the FULL application on a random free port and makes real HTTP calls
// against it - slower than TaskControllerTest, but confirms everything actually
// wires together end to end (no mocks anywhere in this test).

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskApiIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetTaskEndToEnd() {
        ResponseEntity<String> response = restTemplate.getForEntity("/tasks/1", String.class);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("Learn Spring Boot"));
    }

    @Test
    void testGetTaskNotFoundEndToEnd() {
        ResponseEntity<String> response = restTemplate.getForEntity("/tasks/99", String.class);

        assertEquals(404, response.getStatusCode().value());
    }
}
