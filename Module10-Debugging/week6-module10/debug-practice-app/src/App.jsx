import Cart from './components/Cart.jsx'
import DelayedCounter from './components/DelayedCounter.jsx'
import AutoRefresher from './components/AutoRefresher.jsx'
import ClickLogger from './components/ClickLogger.jsx'

function App() {
  return (
    <div style={{ fontFamily: 'sans-serif', maxWidth: 700, margin: '20px auto' }}>
      <h1>Debug Practice App — Module 10</h1>
      <p>Open Chrome DevTools and find the 5 bugs. See BUGS.md for symptoms.</p>

      <h2>Bug 1 & 2: Shopping Cart</h2>
      <Cart />

      <h2>Bug 3: Delayed Counter (stale closure)</h2>
      <DelayedCounter />

      <h2>Bug 4: Auto Refresher (infinite loop)</h2>
      <AutoRefresher />

      <h2>Bug 5: Click Logger (handler wiring)</h2>
      <ClickLogger />
    </div>
  )
}

export default App
