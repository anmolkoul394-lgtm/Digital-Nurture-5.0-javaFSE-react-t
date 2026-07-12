// HeapSort.java
// Time Complexity : O(n log n) for best, average, and worst case.
// Space Complexity: O(1) - sorts in place (uses recursion stack O(log n) but no extra array).

import java.util.Arrays;

public class HeapSort {

    // Rearranges the subtree rooted at index i (of size n) to satisfy the Max-Heap property.
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;        // assume root is the largest
        int left = 2 * i + 1;   // left child index
        int right = 2 * i + 2;  // right child index

        // If left child is larger than current largest
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // If right child is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // If largest is not the root, swap and continue heapifying down
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a Max Heap from the array (start from the last non-leaf node)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Repeatedly extract the maximum (root) and place it at the end
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Re-heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        heapSort(numbers);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
