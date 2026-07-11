# GoF (Gang of Four) Design Patterns – Overview

The "Gang of Four" (Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides) wrote the book
*"Design Patterns: Elements of Reusable Object-Oriented Software"* (1994), which catalogued 23
common design patterns split into three categories.

## Categories

### 1. Creational Patterns
Deal with **object creation** mechanisms, trying to create objects in a manner suitable to the situation.
- **Singleton** – ensure only one instance of a class exists (see `../03-singleton`)
- **Factory Method** – delegate object creation to subclasses (see `../04-factory-method`)
- **Builder** – construct complex objects step by step (see `../05-builder`)

### 2. Structural Patterns
Deal with **object composition** — how classes and objects are combined to form larger structures.
- **Adapter** – convert one interface into another the client expects (see `../06-adapter`)
- **Decorator** – attach new behaviour to an object dynamically (see `../07-decorator`)
- **Proxy** – provide a placeholder/surrogate to control access to another object (see `../08-proxy`)

### 3. Behavioral Patterns
Deal with **communication and responsibility** between objects.
- **Observer** – notify multiple dependents when an object's state changes (see `../09-observer`)
- **Strategy** – select an algorithm's behaviour at runtime (see `../10-strategy`)
- **Command** – encapsulate a request as an object (see `../11-command`)

### 4. Architectural Patterns (not part of the original 23, but essential in enterprise Java)
- **MVC (Model-View-Controller)** – separates data, UI, and control logic (see `../12-mvc`)
- **Dependency Injection** – supply an object's dependencies from the outside (see `../13-dependency-injection`)

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
