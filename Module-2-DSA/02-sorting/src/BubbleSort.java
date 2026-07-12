// BubbleSort.java
// Time Complexity : O(n) best case (already sorted, with early-exit optimization),
//                    O(n^2) average and worst case.
// Space Complexity: O(1) - sorts in place, only uses a temp variable for swapping.

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop: one pass pushes the next-largest element to its correct position
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Inner loop: compare each adjacent pair
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: if no swaps happened, the array is already sorted -> stop early
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 9, 1, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
