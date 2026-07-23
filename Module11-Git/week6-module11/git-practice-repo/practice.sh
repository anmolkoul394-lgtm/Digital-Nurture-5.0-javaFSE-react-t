#!/usr/bin/env bash
# Module 11 - Version Control (GIT) hands-on practice script.
# Creates a brand-new git repo in ./demo-repo and walks through every
# subtopic: init, add, commit, status, log, branching, merging, a
# deliberate merge conflict, and remote-related commands (shown as
# comments since there's no real remote in this demo).
set -e

echo "=== Step 1: git init ==="
rm -rf demo-repo
mkdir demo-repo && cd demo-repo
git init -b main 2>/dev/null || { git init; git branch -m main; }
git config user.name "Demo User"
git config user.email "demo@example.com"

echo -e "\n=== Step 2: first commit (git add, git commit) ==="
echo "# Demo Project" > README.md
git add README.md
git commit -m "Initial commit: add README"

echo -e "\n=== Step 3: git status & git log ==="
echo "console.log('hello')" > app.js
git status
git add app.js
git commit -m "Add app.js"
git log --oneline

echo -e "\n=== Step 4: branching ==="
git checkout -b feature-greeting
echo "console.log('hello world')" > app.js
git commit -am "Update greeting message"
git checkout main
echo "// main branch note" >> app.js
git commit -am "Add a note on main"

echo -e "\n=== Step 5: merging with a CONFLICT (both branches touched app.js) ==="
set +e
git merge feature-greeting
echo "^ merge stopped due to conflict - open app.js, resolve the markers,"
echo "  then run: git add app.js && git commit"
set -e

echo -e "\n=== Step 6 (manual): resolving the conflict for you in this demo ==="
cat > app.js << 'EOF'
console.log('hello world')
// main branch note
EOF
git add app.js
git commit -m "Merge feature-greeting into main, resolve conflict"

echo -e "\n=== Step 7: final log graph ==="
git log --oneline --graph --all

echo -e "\n=== Step 8: remote commands (reference only - no real remote here) ==="
echo "git remote add origin https://github.com/<user>/<repo>.git"
echo "git push -u origin main"
echo "git pull"

echo -e "\nDone. Explore demo-repo/ and re-run 'git log --oneline --graph --all' anytime."
