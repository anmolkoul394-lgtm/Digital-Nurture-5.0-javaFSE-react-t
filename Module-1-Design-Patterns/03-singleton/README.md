# Singleton Pattern (Creational)

## Theory
The **Singleton Pattern** ensures a class has **only one instance** in the entire application,
and provides a **global access point** to that instance.

Common use cases: database connection managers, configuration readers, logging classes.

## How it works
1. Make the constructor `private` so no one outside the class can create a new instance.
2. Keep a `private static` reference to the single instance inside the class.
3. Provide a `public static` method (commonly `getInstance()`) that creates the instance
   only once and returns the same instance every time after that.

This example uses **thread-safe lazy initialization** (double-checked locking), which is a
good practice for multi-threaded applications.

## Files
- `src/SingletonDemo.java` – `DatabaseConnection` Singleton + demo `main`.

## Expected Output
```
Creating the single Database Connection instance...
Same instance? true
Connecting to database: prod_db
Connecting to database: prod_db
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
