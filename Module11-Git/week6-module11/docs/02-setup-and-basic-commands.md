# 2. Setting Up Git & Basic Commands

## Installing Git
- Download from https://git-scm.com/downloads and run the installer, or
- `sudo apt install git` (Ubuntu/Debian), `brew install git` (Mac).
- Verify: `git --version`

## Configuring Basic Settings
```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
git config --list          # verify settings
```

## Creating a Git Repository
```bash
git init                              # initialize a NEW repo in current folder
git clone https://github.com/user/repo.git   # clone an EXISTING repo
```

## Basic Git Commands

### git add — staging changes
```bash
git add file.txt        # stage one file
git add .                # stage everything in current dir
git add "*.java"         # stage using a wildcard
```

### git commit — committing changes
```bash
git commit -m "Add login feature"
git commit -am "Fix typo"    # add + commit tracked files in one step
```
Good commit message convention: short summary line (<50 chars), blank line,
then details if needed.

### git status — checking repository status
```bash
git status          # shows staged / unstaged / untracked files
git status -s       # short format
```

### git log — viewing commit history
```bash
git log                    # full history
git log --oneline          # one line per commit
git log --oneline --graph --all   # visual branch graph
git log -p -2               # last 2 commits with diffs
git log --author="Selin"    # filter by author
```
