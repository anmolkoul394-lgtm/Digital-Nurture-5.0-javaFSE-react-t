# 3. Branching and Merging

## Introduction to Branching
A branch is just a movable pointer to a commit. `main`/`master` is the
default branch; create new ones to work in isolation.

```bash
git branch feature-login          # create a branch
git checkout feature-login        # switch to it
git checkout -b feature-login     # create + switch in one step
git switch feature-login          # newer syntax for switching
git branch                        # list local branches
git branch -d feature-login       # delete a merged branch
```

## Merging Changes
```bash
git checkout main
git merge feature-login    # merge feature-login INTO main
```
- **Fast-forward merge**: main hasn't moved since the branch was created —
  Git just moves the pointer forward, no merge commit.
- **3-way merge**: both branches have new commits — Git creates a merge
  commit with two parents.

## Handling Merge Conflicts
Conflicts happen when the same lines were changed differently on both
branches. Git marks them in the file:
```
<<<<<<< HEAD
your version
=======
their version
>>>>>>> feature-login
```
Steps to resolve:
1. Open the file, manually edit to the correct final content, remove the
   `<<<<<<<`/`=======`/`>>>>>>>` markers.
2. `git add <file>` to mark it resolved.
3. `git commit` to complete the merge.

## Branching Strategies
| Strategy | Idea |
|---|---|
| **Feature Branching** | One branch per feature/bugfix, merged into main when done |
| **Release Branching** | A dedicated branch cut for stabilizing a release (`release/1.2`) |
| **Git Flow** | Formal model: `main` (production), `develop` (integration), `feature/*`, `release/*`, `hotfix/*` branches |
