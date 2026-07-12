// AuthController.java
// Hardcoded demo credentials, just to keep the example self-contained -
// a real app would check against a user table with a hashed password.

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if ("admin".equals(username) && "admin123".equals(password)) {
            return Map.of("token", JwtUtil.generateToken(username));
        }
        throw new RuntimeException("Invalid username or password");
    }
}
