# Week 6 — Module 11: Version Control - GIT

DN5.0 Java FSE plan ke **Module 11** ke saare subtopics — concept guides +
ek hands-on practice script jisse actual commands chala ke seekh sakte ho.

## Contents

| File | Covers |
|---|---|
| `docs/01-intro-and-git-basics.md` | Version control concepts, what is Git, DVCS, Git components (working dir/staging/repo) |
| `docs/02-setup-and-basic-commands.md` | Install/configure Git, init/clone, add, commit, status, log |
| `docs/03-branching-and-merging.md` | Branches, merging, conflicts, branching strategies (Git Flow etc.) |
| `docs/04-remotes-and-collaboration.md` | Remote repos, push/pull, forking, PRs, collaboration workflows |
| `git-practice-repo/practice.sh` | Runnable script that walks through init → commit → branch → merge → conflict → resolve |

## Fastest way to learn: run the practice script
```bash
cd git-practice-repo
bash practice.sh
```
Ye script khud ek naya git repo banata hai aur har command ko step-by-step
chala ke dikhata hai, including ek deliberate merge conflict jise tumhe
resolve karna hai.

## GitHub pe push karna (is guide ko khud)
```bash
git init
git add .
git commit -m "Week 6: Module 11 - Version Control - GIT"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
