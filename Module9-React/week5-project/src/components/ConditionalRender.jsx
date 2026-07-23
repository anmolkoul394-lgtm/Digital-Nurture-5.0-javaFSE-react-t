// Module 9 -> "Conditional Rendering" subtopic:
// element variables, inline if with &&, inline if-else with ternary,
// and preventing a component from rendering (return null).
import { useState } from 'react'

function ConditionalRender() {
  const [loggedIn, setLoggedIn] = useState(false)
  const [showBanner, setShowBanner] = useState(true)

  // Element variable
  let statusMessage
  if (loggedIn) {
    statusMessage = <span className="ok">You are logged in.</span>
  } else {
    statusMessage = <span className="warn">You are logged out.</span>
  }

  return (
    <div>
      {statusMessage}
      <br />
      <button onClick={() => setLoggedIn(!loggedIn)}>Toggle login</button>

      {/* Inline if with && */}
      {loggedIn && <p>Welcome back! (rendered only when loggedIn is true)</p>}

      {/* Inline if-else with ternary */}
      <p>{loggedIn ? 'Session: active' : 'Session: none'}</p>

      <button onClick={() => setShowBanner(!showBanner)}>Toggle banner</button>
      <Banner show={showBanner} />
    </div>
  )
}

// Prevents rendering entirely by returning null
function Banner({ show }) {
  if (!show) return null
  return <div className="banner">Promo banner (returns null to hide)</div>
}

export default ConditionalRender
