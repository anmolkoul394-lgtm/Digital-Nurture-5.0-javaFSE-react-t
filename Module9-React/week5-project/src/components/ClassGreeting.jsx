// Module 9 -> "React Components and Props" + "React ES6 and JSX" subtopics:
// Class component, ES6 class syntax, constructor, "this" binding, and
// class-based state.
import React from 'react'

class ClassGreeting extends React.Component {
  constructor(props) {
    super(props)
    this.state = { greetedAt: new Date().toLocaleTimeString() }
  }

  render() {
    return (
      <p>
        Hello, <strong>{this.props.name}</strong>! (class component,
        rendered at {this.state.greetedAt})
      </p>
    )
  }
}

export default ClassGreeting
