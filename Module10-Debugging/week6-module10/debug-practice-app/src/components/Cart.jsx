import { useState } from 'react'

const initialItems = [
  { id: 1, name: 'Notebook', price: 50, qty: 2 },
  { id: 2, name: 'Pen', price: 10, qty: 3 },
  { id: 3, name: 'Eraser', price: 5, qty: 1 },
]

function Cart() {
  const [items, setItems] = useState(initialItems)

  // BUG 1: total should be price * qty summed, but this just adds price
  // (ignores quantity entirely) - set a breakpoint inside the reduce
  // callback and watch `sum` / `item` each iteration to spot it.
  const total = items.reduce((sum, item) => sum + item.price, 0)

  const removeItem = (id) => {
    setItems(items.filter((item) => item.id !== id))
  }

  return (
    <div>
      <ul>
        {/* BUG 2: using array index as key. Remove the middle item and
            watch (via React DevTools Components tab) how remaining rows'
            internal identity shifts - can cause wrong row to appear
            "removed" visually if rows had local state. */}
        {items.map((item, index) => (
          <li key={index}>
            {item.name} — ₹{item.price} x {item.qty}{' '}
            <button onClick={() => removeItem(item.id)}>remove</button>
          </li>
        ))}
      </ul>
      <strong>Total: ₹{total}</strong>
    </div>
  )
}

export default Cart
