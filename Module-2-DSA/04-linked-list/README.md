# Linked List

## Theory
A **Linked List** is a linear data structure where elements ("nodes") are NOT stored in
contiguous memory. Instead, each node stores its data plus a **reference (pointer)** to the
next node (and, for doubly linked lists, the previous node too).

## Types covered here

| Type | Description | File |
|---|---|---|
| Singly Linked List | Each node points only to the **next** node. Last node points to `null`. | `src/SinglyLinkedListDemo.java` |
| Circular Singly Linked List | Like a singly linked list, but the **last node points back to the first node**, forming a circle. | `src/CircularSinglyLinkedListDemo.java` |
| Doubly Linked List | Each node points to both the **next** and **previous** node. | `src/DoublyLinkedListDemo.java` |
| Circular Doubly Linked List | Doubly linked list where the last node's `next` points to the head, and the head's `previous` points to the last node. | `src/CircularDoublyLinkedListDemo.java` |

Every implementation supports: **Insert (at end)**, **Traverse (print all)**, **Search**, and **Delete (by value)**.

## Time Complexity

| Operation | Singly | Doubly |
|---|---|---|
| Insert at head | O(1) | O(1) |
| Insert at end | O(n) (O(1) if tail pointer kept) | O(n) (O(1) if tail pointer kept) |
| Search | O(n) | O(n) |
| Delete (by value) | O(n) | O(n) |
| Traverse | O(n) | O(n) |

## Space Complexity
O(n) for all types — each node needs extra memory for its pointer(s), unlike arrays.

## Sample Output (Singly Linked List)
```
Linked List: 10 -> 20 -> 30 -> null
Searching for 20: Found
Deleting 20...
After deletion -> Linked List: 10 -> 30 -> null
```

## 📚 Reference
https://www.geeksforgeeks.org/linked-list-in-java/
