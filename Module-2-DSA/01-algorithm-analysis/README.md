# Analysis of Algorithms

## Theory

### Introduction
An **algorithm** is a finite, step-by-step set of instructions to solve a problem. **Data
Structures (DS)** are ways of organizing data so it can be used efficiently.

### Why DS & Algorithms?
Choosing the right data structure and algorithm directly affects how **fast** and how
**memory-efficient** a program is, especially as the input size grows.

### Types of Data Structures
- **Linear**: Array, Linked List, Stack, Queue
- **Non-linear**: Tree, Graph
- **Hash-based**: Hash Table / Hash Map

### Asymptotic Notations
We describe running time/memory growth using mathematical notations, independent of hardware:
- **Big-O (O)** – Worst-case upper bound. "It will never take longer than this."
- **Omega (Ω)** – Best-case lower bound. "It will never take less than this."
- **Theta (Θ)** – Tight bound (average behaviour). "It typically takes exactly this."

### Best, Average, Worst Case
- **Best Case** – the minimum time an algorithm takes (e.g. searching finds the item on the first try).
- **Average Case** – the expected time over all possible inputs.
- **Worst Case** – the maximum time an algorithm could take (most commonly analyzed, since it's the guarantee).

### Time Complexity
Measures how the **runtime** grows as input size `n` grows. Examples: O(1), O(log n), O(n), O(n log n), O(n²).

### Space Complexity
Measures how much **extra memory** an algorithm needs, as a function of input size `n`.

## Java Program
See `src/ComplexityDemo.java` — demonstrates finding time complexity of an iterative algorithm
(O(n) linear scan) and a recursive algorithm (O(n) recursive sum), with a simple timer.

## Sample Output
```
Iterative Sum of array = 150
Recursive Sum of array = 150
Iterative approach Time Complexity: O(n)
Recursive approach Time Complexity: O(n) time, O(n) space (call stack)
```

## 📚 Reference
https://www.geeksforgeeks.org/design-and-analysis-of-algorithms/
