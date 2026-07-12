// UserRepository.java
// Represents a dependency that would normally talk to a real database.
// In tests, we will create a MOCK of this interface instead of a real implementation.

public interface UserRepository {
    User findById(int id);
    void delete(int id);
}
