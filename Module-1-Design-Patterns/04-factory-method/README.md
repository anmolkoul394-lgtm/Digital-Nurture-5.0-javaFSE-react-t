# Factory Method Pattern (Creational)

## Theory
The **Factory Method Pattern** defines an interface (or abstract method) for creating an object,
but lets a **factory class** decide which concrete class to instantiate.

Instead of the client code writing `new Circle()` or `new Square()` directly, it asks a factory:
`ShapeFactory.getShape("CIRCLE")`. This keeps object-creation logic in one place and makes it
easy to add new types later without touching client code (this ties in with the Open-Closed Principle!).

## When to use it
- When you don't know beforehand the exact type of object your code needs to create.
- When you want to centralize and hide the object-creation logic.

## Files
- `src/FactoryMethodDemo.java` – `Shape` interface, concrete shapes, `ShapeFactory`, and demo `main`.

## Expected Output
```
Drawing a Circle
Drawing a Square
Drawing a Rectangle
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
