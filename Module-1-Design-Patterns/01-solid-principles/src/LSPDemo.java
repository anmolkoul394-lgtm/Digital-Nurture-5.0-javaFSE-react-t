// LSPDemo.java
// Demonstrates the Liskov Substitution Principle (LSP).
// Subtypes must be substitutable for their base type without breaking the program.
// WRONG approach would be: class Bird { fly() } then class Ostrich extends Bird
// (Ostriches can't fly - that would break LSP). Instead we separate "flying" ability.

// Base type: represents any bird's common behaviour.
abstract class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public abstract void move();
}

// Separate contract only for birds that CAN fly.
// Not every Bird is a FlyingBird - this keeps substitution safe.
interface Flyable {
    void fly();
}

// Sparrow IS a bird AND can fly.
class Sparrow extends Bird implements Flyable {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " flies high in the sky");
    }

    @Override
    public void move() {
        fly();
    }
}

// Ostrich IS a bird but CANNOT fly - it only implements Bird, not Flyable.
// This means client code can safely substitute any Bird without assuming fly() exists.
class Ostrich extends Bird {
    public Ostrich(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " runs fast on land");
    }
}

public class LSPDemo {
    public static void main(String[] args) {
        // Both Sparrow and Ostrich can be used wherever a Bird is expected,
        // and calling move() never breaks or throws an unsupported operation.
        Bird sparrow = new Sparrow("Sparrow");
        Bird ostrich = new Ostrich("Ostrich");

        sparrow.move();
        ostrich.move();
    }
}
