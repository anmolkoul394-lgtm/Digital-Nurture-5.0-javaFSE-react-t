// LinearSearch.java
// Time Complexity : O(n) worst/average case, O(1) best case (target is the first element).
// Space Complexity: O(1) - no extra space needed.
// Works on sorted AND unsorted arrays.

import java.util.Arrays;

public class LinearSearch {

    // Returns the index of 'target' in arr, or -1 if not found.
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // found - return immediately
            }
        }
        return -1; // not found after checking every element
    }

    public static void main(String[] args) {
        int[] numbers = { 45, 12, 78, 3, 90, 34 };
        System.out.println("Array: " + Arrays.toString(numbers));

        int target = 90;
        System.out.println("Searching for " + target + " using Linear Search...");

        int result = linearSearch(numbers, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
