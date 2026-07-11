# Observer Pattern (Behavioral)

## Theory
The **Observer Pattern** defines a **one-to-many dependency** between objects: when one
object (the "Subject") changes state, all its dependents ("Observers") are notified and
updated automatically.

Real-world analogy: a **YouTube channel** (subject) and its **subscribers** (observers) —
when the channel uploads a new video, all subscribers get notified.

## When to use it
- When a change to one object requires changing others, and you don't know how many.
- Event-handling systems, GUI listeners, pub-sub messaging, notification systems.

## Files
- `src/ObserverDemo.java` – `YouTubeChannel` (subject) and multiple `Subscriber` (observer) implementations.

## Expected Output
```
Alice has subscribed.
Bob has subscribed.
--- New video uploaded: "Java Design Patterns Tutorial" ---
Alice: Notified about new video - Java Design Patterns Tutorial
Bob: Notified about new video - Java Design Patterns Tutorial
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
