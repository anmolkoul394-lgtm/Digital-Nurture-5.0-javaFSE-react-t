# Example: Generating Tests with Copilot

## The existing method (already written, no tests yet)

```java
public class StringHelper {
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}
```

## The prompt given to Copilot Chat

```
Write JUnit 5 tests for StringHelper.isPalindrome, covering: a normal palindrome,
a normal non-palindrome, an empty string, and a null input.
```

## A typical generated test class

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void testIsPalindrome_withValidPalindrome() {
        assertTrue(StringHelper.isPalindrome("racecar"));
    }

    @Test
    void testIsPalindrome_withNonPalindrome() {
        assertFalse(StringHelper.isPalindrome("hello"));
    }

    @Test
    void testIsPalindrome_withEmptyString() {
        assertTrue(StringHelper.isPalindrome(""));
    }

    @Test
    void testIsPalindrome_withNullInput() {
        assertFalse(StringHelper.isPalindrome(null));
    }
}
```

## Reviewing this against Week 1's TDD/JUnit standards

- Each test follows Arrange-Act-Assert, even though it's compact enough that the
  three steps aren't visually separated - worth adding blank lines/comments to make
  that structure explicit if this were going into a real codebase
- The empty string case passing might be surprising at first glance - worth
  confirming that's actually the INTENDED behaviour (an empty string trivially
  reads the same forwards and backwards) rather than an oversight the generated
  test happened to gloss over
- Missing: a case with mixed punctuation/spacing (e.g. `"A man, a plan, a canal:
  Panama"`) which is exactly the kind of case the method's logic is specifically
  designed to handle - a good example of Copilot covering the OBVIOUS cases from the
  prompt, but a human reviewer still needs to add the case that actually exercises
  the interesting logic in the method.

This is the core habit worth building: treat Copilot's generated tests as a
solid first draft, then add the cases that actually stress-test what makes the
method's logic non-trivial.
