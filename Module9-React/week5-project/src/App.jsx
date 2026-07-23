// Module 9 -> "Introduction to SPA" + "React Components and Props":
// App is the root functional component that composes every other
// component demonstrating each Week 5/6 sub-topic.
import FunctionalGreeting from './components/FunctionalGreeting.jsx'
import ClassGreeting from './components/ClassGreeting.jsx'
import EventDemo from './components/EventDemo.jsx'
import ConditionalRender from './components/ConditionalRender.jsx'
import TodoList from './components/TodoList.jsx'
import UserForm from './components/UserForm.jsx'
import ApiUsers from './components/ApiUsers.jsx'

function App() {
  return (
    <div className="app">
      <h1>Week 5/6 — Module 9: React SPA Demo</h1>

      <Section title="1. React Components & Props (functional + class)">
        <FunctionalGreeting name="Selin" />
        <FunctionalGreeting /> {/* uses default prop */}
        <ClassGreeting name="World" />
      </Section>

      <Section title="2. React Events">
        <EventDemo />
      </Section>

      <Section title="3. Conditional Rendering">
        <ConditionalRender />
      </Section>

      <Section title="4. Lists and Keys">
        <TodoList />
      </Section>

      <Section title="5. Forms (controlled inputs + validation)">
        <UserForm />
      </Section>

      <Section title="6. Calling an API (Fetch + Axios)">
        <ApiUsers />
      </Section>
    </div>
  )
}

// Small reusable presentational component - also demonstrates props +
// the JSX "children" prop.
function Section({ title, children }) {
  return (
    <section className="section">
      <h2>{title}</h2>
      {children}
    </section>
  )
}

export default App
