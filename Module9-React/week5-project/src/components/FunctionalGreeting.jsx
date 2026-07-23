// Module 9 -> "React Components and Props" subtopic:
// Functional component + "Default props" + JSX attribute usage.
function FunctionalGreeting({ name = 'Guest' }) {
  return <p>Hello, <strong>{name}</strong>! (functional component)</p>
}

export default FunctionalGreeting
