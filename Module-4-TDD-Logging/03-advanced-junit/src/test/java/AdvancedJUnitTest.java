// AdvancedJUnitTest.java
// Demonstrates ADVANCED JUnit 5 features:
//   1. Parameterized tests (@ParameterizedTest + @ValueSource / @CsvSource)
//   2. Test execution order (@TestMethodOrder + @Order)
//   3. Tags (test categories/suites)
//   4. Exception testing (assertThrows)
//   5. Timeout / performance testing (assertTimeout)

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Forces test methods to run in the order given by @Order(n).
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdvancedJUnitTest {

    private final StringUtils stringUtils = new StringUtils();

    // ---- 1. PARAMETERIZED TEST using @ValueSource ----
    // Runs the SAME test body once for each value in the list.
    @Tag("fast")
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = { "madam", "racecar", "level" })
    void testKnownPalindromes(String word) {
        assertTrue(stringUtils.isPalindrome(word), word + " should be a palindrome");
    }

    // ---- 2. PARAMETERIZED TEST using @CsvSource (input, expected pairs) ----
    @Tag("fast")
    @Order(2)
    @ParameterizedTest
    @CsvSource({
            "hello, olleh",
            "java, avaj",
            "abc, cba"
    })
    void testReverse(String input, String expectedReversed) {
        assertEquals(expectedReversed, stringUtils.reverse(input));
    }

    // ---- 3. EXCEPTION TESTING ----
    @Tag("fast")
    @Order(3)
    @Test
    void testReverseNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> stringUtils.reverse(null));
    }

    // ---- 4. TIMEOUT / PERFORMANCE TESTING ----
    // Fails if slowSquare() takes longer than 200 milliseconds.
    @Tag("slow")
    @Order(4)
    @Test
    void testSlowSquareCompletesInTime() {
        assertTimeout(Duration.ofMillis(200), () -> {
            int result = stringUtils.slowSquare(5);
            assertEquals(25, result);
        });
    }
}
