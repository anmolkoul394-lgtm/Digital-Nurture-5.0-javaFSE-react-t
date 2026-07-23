# Week 5/6 — Module 9: Single Page Application framework - React

DN5.0 Java FSE learning plan ke **Module 9** ke saare subtopics ek hi React
(Vite) SPA mein cover kiye hain.

## Har subtopic kahan implement hai

| Key Topic | Sub-topic | File |
|---|---|---|
| Intro to SPA / React | Single root mount, virtual DOM | `src/main.jsx` |
| Components & Props | Functional + class components, default props | `components/FunctionalGreeting.jsx`, `components/ClassGreeting.jsx` |
| ES6 & JSX | Classes, constructor, `this`, arrow functions, JSX nesting | `components/ClassGreeting.jsx`, `App.jsx` |
| Events | Event object, handlers, passing args | `components/EventDemo.jsx` |
| Conditional Rendering | `&&`, ternary, returning `null` | `components/ConditionalRender.jsx` |
| Lists and Keys | `map()`, `key` prop, extracted item component | `components/TodoList.jsx` |
| Forms | Controlled + uncontrolled inputs, select, textarea, validation | `components/UserForm.jsx` |
| Calling API | Fetch API + Axios | `components/ApiUsers.jsx` |

## Run locally
```bash
npm install
npm run dev
```
Opens at `http://localhost:3000`.

## Build
```bash
npm run build
```

## GitHub pe push karna
```bash
git init
git add .
git commit -m "Week 5/6: Module 9 - React SPA fundamentals"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
