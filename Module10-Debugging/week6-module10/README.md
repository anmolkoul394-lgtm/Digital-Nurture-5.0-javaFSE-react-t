# Week 6 — Module 10: Application Debugging

DN5.0 Java FSE plan ke **Module 10** subtopics:
- Debugging in Visual Studio (breakpoints, watch/locals, step into/over/out)
- Debugging React Applications with Chrome DevTools

Isme ek **intentionally-buggy React app** (`debug-practice-app/`) hai jise
tum breakpoints, watch window, aur step-through se debug karke seekh sakte ho,
plus `docs/` mein har subtopic ka practical cheat-sheet.

## Contents

| Folder/File | Covers |
|---|---|
| `docs/vscode-debugging.md` | Breakpoints, breakpoint types, Watch/Locals windows, Step Into/Over/Out |
| `docs/chrome-devtools-react.md` | Setup, launching app, opening DevTools, inspecting elements, debugging JS, debugging React |
| `debug-practice-app/` | Small React app with 5 planted bugs to practice on |
| `debug-practice-app/SOLUTIONS.md` | Where each bug is, how to find it with DevTools, and the fix |

## Run the practice app
```bash
cd debug-practice-app
npm install
npm run dev
```
Open `http://localhost:3000`, then open Chrome DevTools (`F12` / `Ctrl+Shift+I`)
and try to find the 5 bugs described in `debug-practice-app/BUGS.md` before
peeking at `SOLUTIONS.md`.

## GitHub pe push karna
```bash
git init
git add .
git commit -m "Week 6: Module 10 - Application Debugging"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
