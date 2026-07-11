# Proxy Pattern (Structural)

## Theory
The **Proxy Pattern** provides a **placeholder or surrogate object** that controls access to
another (real) object. The proxy implements the same interface as the real object, so the
client uses both interchangeably, but the proxy can add extra logic — access control,
caching, lazy loading, logging — before/after delegating to the real object.

Real-world analogy: a **credit card** is a proxy for your bank account — it controls and
tracks access without giving direct access to your cash.

## When to use it
- **Access control** – restrict who can use an expensive/sensitive object (this example).
- **Lazy initialization** – delay creating an expensive object until it's actually needed.
- **Logging/caching** – add cross-cutting behaviour transparently.

## Files
- `src/ProxyDemo.java` – `DocumentProxy` controls access to `RealDocument` based on user role.

## Expected Output
```
Access denied. "guest" cannot view confidential documents.
Loading document from disk: Salary_Report.pdf
Displaying document: Salary_Report.pdf
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
