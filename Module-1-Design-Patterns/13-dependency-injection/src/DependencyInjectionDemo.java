// DependencyInjectionDemo.java
// Demonstrates Dependency Injection (DI) using plain Java (no framework needed).
// The Car class does NOT create its own Engine with "new" - the Engine is
// "injected" from outside, either through the constructor or a setter.

// The dependency - an abstraction (interface) so any engine type can be injected.
interface Engine {
    void start();
}

// Concrete dependency #1
class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol Engine started");
    }
}

// Concrete dependency #2
class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Diesel Engine started");
    }
}

// High-level class that DEPENDS on Engine, but never creates one itself.
class Car {
    private Engine engine;

    // 1) CONSTRUCTOR INJECTION - dependency provided when the object is created.
    public Car(Engine engine) {
        this.engine = engine;
    }

    // 2) SETTER INJECTION - dependency can also be changed/provided later.
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // Constructor Injection: inject PetrolEngine when creating the Car.
        Car petrolCar = new Car(new PetrolEngine());
        System.out.print("Constructor Injection -> ");
        petrolCar.drive();

        // Setter Injection: swap in a DieselEngine AFTER the Car object already exists.
        Car dieselCar = new Car(new PetrolEngine());
        dieselCar.setEngine(new DieselEngine());
        System.out.print("Setter Injection -> ");
        dieselCar.drive();
    }
}
