# Solutions

## Bug 1 — Cart total ignores quantity
**File:** `src/components/Cart.jsx`
```js
// Buggy
const total = items.reduce((sum, item) => sum + item.price, 0)

// Fixed
const total = items.reduce((sum, item) => sum + item.price * item.qty, 0)
```

## Bug 2 — Array index used as key
**File:** `src/components/Cart.jsx`
```js
// Buggy
{items.map((item, index) => (
  <li key={index}>...</li>
))}

// Fixed - use the item's own stable id
{items.map((item) => (
  <li key={item.id}>...</li>
))}
```

## Bug 3 — Stale closure in setTimeout
**File:** `src/components/DelayedCounter.jsx`
```js
// Buggy
setTimeout(() => {
  setCount(count + 1)   // "count" is frozen at the value from this render
}, 2000)

// Fixed - functional update form always gets the LATEST state
setTimeout(() => {
  setCount((prevCount) => prevCount + 1)
}, 2000)
```

## Bug 4 — useEffect with no dependency array
**File:** `src/components/AutoRefresher.jsx`
```js
// Buggy - runs after every render, and setTick triggers another render
useEffect(() => {
  setTick(tick + 1)
})

// Fixed - run once on mount
useEffect(() => {
  setTick(1)
}, [])

// Or, if you actually want a periodic tick, use an interval + cleanup:
useEffect(() => {
  const id = setInterval(() => setTick((t) => t + 1), 1000)
  return () => clearInterval(id)
}, [])
```

## Bug 5 — Calling the handler instead of passing a reference
**File:** `src/components/ClickLogger.jsx`
```jsx
// Buggy - the () invokes handleClick immediately during render
<button onClick={handleClick()}>Log a click</button>

// Fixed - pass the function reference; React calls it ON click
<button onClick={handleClick}>Log a click</button>
```
