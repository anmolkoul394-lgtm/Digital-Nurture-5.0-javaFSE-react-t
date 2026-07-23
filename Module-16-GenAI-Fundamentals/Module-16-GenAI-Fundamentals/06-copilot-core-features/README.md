# Core Features and Capabilities

## Code suggestions and completions (Tab to accept)

The most basic and frequently used feature - as you type, Copilot shows a
greyed-out ("ghost text") suggestion for how your current line or block might
continue. Press `Tab` to accept it as-is, keep typing to write your own version
instead, or use `Alt+]` / `Alt+[` (Windows/Linux) to cycle through alternative
suggestions if more than one is available.

## Writing functions and boilerplate code from comments

Exactly what the setup topic's exercise demonstrated - describe what you want in a
comment, and Copilot drafts an implementation. This is particularly effective for:
- Repetitive CRUD-style methods (see the example below, based on Week 3's Task API)
- Common utility functions (validation, formatting, parsing)
- Boilerplate that follows a well-known pattern (getters/setters, builder methods,
  equals/hashCode - similar in spirit to what Lombok generates automatically in
  Week 1's Module 4, but here YOU review and accept the generated code line by line)

**Example** - writing a new repository method by comment alone:
```java
// find all tasks that are not done, ordered by due date ascending
List<Task> findByDoneFalseOrderByDueDateAsc();
```
Given this comment above an empty interface method slot, Copilot can often
correctly infer the entire Spring Data JPA method signature shown above, purely from
naming convention knowledge it's seen in countless other Spring Data repositories.

## Generating comments and documentation automatically

Copilot can also work in the OPPOSITE direction - given existing code with no
comments, it can generate a Javadoc block describing what a method does:

```java
// Select the method, then ask Copilot (via its chat panel) to "add Javadoc"
/**
 * Checks whether the given task title is valid.
 *
 * @param title the task title to validate
 * @throws IllegalArgumentException if the title is null, blank, or exceeds 100 characters
 */
public void validateTaskTitle(String title) { ... }
```

Useful for quickly documenting an existing, undocumented codebase - though it's
worth double-checking the generated description actually matches what the code does,
rather than what it LOOKS like it does at a glance.

## Refactoring and optimizing existing code

Through Copilot's chat/inline chat feature, you can select a block of code and ask
for a specific transformation:

```
Refactor this method to use a switch expression instead of if-else chains
```
```
This method is O(n^2) - can it be made more efficient?
```

Copilot proposes a rewritten version, which you review and accept/reject/edit -
same review discipline as any other suggestion.

## Creating test cases with Copilot

Given an existing method, Copilot can draft JUnit tests covering the obvious cases
(and often a few edge cases too):

```java
// Given this method already exists:
public boolean isPalindrome(String input) { ... }

// Ask Copilot chat: "write JUnit 5 tests for isPalindrome, covering normal cases,
// empty string, and null input"
```

This tends to produce a reasonable FIRST DRAFT of test coverage quickly - genuinely
useful for getting started, but still worth reviewing against the same standards
covered in Week 1's TDD/JUnit module (are the assertions actually meaningful? are
edge cases really covered, or just superficially mentioned?).

## Files

- `example-generated-tests.md` - shows a full worked example: an existing method,
  the prompt used to ask Copilot for tests, and what a typical generated test class
  looks like, reviewed against the AAA (Arrange-Act-Assert) pattern from Week 1's TDD module.

Reference: https://www.geeksforgeeks.org/git/github-copilot/
