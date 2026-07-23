// Module 9 -> "Calling API with React" subtopic:
// demonstrates BOTH the Fetch API and Axios hitting the same public REST
// endpoint (jsonplaceholder), including loading/error states.
import { useEffect, useState } from 'react'
import axios from 'axios'

const API_URL = 'https://jsonplaceholder.typicode.com/users?_limit=5'

function ApiUsers() {
  const [fetchUsers, setFetchUsers] = useState([])
  const [axiosUsers, setAxiosUsers] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  // --- Fetch API ---
  useEffect(() => {
    fetch(API_URL)
      .then((res) => {
        if (!res.ok) throw new Error(`HTTP ${res.status}`)
        return res.json()
      })
      .then((data) => setFetchUsers(data))
      .catch((err) => setError(err.message))
  }, [])

  // --- Axios ---
  useEffect(() => {
    axios
      .get(API_URL)
      .then((res) => setAxiosUsers(res.data))
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false))
  }, [])

  if (error) return <p className="error">Error: {error}</p>
  if (loading) return <p>Loading users...</p>

  return (
    <div className="api-grid">
      <div>
        <h3>Via Fetch API</h3>
        <ul>
          {fetchUsers.map((u) => (
            <li key={u.id}>{u.name} — {u.email}</li>
          ))}
        </ul>
      </div>
      <div>
        <h3>Via Axios</h3>
        <ul>
          {axiosUsers.map((u) => (
            <li key={u.id}>{u.name} — {u.email}</li>
          ))}
        </ul>
      </div>
    </div>
  )
}

export default ApiUsers
