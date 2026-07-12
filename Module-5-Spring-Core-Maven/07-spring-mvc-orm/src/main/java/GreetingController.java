// GreetingController.java
// A minimal Spring MVC controller. Not meant to run standalone (it needs a servlet
// container / Spring Boot app around it) - this file is here so you can see the
// core annotations in one place: path variables, query params, request body, and
// returning data straight from a REST-style controller.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // Handles GET /greet/Anitha  -> "name" comes straight from the URL path
    @GetMapping("/greet/{name}")
    public String greetByPath(@PathVariable String name) {
        return "Hello, " + name + "! (via path variable)";
    }

    // Handles GET /greet?name=Anitha&loud=true  -> both come from the query string
    @GetMapping("/greet")
    public String greetByQuery(@RequestParam String name,
                                @RequestParam(defaultValue = "false") boolean loud) {
        String message = "Hello, " + name + "! (via query parameter)";
        return loud ? message.toUpperCase() : message;
    }

    // Handles POST /greet with a JSON body like {"name": "Anitha"}
    // Spring deserializes the JSON body directly into a GreetingRequest object.
    @PostMapping("/greet")
    public String greetByBody(@RequestBody GreetingRequest request) {
        return "Hello, " + request.getName() + "! (via request body)";
    }
}

// Small DTO used purely for the POST example above.
class GreetingRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
