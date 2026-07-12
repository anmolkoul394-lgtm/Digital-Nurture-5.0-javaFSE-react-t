// InsertionSort.java
// Time Complexity : O(n) best case (already sorted), O(n^2) average and worst case.
// Space Complexity: O(1) - sorts in place.

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element - the first element is trivially "sorted"
        for (int i = 1; i < n; i++) {
            int key = arr[i];      // the element to be inserted into the sorted part
            int j = i - 1;

            // Shift elements of the sorted part that are greater than key, one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert key into its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 9, 5, 1, 4, 3 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
