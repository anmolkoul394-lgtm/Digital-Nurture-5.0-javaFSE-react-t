# Command Pattern (Behavioral)

## Theory
The **Command Pattern** turns a **request into a stand-alone object** that contains all
information about the request. This lets you parameterize objects with operations, queue
requests, log them, and support undo/redo.

Real-world analogy: a **TV remote control** — each button press is a command object that
knows how to turn the TV on/off, without the remote knowing HOW the TV works internally.

## When to use it
- To decouple the object that invokes an operation from the object that knows how to perform it.
- To implement undo/redo, task queues, or macro-recording of operations.

## Files
- `src/CommandDemo.java` – `Command` interface, `LightOnCommand`/`LightOffCommand`, and `RemoteControl` invoker.

## Expected Output
```
Light is ON
Light is OFF
Light is ON
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
