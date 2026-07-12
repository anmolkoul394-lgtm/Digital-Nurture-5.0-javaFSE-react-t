// UserServiceTest.java
// Demonstrates Mockito basics: mocking, stubbing, verifying interactions,
// argument matching, and handling void methods.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private UserRepository mockRepository; // the MOCK (fake) dependency
    private UserService userService;       // the class UNDER TEST

    @BeforeEach
    void setUp() {
        // Create a mock - a fake object that implements UserRepository
        // but does NOT talk to any real database.
        mockRepository = mock(UserRepository.class);
        userService = new UserService(mockRepository);
    }

    @Test
    void testGetUserGreeting_userExists() {
        // STUBBING: tell the mock what to return when findById(1) is called.
        when(mockRepository.findById(1)).thenReturn(new User(1, "Alice"));

        String greeting = userService.getUserGreeting(1);

        assertEquals("Hello, Alice!", greeting);
    }

    @Test
    void testGetUserGreeting_userNotFound() {
        // Stub the mock to return null (simulating "user not found in database")
        when(mockRepository.findById(99)).thenReturn(null);

        String greeting = userService.getUserGreeting(99);

        assertEquals("User not found", greeting);
    }

    @Test
    void testGetUserGreeting_withArgumentMatcher() {
        // ARGUMENT MATCHING: anyInt() matches ANY integer argument, not just a specific one.
        when(mockRepository.findById(anyInt())).thenReturn(new User(0, "Guest"));

        String greeting = userService.getUserGreeting(12345);

        assertEquals("Hello, Guest!", greeting);
    }

    @Test
    void testRemoveUser_verifiesInteraction() {
        // HANDLING VOID METHODS: doNothing() stubs a void method to do nothing (its default anyway,
        // but shown here explicitly for teaching purposes).
        doNothing().when(mockRepository).delete(5);

        userService.removeUser(5);

        // VERIFYING INTERACTIONS: confirm that delete(5) was actually called on the mock.
        verify(mockRepository).delete(5);
    }
}
