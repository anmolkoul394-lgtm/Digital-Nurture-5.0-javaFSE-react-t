// OCPDemo.java
// Demonstrates the Open-Closed Principle (OCP).
// Classes should be OPEN for extension but CLOSED for modification.
// We add new shapes by creating new classes, WITHOUT touching AreaCalculator.

// Abstract base type - defines the contract every shape must follow.
abstract class Shape {
    // Every shape must know how to calculate its own area.
    public abstract double calculateArea();
}

// Extension 1: Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Extension 2: Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Extension 3: Triangle - added later WITHOUT modifying AreaCalculator below.
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// This class never needs to change when a new shape is added.
// It is CLOSED for modification but works with ANY shape (OPEN for extension).
class AreaCalculator {
    public double totalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calculateArea();
        }
        return sum;
    }
}

public class OCPDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(6, 4);
        Shape triangle = new Triangle(4, 3);

        System.out.println("Area of Circle: " + circle.calculateArea());
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
        System.out.println("Area of Triangle: " + triangle.calculateArea());

        AreaCalculator calculator = new AreaCalculator();
        Shape[] shapes = { circle, rectangle, triangle };
        System.out.println("Total Area: " + calculator.totalArea(shapes));
    }
}
