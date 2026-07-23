import { useState } from 'react'

function DelayedCounter() {
  const [count, setCount] = useState(0)

  // BUG 3: this closes over the `count` value from the render it was
  // created in. Click "Increment (delayed)" a few times fast - the alert
  // shows a stale number, not the latest count.
  // Fix hint: use the functional update form setCount(c => c + 1), or
  // read the current value via a ref.
  const incrementDelayed = () => {
    setTimeout(() => {
      setCount(count + 1)
      console.log('count used inside timeout:', count)
    }, 2000)
  }

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={incrementDelayed}>Increment (delayed 2s)</button>
      <p style={{ fontSize: 12, color: '#666' }}>
        Click this fast, multiple times, within 2 seconds - watch the console.
      </p>
    </div>
  )
}

export default DelayedCounter
