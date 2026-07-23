import { useState } from 'react'

function ClickLogger() {
  const [log, setLog] = useState([])

  const handleClick = () => {
    setLog((prev) => [...prev, `Clicked at ${new Date().toLocaleTimeString()}`])
  }

  return (
    <div>
      {/* BUG 5: handleClick() is CALLED during render (because of the
          parentheses), not passed as a reference. Open Sources, set a
          breakpoint on the line inside handleClick, and reload the page -
          notice it pauses immediately even without clicking anything. */}
      <button onClick={handleClick()}>Log a click</button>
      <ul>
        {log.map((entry, i) => (
          <li key={i}>{entry}</li>
        ))}
      </ul>
    </div>
  )
}

export default ClickLogger
