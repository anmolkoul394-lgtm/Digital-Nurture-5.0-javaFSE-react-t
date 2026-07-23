# Debugging in Visual Studio / VS Code

## 1. Setting Breakpoints
- Click in the gutter (left of the line number) to place a **line breakpoint**.
- Right-click a breakpoint for options:
  - **Conditional breakpoint** — pauses only when an expression is true
    (e.g. `i === 5`).
  - **Logpoint** — logs a message to console without pausing execution.
  - **Hit count breakpoint** — pauses only after N hits.

### Breakpoint types
| Type | When it fires |
|---|---|
| Line breakpoint | Every time that line executes |
| Conditional breakpoint | Only when the condition evaluates true |
| Logpoint | Never pauses — just logs |
| Exception breakpoint | Whenever an exception is thrown (caught/uncaught) |

## 2. Inspecting Variables
- **Locals window**: auto-shows every variable in the current scope.
- **Watch window**: manually add expressions (e.g. `user.address.city`) you
  want tracked across every pause — persists as you step through code.
- Hover over a variable in the editor while paused to see its value inline.

## 3. Stepping Through Code
| Action | Shortcut (VS Code) | What it does |
|---|---|---|
| Continue | F5 | Runs until the next breakpoint |
| Step Over | F10 | Executes the current line, does NOT enter function calls |
| Step Into | F11 | Enters the function call on the current line |
| Step Out | Shift+F11 | Finishes the current function and returns to the caller |
| Restart | Ctrl+Shift+F5 | Restarts the debug session |
| Stop | Shift+F5 | Ends the debug session |

### Practical rule of thumb
- Use **Step Over** when you trust the function being called (e.g. a
  well-tested library) and just want to see its result.
- Use **Step Into** when the bug might be INSIDE that function.
- Use **Step Out** once you've confirmed a function works and want to get
  back to the caller quickly.
