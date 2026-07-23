# Context Engineering

## What Context Engineering is

**Context Engineering** is the practice of deliberately choosing WHAT information
to put in front of an AI model before it generates a response - not just the
instruction itself, but the surrounding information that helps the model produce an
accurate, relevant answer. It's a broader idea than prompt engineering (next topic):
prompt engineering is about HOW you phrase the instruction; context engineering is
about WHAT else the model gets to see alongside it.

## Prompt Engineering vs Context Engineering

| | Prompt Engineering | Context Engineering |
|---|---|---|
| Focus | Wording and structure of the instruction itself | What surrounding information is available to the model |
| Example | "Write a Java method that reverses a string, using a for loop" | Also giving the model your existing `StringUtils.java` file, your team's style conventions, and the class you want the new method added to |
| Analogy | How clearly you ask a question | How much relevant background you hand over before asking |

In practice these work together - a well-engineered prompt with poor context still
produces a generic answer; good context with a vague prompt still confuses the model
about what you actually want done.

## Types of Context in AI

- **Instructions** - the system-level or explicit rules the model should follow
  (e.g. "always respond in JSON", "use 4-space indentation")
- **User input** - the actual request/question at hand
- **History** - prior turns in the conversation, which the model uses to stay
  consistent with what's already been discussed
- **External data** - documents, code files, search results, or other content fed
  in alongside the request (this is exactly what happens when Copilot reads the
  rest of your open files, or when this assistant reads an uploaded document)

## The Context Window - and its limits

Every model has a maximum amount of text it can "see" at once - the **context
window** - measured in tokens (roughly, pieces of words). Anything beyond that
limit simply isn't visible to the model when it generates a response. This has
real, practical implications:

- A huge codebase can't ALL fit in context at once - which is why Copilot is
  selective about which nearby files/functions it includes, rather than the whole repository
- Long conversations can eventually push earlier turns out of the window, and the
  model effectively "forgets" the earliest parts of a very long chat
- More context isn't automatically better - irrelevant context can actually dilute
  the model's attention and lead to a worse answer than a smaller, more focused set
  of information would have

## Why selecting relevant context matters

Feeding a model the RIGHT surrounding information (the actual function signature
you're implementing against, the specific error message you got, the relevant part
of a spec) produces sharply more accurate output than either giving it nothing, or
dumping in everything you have and hoping it figures out what's relevant. This is
the practical skill Context Engineering is really about: curating, not maximizing,
what the model sees.

## A worked example

**Poor context** - asking in isolation:
> "Fix the bug in my repository method"

The model has nothing to work with - it doesn't know the language, the framework,
or what "the bug" even is.

**Good context** - the same request, but with the actual method and error attached:
> "This Spring Data JPA repository method throws `PropertyReferenceException:
> No property 'name' found for type Book` - here's the method:
> `List<Book> findByAuthorName(String name);` and here's my `Book` entity: [entity code]"

Now the model can see the entity's actual field names and immediately spot that the
derived query method doesn't match the entity's structure - it can only do that
because the RIGHT context (the entity definition) was included alongside the question.

Reference: https://www.datacamp.com/blog/context-engineering
