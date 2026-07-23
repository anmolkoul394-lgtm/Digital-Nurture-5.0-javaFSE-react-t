// Module 9 -> "React Forms" subtopic:
// controlled inputs, textarea, select, validation, and displaying error
// messages. (An "uncontrolled" input using a ref is included too, for
// comparison.)
import { useRef, useState } from 'react'

function UserForm() {
  const [form, setForm] = useState({ name: '', role: 'developer', bio: '' })
  const [errors, setErrors] = useState({})
  const [submitted, setSubmitted] = useState(null)
  const nicknameRef = useRef(null) // uncontrolled input

  const handleChange = (e) => {
    const { name, value } = e.target
    setForm((prev) => ({ ...prev, [name]: value }))
  }

  const validate = () => {
    const newErrors = {}
    if (!form.name.trim()) newErrors.name = 'Name is required'
    if (form.bio.length > 100) newErrors.bio = 'Bio must be under 100 characters'
    return newErrors
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    const newErrors = validate()
    setErrors(newErrors)
    if (Object.keys(newErrors).length === 0) {
      setSubmitted({ ...form, nickname: nicknameRef.current.value })
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Name (controlled): </label>
        <input name="name" value={form.name} onChange={handleChange} />
        {errors.name && <span className="error">{errors.name}</span>}
      </div>

      <div>
        <label>Nickname (uncontrolled, via ref): </label>
        <input name="nickname" ref={nicknameRef} defaultValue="" />
      </div>

      <div>
        <label>Role: </label>
        <select name="role" value={form.role} onChange={handleChange}>
          <option value="developer">Developer</option>
          <option value="designer">Designer</option>
          <option value="manager">Manager</option>
        </select>
      </div>

      <div>
        <label>Bio: </label>
        <textarea name="bio" value={form.bio} onChange={handleChange} rows={3} />
        {errors.bio && <span className="error">{errors.bio}</span>}
      </div>

      <button type="submit">Submit</button>

      {submitted && (
        <pre className="submitted">{JSON.stringify(submitted, null, 2)}</pre>
      )}
    </form>
  )
}

export default UserForm
