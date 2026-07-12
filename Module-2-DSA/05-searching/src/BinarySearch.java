// BinarySearch.java
// Time Complexity : O(log n) - the search space is halved on every step.
// Space Complexity: O(1) for this iterative implementation.
// IMPORTANT: the array MUST be sorted for Binary Search to work correctly.

import java.util.Arrays;

public class BinarySearch {

    // Returns the index of 'target' in a SORTED array, or -1 if not found.
    public static int binarySearch(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids potential integer overflow

            if (sortedArr[mid] == target) {
                return mid; // found
            } else if (sortedArr[mid] < target) {
                low = mid + 1; // discard the left half, search the right half
            } else {
                high = mid - 1; // discard the right half, search the left half
            }
        }
        return -1; // target not found in the array
    }

    public static void main(String[] args) {
        int[] sortedNumbers = { 3, 12, 34, 45, 78, 90 };
        System.out.println("Sorted Array: " + Arrays.toString(sortedNumbers));

        int target = 45;
        System.out.println("Searching for " + target + " using Binary Search...");

        int result = binarySearch(sortedNumbers, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
