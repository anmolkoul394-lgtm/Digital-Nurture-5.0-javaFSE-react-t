// UserService.java
// The class UNDER TEST. It DEPENDS on UserRepository (injected via constructor - see
// Dependency Injection topic in Module 1), so we can easily swap in a mock during testing.

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserGreeting(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return "User not found";
        }
        return "Hello, " + user.getName() + "!";
    }

    public void removeUser(int id) {
        userRepository.delete(id);
    }
}
