# Sorting Algorithms

This topic covers 5 classic sorting algorithms. Each has its own Java file in `src/`.

## Complexity Summary

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity | Stable? |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |

---

### 1. Bubble Sort — `src/BubbleSort.java`
**Theory:** Repeatedly compares adjacent elements and swaps them if they are in the wrong
order. After each full pass, the largest unsorted element "bubbles up" to its correct position.

**Sample Output:**
```
Original array: [5, 2, 9, 1, 5, 6]
Sorted array:   [1, 2, 5, 5, 6, 9]
```

### 2. Insertion Sort — `src/InsertionSort.java`
**Theory:** Builds the sorted array one element at a time. Takes each new element and
"inserts" it into its correct position among the already-sorted elements (like sorting playing cards in your hand).

**Sample Output:**
```
Original array: [9, 5, 1, 4, 3]
Sorted array:   [1, 3, 4, 5, 9]
```

### 3. Heap Sort — `src/HeapSort.java`
**Theory:** Builds a **Max Heap** from the array, then repeatedly swaps the root (maximum
element) with the last element and reduces the heap size, "heapifying" after each swap.

**Sample Output:**
```
Original array: [12, 11, 13, 5, 6, 7]
Sorted array:   [5, 6, 7, 11, 12, 13]
```

### 4. Merge Sort — `src/MergeSort.java`
**Theory:** A **Divide and Conquer** algorithm. Splits the array into halves recursively
until each half has one element, then **merges** the halves back together in sorted order.

**Sample Output:**
```
Original array: [38, 27, 43, 3, 9, 82, 10]
Sorted array:   [3, 9, 10, 27, 38, 43, 82]
```

### 5. Quick Sort — `src/QuickSort.java`
**Theory:** A **Divide and Conquer** algorithm. Picks a "pivot" element, partitions the array
so smaller elements are on the left and larger on the right of the pivot, then recursively
sorts each partition.

**Sample Output:**
```
Original array: [10, 7, 8, 9, 1, 5]
Sorted array:   [1, 5, 7, 8, 9, 10]
```

## 📚 Reference
https://www.geeksforgeeks.org/sorting-algorithms/
