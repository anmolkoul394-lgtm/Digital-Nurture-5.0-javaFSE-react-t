import { useEffect, useState } from 'react'

function AutoRefresher() {
  const [tick, setTick] = useState(0)

  // BUG 4: no dependency array passed to useEffect, so it re-runs after
  // EVERY render. Since it calls setTick inside, that triggers another
  // render, which triggers the effect again -> infinite loop.
  // Open the Profiler tab (React DevTools) and you'll see continuous
  // re-renders. Fix hint: add `[]` as the second argument, or a proper
  // interval with cleanup.
  useEffect(() => {
    setTick(tick + 1)
  })

  return (
    <div>
      <p>Tick: {tick}</p>
      <p style={{ fontSize: 12, color: '#666' }}>
        If this number is climbing rapidly on its own, that's the bug -
        check the Profiler / Console for render spam.
      </p>
    </div>
  )
}

export default AutoRefresher
