# Arrays

## Theory
An **Array** is a collection of elements of the same type, stored in **contiguous memory
locations**, and accessed using an index (starting at 0 in Java).

### Array Representation in Memory
Since elements are stored contiguously, the address of any element can be calculated
instantly: `address = base_address + (index * size_of_element)`. This is why array access
by index is O(1).

### When to use Arrays
- When you know the number of elements in advance (fixed size).
- When you need **fast random access** by index.
- Not ideal when you need frequent insertions/deletions in the middle (Linked List is better for that).

## Time & Space Complexity

| Operation | Time Complexity | Space Complexity |
|---|---|---|
| Access (by index) | O(1) | O(1) |
| Traversal | O(n) | O(1) |
| Search (unsorted) | O(n) | O(1) |
| Insertion (at end, with space) | O(1) | O(1) |
| Insertion (at beginning/middle) | O(n) | O(1) |
| Deletion (beginning/middle) | O(n) | O(1) |

## Java Program
See `src/ArrayDemo.java` — demonstrates declaration, traversal, and linear searching in an array.

## Sample Output
```
Array elements: 10 20 30 40 50
Sum of elements = 150
Element 30 found at index 2
Element 99 not found in the array
```

## 📚 Reference
https://www.geeksforgeeks.org/array-data-structure-guide/
