# Setup and Configuration

## Installing the GitHub Copilot extension in VS Code

1. Open VS Code
2. Go to the Extensions panel (`Ctrl+Shift+X` / `Cmd+Shift+X`)
3. Search for "GitHub Copilot"
4. Click Install on the official extension published by GitHub
5. VS Code will prompt you to sign in - continue to the next step

## Connecting to a GitHub account

Copilot requires an active GitHub Copilot subscription (or access through an
organization/education program) tied to your GitHub account:

1. After installing the extension, click "Sign in to GitHub" when prompted (or via
   the Command Palette: `Ctrl+Shift+P` → "GitHub Copilot: Sign In")
2. This opens a browser window asking you to authorize VS Code to access your
   GitHub account
3. Once authorized, return to VS Code - a small Copilot icon appears in the status
   bar at the bottom, confirming it's active and signed in

## Beginner-friendly first coding task with Copilot

A good first exercise to get a feel for how Copilot responds to comments and
function signatures:

1. Create a new Java file, `StringHelper.java`
2. Type a comment describing a simple task:
   ```java
   // returns true if the given string is a palindrome, ignoring case and spaces
   ```
3. Start typing the method signature:
   ```java
   public static boolean isPalindrome(String input) {
   ```
4. Pause - Copilot should suggest a completed method body as greyed-out text
5. Press `Tab` to accept the suggestion, or keep typing to ignore it and write your
   own version instead

## Files

- `first-task-example.md` - a worked walkthrough of the exercise above, showing
  what a typical Copilot suggestion looks like for this exact prompt, and a couple
  of variations to try (asking for a different edge case, asking it to handle nulls)
  so the exercise isn't just "accept whatever it gives you" but "compare what changes
  when you phrase the comment differently".

Reference: https://www.freecodecamp.org/news/how-to-use-github-copilot-with-visual-studio-code/
