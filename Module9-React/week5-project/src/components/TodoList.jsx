// Module 9 -> "React List and Keys" subtopic:
// displaying a list with map(), the "key" prop, and extracting a
// component that receives a key.
import { useState } from 'react'

function TodoList() {
  const [todos, setTodos] = useState([
    { id: 1, text: 'Learn React components' },
    { id: 2, text: 'Understand JSX' },
    { id: 3, text: 'Build a form' },
  ])

  const removeTodo = (id) => {
    setTodos(todos.filter((t) => t.id !== id))
  }

  return (
    <ul>
      {todos.map((todo) => (
        // key must be stable + unique among siblings, NOT the array index
        <TodoItem key={todo.id} todo={todo} onRemove={removeTodo} />
      ))}
    </ul>
  )
}

// Extracted list-item component, receives data via props
function TodoItem({ todo, onRemove }) {
  return (
    <li>
      {todo.text} <button onClick={() => onRemove(todo.id)}>done</button>
    </li>
  )
}

export default TodoList
