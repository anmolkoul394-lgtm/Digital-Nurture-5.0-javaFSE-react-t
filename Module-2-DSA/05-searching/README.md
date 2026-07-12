# Searching Algorithms

## 1. Linear Search — `src/LinearSearch.java`
**Theory:** Checks each element one by one, from the start, until the target is found or the
list ends. Works on **both sorted and unsorted** arrays.

**Time Complexity:** Best O(1), Average O(n), Worst O(n)
**Space Complexity:** O(1)

**Sample Output:**
```
Array: [45, 12, 78, 3, 90, 34]
Searching for 90 using Linear Search...
Element found at index 4
```

## 2. Binary Search — `src/BinarySearch.java`
**Theory:** Works only on a **sorted** array. Repeatedly divides the search interval in half:
compares the target with the middle element, then discards the half where the target cannot
exist, until found or the interval is empty.

**Time Complexity:** Best O(1), Average O(log n), Worst O(log n)
**Space Complexity:** O(1) iterative version (O(log n) if implemented recursively, due to call stack)

**Sample Output:**
```
Sorted Array: [3, 12, 34, 45, 78, 90]
Searching for 45 using Binary Search...
Element found at index 3
```

## 📚 Reference
https://www.geeksforgeeks.org/searching-algorithms/#basics-of-searching-algorithms
