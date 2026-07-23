# 4. Remote Repositories & Collaborating with Git

## Adding Remote Repositories
```bash
git remote add origin https://github.com/user/repo.git
git remote -v                      # list remotes
git remote add upstream https://github.com/original/repo.git   # multiple remotes (e.g. for forks)
```

## git pull and git push
```bash
git push -u origin main      # push + set upstream tracking (first time)
git push                     # subsequent pushes
git pull                     # fetch + merge from tracked remote branch
git fetch                    # download changes WITHOUT merging (inspect first)
```

## Handling Remote Branches
```bash
git branch -r                          # list remote-tracking branches
git checkout -b feature origin/feature  # create local branch tracking a remote one
git push origin feature                 # publish a new local branch
git push origin --delete feature        # delete a remote branch
```

## Forking and Pull Requests
1. **Fork** the repo on GitHub (creates your own copy under your account).
2. Clone YOUR fork locally, make changes on a feature branch.
3. Push the branch to your fork, then open a **Pull Request** back to the
   original repo.
4. Maintainers review, discuss, request changes, then merge.

## Git Collaboration Workflows
| Workflow | How it works |
|---|---|
| **Centralized** | Everyone pushes directly to `main` on one shared repo (simple, small teams) |
| **Feature Branch** | Every change gets its own branch, merged via PR after review |
| **Forking Workflow** | Contributors fork the repo, no direct write access needed — common for open source |
| **Gitflow** | Formal branch model (main/develop/feature/release/hotfix) for structured release cycles |
