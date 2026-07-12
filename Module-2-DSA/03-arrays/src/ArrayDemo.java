// ArrayDemo.java
// Demonstrates basic Array operations: declaration, traversal, and searching.

public class ArrayDemo {

    // Traverses the array and prints each element - O(n) time, O(1) space.
    public static void traverseArray(int[] arr) {
        System.out.print("Array elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Calculates sum of all elements - O(n) time, O(1) space.
    public static int sumOfElements(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    // Simple linear search - O(n) time, O(1) space.
    // Returns the index of 'target' or -1 if not found.
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Declaring and initializing an array of fixed size
        int[] numbers = { 10, 20, 30, 40, 50 };

        traverseArray(numbers);

        int total = sumOfElements(numbers);
        System.out.println("Sum of elements = " + total);

        int indexOf30 = search(numbers, 30);
        if (indexOf30 != -1) {
            System.out.println("Element 30 found at index " + indexOf30);
        } else {
            System.out.println("Element 30 not found in the array");
        }

        int indexOf99 = search(numbers, 99);
        if (indexOf99 != -1) {
            System.out.println("Element 99 found at index " + indexOf99);
        } else {
            System.out.println("Element 99 not found in the array");
        }
    }
}
