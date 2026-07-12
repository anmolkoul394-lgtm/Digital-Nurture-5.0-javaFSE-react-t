// QuickSort.java
// Time Complexity : O(n log n) best & average case, O(n^2) worst case
//                    (worst case happens when the pivot is always the smallest/largest element,
//                    e.g. on an already-sorted array with a naive pivot choice).
// Space Complexity: O(log n) - recursion stack (in-place partitioning, no extra arrays).

import java.util.Arrays;

public class QuickSort {

    // Partitions arr[low..high] using the LAST element as pivot.
    // Places pivot at its correct sorted position, smaller elements to its left, larger to its right.
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of the last element smaller than pivot

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot right after the last smaller element
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // pivot's final sorted index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array; pivotIndex is now in its correct sorted position
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
