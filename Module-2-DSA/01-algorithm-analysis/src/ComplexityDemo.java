// ComplexityDemo.java
// Demonstrates analysis of algorithms: an ITERATIVE algorithm vs a RECURSIVE algorithm
// solving the same problem (sum of array elements), and comparing their complexity.

public class ComplexityDemo {

    // ---- ITERATIVE approach ----
    // Time Complexity : O(n)  -> single loop through n elements
    // Space Complexity: O(1)  -> only uses a fixed number of variables
    public static int iterativeSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // ---- RECURSIVE approach ----
    // Time Complexity : O(n)  -> makes n recursive calls
    // Space Complexity: O(n)  -> each call adds a new frame to the call stack
    public static int recursiveSum(int[] arr, int index) {
        // Base case: no more elements to add
        if (index == arr.length) {
            return 0;
        }
        // Recursive case: current element + sum of the rest
        return arr[index] + recursiveSum(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };

        int iterativeResult = iterativeSum(numbers);
        System.out.println("Iterative Sum of array = " + iterativeResult);

        int recursiveResult = recursiveSum(numbers, 0);
        System.out.println("Recursive Sum of array = " + recursiveResult);

        System.out.println("Iterative approach Time Complexity: O(n)");
        System.out.println("Recursive approach Time Complexity: O(n) time, O(n) space (call stack)");
    }
}
