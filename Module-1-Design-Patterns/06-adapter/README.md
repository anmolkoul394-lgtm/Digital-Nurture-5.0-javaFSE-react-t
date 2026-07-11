# Adapter Pattern (Structural)

## Theory
The **Adapter Pattern** lets two incompatible interfaces work together. It acts as a
**translator/bridge** between a class the client expects and a class that already exists but
has a different interface (e.g. a legacy class, or a third-party library).

Real-world analogy: a **travel plug adapter** lets a device with a US plug work in an Indian socket.

## When to use it
- When you want to use an existing class, but its interface doesn't match what you need.
- When integrating third-party or legacy code without modifying it.

## Files
- `src/AdapterDemo.java` – Adapts an `AdvancedMediaPlayer` (legacy interface) to a simple `MediaPlayer` interface.

## Expected Output
```
Playing mp3 file: song.mp3
Playing mp4 file using adapter: video.mp4
Playing vlc file using adapter: movie.vlc
```

## 📚 Reference
https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
