// DecoratorDemo.java
// Demonstrates the Decorator Design Pattern.
// We start with a SimpleCoffee and dynamically "wrap" it with MilkDecorator
// and SugarDecorator to add cost and description, WITHOUT modifying SimpleCoffee itself.

// Common interface for all coffee types (base object + decorators).
interface Coffee {
    double getCost();
    String getDescription();
}

// The base/core object being decorated.
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

// Abstract decorator - holds a reference to the wrapped Coffee object.
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// Concrete decorator #1: adds milk.
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 10.0; // milk costs extra
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with Milk";
    }
}

// Concrete decorator #2: adds sugar.
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 5.0; // sugar costs extra
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " and Sugar";
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        // Plain coffee, no add-ons
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + ": Cost = " + coffee.getCost());

        // Wrap it with milk
        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.getDescription() + ": Cost = " + milkCoffee.getCost());

        // Wrap the milk coffee with sugar too - decorators can be chained/stacked
        Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println(milkSugarCoffee.getDescription() + ": Cost = " + milkSugarCoffee.getCost());
    }
}
