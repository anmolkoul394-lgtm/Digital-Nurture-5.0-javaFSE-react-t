# First Copilot Task - Worked Walkthrough

## The setup

Starting from a blank `StringHelper.java`, type this comment and the beginning of
the method signature:

```java
// returns true if the given string is a palindrome, ignoring case and spaces
public static boolean isPalindrome(String input) {
```

## A typical Copilot suggestion (what you'd likely see, greyed out)

```java
    String cleaned = input.toLowerCase().replaceAll("\\s+", "");
    String reversed = new StringBuilder(cleaned).reverse().toString();
    return cleaned.equals(reversed);
}
```

Notice Copilot picked up BOTH conditions mentioned in the comment ("ignoring case
and spaces") without them being separately spelled out as a bullet list - it read
the natural-language comment and translated both requirements into code.

## Try changing the comment and see what changes

**Variation 1 - add a null-safety requirement:**
```java
// returns true if the given string is a palindrome, ignoring case and spaces
// returns false if the input is null
public static boolean isPalindrome(String input) {
```
Copilot's suggestion should now include a null check at the top, since the comment
now explicitly mentions that case - a good demonstration of how much suggestion
quality depends on what's actually stated (tying back to Prompt/Context Engineering).

**Variation 2 - ask for punctuation to be ignored too:**
```java
// returns true if the given string is a palindrome, ignoring case, spaces, and punctuation
public static boolean isPalindrome(String input) {
```
This usually changes the regex Copilot suggests from `\\s+` (whitespace only) to
something broader like `[^a-zA-Z0-9]` (strip anything that isn't a letter or digit) -
a concrete example of how a more precise comment produces a more precise suggestion.

## What to take away from this exercise

The method body Copilot generates isn't magic - it's directly shaped by the wording
of your comment and the method signature you'd already started writing. Getting
good results from Copilot is largely the same skill as writing a good docstring or
comment in the first place: being specific about what the function should do and
what edge cases matter.
