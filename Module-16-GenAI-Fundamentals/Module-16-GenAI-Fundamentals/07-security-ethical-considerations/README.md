# Security and Ethical Considerations

## Understanding AI-generated code risks

**Vulnerabilities** - Copilot (and any code-generating AI) learned from a huge
amount of public code, some of which contains security flaws. It can suggest code
with real vulnerabilities - SQL built via string concatenation instead of
parameterized queries, weak/no input validation, hardcoded credentials as
placeholder values that get accidentally left in - without any warning that
anything is wrong.

**Hallucinations** - the model can confidently generate code that references
methods, classes, or libraries that don't actually exist, or that misuses a real
API in a way that looks plausible but is subtly wrong. This is especially common
for less popular libraries or very recent API changes the model wasn't trained on.

**The practical takeaway**: every Copilot suggestion needs the SAME review
discipline as code written by a junior teammate - read it, understand why it does
what it does, and verify it against tests before trusting it, rather than accepting
it purely because it compiled or looked right at a glance.

## Licensing and attribution concerns (copyleft risk)

Because Copilot is trained on public code (including code under restrictive
licenses like GPL), there's a real - if statistically small - possibility it
reproduces a recognizable snippet from a copyleft-licensed project. Using that
snippet in a commercial/proprietary codebase without attribution could create a
licensing problem. GitHub has added filtering to reduce verbatim reproduction of
training data, but it's still worth being aware of, especially for anything unusually
distinctive (not a generic five-line helper, but a longer, structurally unique block).

## Data privacy and usage policies

**What code is sent to GitHub's servers**: to generate a suggestion, Copilot sends
the relevant context - your current file, and some surrounding open files/snippets
- to GitHub/OpenAI's servers for processing. This has real implications:
- Avoid using Copilot (or configure organization-level settings appropriately) on
  files containing genuine secrets, API keys, or credentials - even temporarily
  pasted-in test values, since they leave your machine as part of the request
- Understand your organization's policy before using Copilot on proprietary or
  client-confidential codebases - some companies restrict or disable Copilot
  entirely for certain repositories for exactly this reason
- GitHub Copilot Business/Enterprise plans offer stronger data-handling guarantees
  (e.g. not using your code to train the underlying model) compared to the
  individual/free tiers - worth checking which tier your organization is actually on

## Responsible use of Copilot - best practices

- **Review every suggestion before accepting it** - especially anything touching
  authentication, authorization, cryptography, or handling user input
- **Never blindly accept security-sensitive code** - password hashing, JWT
  validation (recall Week 3's Module 7 security topic), SQL query construction -
  these deserve extra scrutiny, not less, specifically because a subtly wrong
  version can look completely correct at a glance
- **Keep tests as your safety net** - accepting a Copilot suggestion, then running
  the existing test suite against it, catches a large share of the subtle
  correctness bugs that a visual read-through alone would miss
- **Don't let it replace understanding your own code** - if you can't explain why a
  suggestion works, that's a signal to slow down and actually read it, not a reason
  to trust it more because "the AI wrote it"
- **Be mindful of what you paste into ANY AI tool, not just Copilot** - the same
  privacy discipline applies whether you're asking Copilot for a code suggestion or
  asking any chat-based assistant a question about your codebase

## A closing thought for this module (and this course)

Generative AI tools are genuinely useful accelerators for a working developer - but
every topic in this course, from SOLID principles and design patterns in Week 1
through Spring Security in Week 3, exists precisely because writing correct,
secure, maintainable software requires understanding, not just generating, code.
Copilot (and tools like it) are best used to speed up the parts you already
understand well enough to review critically - which is exactly why this module
comes last, after the rest of the curriculum, rather than first.

Reference: https://blog.gitguardian.com/github-copilot-security-and-privacy/
