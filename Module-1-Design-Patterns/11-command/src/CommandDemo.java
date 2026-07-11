// CommandDemo.java
// Demonstrates the Command Design Pattern.
// Each user action (turn light on/off) is wrapped in its own Command object.
// RemoteControl (the "invoker") just calls execute() - it doesn't know HOW the light works.

// Receiver - knows HOW to actually perform the actions.
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Command interface - common contract for all commands.
interface Command {
    void execute();
}

// Concrete command #1 - wraps the "turn on" request.
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete command #2 - wraps the "turn off" request.
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker - holds a command and triggers it, without knowing its implementation details.
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Press "on" button
        remote.setCommand(lightOn);
        remote.pressButton();

        // Press "off" button
        remote.setCommand(lightOff);
        remote.pressButton();

        // Press "on" button again
        remote.setCommand(lightOn);
        remote.pressButton();
    }
}
