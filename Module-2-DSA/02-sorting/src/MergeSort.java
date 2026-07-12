// MergeSort.java
// Time Complexity : O(n log n) for best, average, and worst case.
// Space Complexity: O(n) - needs temporary arrays to merge.

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide: recursively sort the left half and right half
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Conquer: merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // size of left sub-array
        int n2 = right - mid;    // size of right sub-array

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        // Merge the two temp arrays back into arr[left..right] in sorted order
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArr, if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArr, if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
