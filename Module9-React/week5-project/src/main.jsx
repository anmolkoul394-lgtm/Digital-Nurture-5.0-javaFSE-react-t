// Module 9 -> "Introduction to React": entry point that mounts the SPA
// into the single index.html div#root (Single Page Application concept -
// only ONE page load, everything after is JS-driven DOM updates).
import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './styles.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
