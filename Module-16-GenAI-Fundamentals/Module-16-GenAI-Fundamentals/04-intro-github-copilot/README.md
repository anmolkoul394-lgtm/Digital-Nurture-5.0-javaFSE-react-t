# Introduction to GitHub Copilot

## What GitHub Copilot is

**GitHub Copilot** is an AI pair programmer that integrates directly into your IDE
- it reads the code you're currently working on (and nearby open files) and
suggests completions, whole functions, and even entire files, in real time as you type.

## How Copilot works, at a high level

Copilot sends context from your editor - the current file, cursor position, and
some surrounding open files/imports - to a large language model trained heavily on
public code. The model predicts what code is likely to come next, and the
suggestion appears inline as greyed-out "ghost text" you can accept, ignore, or
edit.

```
You type:  // calculate the average of a list of integers
           public double
Copilot suggests (greyed out):  public double calculateAverage(List<Integer> numbers) {
                                     return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
                                 }
```

This ties directly back into the Context Engineering topic - Copilot's suggestion
quality depends heavily on what context (comments, existing code style, imports,
open files) is available to it at the moment you're typing.

## Copilot as an evolution of code completion

Traditional IDE autocomplete suggests based on known APIs and syntax (e.g. "here
are the methods available on a `List`"). Copilot goes much further - it can
generate entire logical blocks of code based on a comment describing intent, infer
patterns from the rest of your codebase, and even write tests for existing code, none
of which traditional autocomplete does.

## Supported IDEs and languages

Copilot works across most mainstream editors - Visual Studio Code, Visual Studio,
JetBrains IDEs (IntelliJ, PyCharm, etc.), and Neovim - and across essentially every
popular programming language, though quality varies somewhat by language based on
how much public training code exists for it (Java, Python, JavaScript/TypeScript
are all very well supported, which matters directly for this Java-focused course).

## What Copilot is (and isn't) good at

- Good at: boilerplate, repetitive patterns, common algorithms, writing tests
  for existing code, translating a clear comment into working code
- Less reliable at: business logic specific to your company/domain that it's never
  seen before, anything requiring up-to-the-minute knowledge (new library versions,
  recent API changes), and it can still confidently produce code that looks right
  but has subtle bugs - it's a productivity tool, not a replacement for understanding
  what you're shipping (more on this in the Security and Ethics topic)

Reference: https://www.geeksforgeeks.org/git/github-copilot/
