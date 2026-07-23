# Prompt Engineering - Techniques, Best Practices & Ethics

## What Prompt Engineering is, and why it matters for developers

**Prompt Engineering** is the practice of crafting your instructions to an AI model
so it produces the output you actually want, on the first try (or close to it).
For a developer, this is a genuinely practical skill - the difference between a
vague prompt and a well-structured one is often the difference between code you
have to heavily rewrite and code you can drop straight in.

## Zero-shot prompting

Asking the model to do a task directly, with no examples - just a clear instruction.

```
Write a Java method that checks if a string is a palindrome.
```

Works well for common, well-understood tasks the model has seen thousands of times
in training. Less reliable for anything unusual, or where you need a very specific
output format/style.

## Few-shot prompting

Giving the model one or more EXAMPLES of the input/output pattern you want, before
asking it to do the actual task. This is especially useful when you need a specific,
non-obvious format:

```
Convert these method names to REST endpoint paths:

getUserById       -> GET /users/{id}
createUser        -> POST /users
deleteUserAccount  -> DELETE /users/{id}/account

Now convert: updateUserPassword
```

The examples teach the model the exact pattern you want, rather than relying on it
guessing your intent from a description alone.

## Chain-of-thought prompting

Explicitly asking the model to reason step by step BEFORE giving a final answer,
rather than jumping straight to a conclusion. This tends to improve accuracy on
anything involving multiple steps of logic (math, multi-step debugging, complex
business rules):

```
A Spring Data JPA query is returning duplicate rows when I use a JOIN FETCH with
pagination. Walk through step by step why this happens, then give me the fix.
```

Asking for the reasoning first (rather than just "give me the fix") tends to produce
a more correct answer, because the model has to work through WHY the bug happens
before proposing a solution - the same discipline a careful human developer would use.

## Best practices

- **Be clear and specific** - "write a sort function" vs "write a Java method that
  sorts a `List<Task>` by `dueDate` ascending, using `Comparator`"
- **Provide context** - the actual class/error/requirement, not just a description
  of it (this is where Context Engineering, the previous topic, feeds directly into
  prompt quality)
- **Specify the output format** - "return only the code, no explanation" vs "explain
  your reasoning first, then give the code" produce very different, equally valid,
  responses depending on what you actually need
- **Iterate** - the first response doesn't have to be final; refining a prompt based
  on what came back is a completely normal part of the process, not a sign you did
  it wrong the first time

## Ethical considerations

- **Avoiding bias in prompts** - a prompt that assumes a particular demographic,
  gender, or background as the "default" can produce biased or exclusionary output
  - phrasing prompts neutrally matters, especially for anything user-facing
- **Accuracy** - AI models can produce confident-sounding but factually wrong output
  ("hallucination") - always verify generated facts, code behaviour, and especially
  security-sensitive logic rather than trusting it blindly
- **Privacy** - avoid pasting sensitive data (real customer PII, production
  credentials, proprietary algorithms your company hasn't approved for external
  tools) into prompts, especially with third-party AI services
- **Responsible AI usage** - understanding that AI-generated code/content still
  needs human review, especially anything touching security, compliance, or
  safety-critical logic

## Hands-on: writing coding-task prompts

A weak prompt:
```
Write a function to validate input
```

A strong prompt, applying the practices above:
```
Write a Java method `validateTaskTitle(String title)` for a Spring Boot REST API
(the Task Manager API from Week 3). It should:
- Throw an IllegalArgumentException with message "Title is required" if title is
  null or blank
- Throw an IllegalArgumentException with message "Title must be under 100 characters"
  if title.length() > 100
- Return normally (no return value) if the title is valid
Include Javadoc comments explaining each check.
```

The strong version specifies: the exact method signature, the framework/project
context, exact error messages expected, and the documentation style wanted - leaving
very little room for the model to guess wrong.

Reference: https://www.promptingguide.ai/
