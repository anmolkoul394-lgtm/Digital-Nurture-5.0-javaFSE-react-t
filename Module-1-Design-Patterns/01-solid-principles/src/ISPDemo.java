// ISPDemo.java
// Demonstrates the Interface Segregation Principle (ISP).
// Clients should not be forced to depend on methods they do not use.
// Instead of one fat "Worker" interface with work() + eat(), we split it into
// two small, focused interfaces: Workable and Eatable.

// Small, focused interface #1
interface Workable {
    void work();
}

// Small, focused interface #2
interface Eatable {
    void eat();
}

// Human needs BOTH abilities, so it implements both small interfaces.
class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human working...");
    }

    @Override
    public void eat() {
        System.out.println("Human eating...");
    }
}

// Robot only needs to work - it is NOT forced to implement eat().
// If we had used one fat interface, Robot would have been forced to
// provide a meaningless/empty eat() method.
class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }
}

public class ISPDemo {
    public static void main(String[] args) {
        Human human = new Human();
        human.work();
        human.eat();

        Robot robot = new Robot();
        robot.work();
        // robot.eat(); // Not available - and that's correct! Robots don't eat.
    }
}
