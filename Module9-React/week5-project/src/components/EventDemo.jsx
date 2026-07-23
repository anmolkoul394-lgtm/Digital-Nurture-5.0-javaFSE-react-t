// Module 9 -> "React Events" subtopic:
// event object, event handlers, passing arguments to event handlers.
import { useState } from 'react'

function EventDemo() {
  const [message, setMessage] = useState('Click a button...')

  // Event handler receiving the synthetic event object
  const handleClick = (e) => {
    setMessage(`Button clicked! (event type: ${e.type})`)
  }

  // Passing an argument to an event handler via an arrow function
  const handleColorClick = (color) => {
    setMessage(`You picked color: ${color}`)
  }

  return (
    <div>
      <p>{message}</p>
      <button onClick={handleClick}>Click me</button>{' '}
      <button onClick={() => handleColorClick('red')}>Red</button>{' '}
      <button onClick={() => handleColorClick('blue')}>Blue</button>
    </div>
  )
}

export default EventDemo
