# Model-View-Controller (MVC) Pattern (Architectural)

## Theory
**MVC** separates an application into three interconnected parts:

- **Model** – holds the application's data and business logic (e.g. a `Student` object).
- **View** – displays the data to the user (e.g. console output, HTML page).
- **Controller** – receives user input, updates the Model, and refreshes the View.

This separation means you can change the UI (View) without touching business logic (Model),
and vice versa. It is the foundation of frameworks like Spring MVC.

## When to use it
- Any application where you want to separate data, presentation, and control flow.
- Web applications, desktop GUIs, enterprise Java applications.

## Files
- `src/MVCDemo.java` – `Student` (Model), `StudentView` (View), `StudentController` (Controller).

## Expected Output
```
Student Details:
Name: Priya
Roll No: 101
--- After update ---
Student Details:
Name: Priya Sharma
Roll No: 101
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
