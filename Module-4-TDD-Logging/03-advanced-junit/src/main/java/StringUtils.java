// StringUtils.java
// A simple class under test (CUT) for demonstrating advanced JUnit 5 features.

public class StringUtils {

    // Checks if a string is a palindrome (reads the same forwards and backwards).
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    // Reverses a string.
    public String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    // Simulates a slightly slow operation, for the timeout test.
    public int slowSquare(int number) throws InterruptedException {
        Thread.sleep(50); // simulate a small delay
        return number * number;
    }
}
