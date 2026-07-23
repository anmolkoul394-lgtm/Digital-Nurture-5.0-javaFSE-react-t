# Introduction to Generative AI

## What Generative AI actually is

**Generative AI** refers to models that CREATE new content - text, code, images,
audio - rather than just analyzing or classifying existing content. The model
learns the underlying patterns/structure of huge amounts of training data, then
generates new output that follows those same patterns.

## Generative vs Discriminative AI

This is the core distinction worth understanding clearly:

| | Discriminative AI | Generative AI |
|---|---|---|
| Question it answers | "What is this?" (classify/predict) | "Create something like this" |
| Example task | Is this email spam or not? | Write an email from scratch |
| Example task | Is this a picture of a cat? | Generate a picture of a cat |
| Typical output | A label, a category, a number | New text, code, images, audio |

A spam filter is discriminative - it looks at an email and decides "spam" or
"not spam". An LLM like the one answering you right now is generative - given a
prompt, it produces new text that didn't exist before, one token at a time.

## Overview of GenAI applications

- **Text generation** - writing assistants, chatbots, summarization tools
- **Code completion** - GitHub Copilot (the rest of this module), which suggests
  and writes code as you type, based on the surrounding context of your project
- **Image creation** - tools like Midjourney/DALL-E generate images from text
  descriptions
- **Chatbots** - conversational assistants (like this one) that hold a dialogue,
  answer questions, and help with tasks

## A brief history

```
1960s   Early chatbots (ELIZA) - simple pattern-matching, no real "understanding"
2014    GANs (Generative Adversarial Networks) - two neural networks competing,
        one generating fake data, one detecting it - a big step for image generation
2020    GPT-3 - a large language model showing surprisingly fluent, general-purpose
        text generation, trained on massive amounts of internet text
2022    ChatGPT - packaged a GPT-class model into a conversational interface,
        bringing LLMs to a mainstream, non-technical audience for the first time
2022+   GitHub Copilot and beyond - the same underlying technology applied
        specifically to writing code, integrated directly into IDEs
```

The throughline across this whole timeline: models got progressively better at
capturing patterns in language (and eventually code, images) from larger and larger
amounts of training data, and the interfaces around them got progressively easier
for non-specialists to actually use.

## Why this matters for a developer specifically

Generative AI, in the form of tools like GitHub Copilot, has become part of the
everyday development workflow - not a replacement for understanding your code, but
a genuinely useful accelerator for boilerplate, tests, documentation, and
first-drafts of unfamiliar APIs. The rest of this module is about using it well
(and safely) rather than just turning it on and accepting everything it suggests.

Reference: https://www.geeksforgeeks.org/artificial-intelligence/what-is-generative-ai/
