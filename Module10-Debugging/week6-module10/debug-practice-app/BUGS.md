# 5 Planted Bugs — find them before checking SOLUTIONS.md

1. **Cart total is wrong.** Add items with different quantities — the
   total shown doesn't match `price × qty` summed correctly.
2. **List key smell.** Cart list items use array index as their `key`.
   Remove a middle item and inspect the React DevTools Components tree —
   notice how remaining items' identity shifts instead of just the
   removed row disappearing cleanly.
3. **Delayed Counter shows a stale value.** Click "Increment (delayed 2s)"
   rapidly several times within the 2-second window, then watch the
   console log values — the count doesn't add up to the number of clicks.
4. **Auto Refresher's tick climbs on its own**, without you clicking
   anything, and keeps climbing forever.
5. **Click Logger's button doesn't seem to work on click** — but check
   the console/breakpoints: something fires without a click at all.

## How to approach each one
- Bugs 1: set a breakpoint inside the `reduce` callback (Sources tab),
  step through and inspect `sum`/`item` values (Watch/Locals).
- Bug 2: use React DevTools **⚛️ Components** tab, remove an item, observe
  which component instance re-renders vs. is destroyed.
- Bug 3: add a breakpoint inside the `setTimeout` callback, inspect the
  closed-over `count` value at pause time.
- Bug 4: open the **⚛️ Profiler** tab, record, watch continuous render
  entries with no user interaction.
- Bug 5: set a breakpoint on the first line of `handleClick`, reload the
  page (no click!) and see it hit anyway.
