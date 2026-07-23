# 4. Agile User Stories

## What is a User Story?
A short, plain-language description of a feature from the perspective of
the person who wants it — a placeholder for a conversation between the
team and the customer, not a full spec.

## Standard Format
```
As a [type of user],
I want [some goal],
so that [some reason/benefit].
```
Example:
```
As a registered customer,
I want to save items to a wishlist,
so that I can buy them later without searching again.
```

## The INVEST Principle
A good user story should be:
| Letter | Meaning |
|---|---|
| **I** | Independent — can be developed/delivered without depending on other stories |
| **N** | Negotiable — details can be discussed, not a rigid contract |
| **V** | Valuable — delivers real value to a user or the business |
| **E** | Estimable — team can reasonably estimate the effort |
| **S** | Small — fits comfortably within a single sprint |
| **T** | Testable — clear enough to write acceptance criteria/tests against |

## Acceptance Criteria — Given/When/Then
Acceptance criteria define exactly when a story is considered complete.
The **Given-When-Then** format (from BDD) works well:
```
Given [initial context/state],
When [an action is taken],
Then [expected outcome].
```
Example (for the wishlist story above):
```
Given I am logged in and viewing a product page,
When I click "Add to Wishlist",
Then the product appears in my Wishlist page,
And I see a confirmation toast message.
```

## Writing User Stories in Practice
- Keep them small — if a story needs "and" to describe its goal, it might
  be two stories.
- Write acceptance criteria WITH the Product Owner, not after the fact.
- Avoid technical implementation details in the story itself — that's a
  team design discussion, not part of the story.
