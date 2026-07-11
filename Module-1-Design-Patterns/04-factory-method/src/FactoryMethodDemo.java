// FactoryMethodDemo.java
// Demonstrates the Factory Method Design Pattern.
// A factory class decides WHICH concrete class to instantiate,
// so client code never needs to call "new" directly.

// Common product interface
interface Shape {
    void draw();
}

// Concrete product #1
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete product #2
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Concrete product #3
class RectangleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// The Factory: encapsulates the "if/else" or "switch" decision of WHICH object to create.
class ShapeFactory {
    // The "factory method" - given a type name, returns the correct concrete Shape.
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            case "RECTANGLE":
                return new RectangleShape();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        // Client code only talks to the factory - it never uses "new Circle()" directly.
        Shape circle = factory.getShape("CIRCLE");
        circle.draw();

        Shape square = factory.getShape("SQUARE");
        square.draw();

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
