# Debugging React Applications with Chrome DevTools

## 1. Setting Up the Environment
- Install the **React Developer Tools** Chrome extension.
- Run your app in dev mode (`npm run dev`) — React DevTools only shows
  component names/props cleanly in development builds (not minified prod).

## 2. Launching the Application
```bash
npm run dev
```
Open the printed URL (e.g. `http://localhost:3000`) in Chrome.

## 3. Opening Chrome DevTools
- `F12` or `Ctrl+Shift+I` (Windows/Linux) / `Cmd+Option+I` (Mac).
- Two new tabs appear once React DevTools extension is installed:
  **⚛️ Components** and **⚛️ Profiler**.

## 4. Inspecting Elements
- **Elements tab**: right-click any UI element → "Inspect" to jump straight
  to its DOM node and computed CSS.
- **⚛️ Components tab**: shows the React component tree (not raw HTML) —
  click a component to see its **props**, **state**, and **hooks** live,
  and edit them on the fly to test UI reactions.

## 5. Debugging JavaScript
- **Sources tab** → find your file (Vite serves un-minified source via
  source maps) → click the line number to set a breakpoint.
- `debugger;` statement in code pauses execution there automatically when
  DevTools is open — useful for one-off investigation without hunting for
  the line in Sources.
- **Console tab**: `console.log`, `console.table` (great for arrays of
  objects like API responses), `console.error` for stack traces.

## 6. Debugging React Code
- Use the **⚛️ Components** tab's search box to find a component instantly
  in a large tree.
- Select a component → the "hooks" section shows each `useState`/`useEffect`
  value in order — helpful for confirming state updates actually happened.
- **Profiler tab**: record a session, interact with the UI, then see a
  flame graph of which components re-rendered and why (useful for both bugs
  AND performance issues).
- Common React-specific bugs to look for:
  - Stale closures (a handler capturing an old value of state)
  - Missing/incorrect `key` prop → check the Components tree for reordering
    glitches
  - `useEffect` dependency array causing infinite re-render loops (watch
    the Profiler — repeated renders every few ms is the tell)

## Practice
Use `debug-practice-app/` in this repo — it has 5 planted bugs. Try to find
each one using: Elements/Components tab, a breakpoint in Sources, and the
Console, before checking `SOLUTIONS.md`.
