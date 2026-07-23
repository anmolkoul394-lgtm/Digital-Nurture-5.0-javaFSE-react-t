# 1. Introduction to Version Control & Understanding Git

## Version Control Concepts
- **Definition**: a system that records changes to files over time so you
  can recall specific versions later.
- **Purpose**: track history, enable collaboration, provide a safety net
  (undo mistakes), support parallel work via branches.
- **Benefits**: full change history, easy rollback, multiple people working
  without overwriting each other, audit trail (who changed what, when, why).

## Types of Version Control Systems
| Type | Example | How it works |
|---|---|---|
| Local VCS | RCS | Version database on your own machine only |
| Centralized VCS (CVCS) | SVN, Perforce | One central server holds all history; clients check out a working copy |
| Distributed VCS (DVCS) | **Git**, Mercurial | Every clone is a full repository with complete history — no single point of failure |

## What is Git
Git is a **Distributed Version Control System (DVCS)**: every developer has
a full copy of the project's history locally, so most operations (commit,
diff, log, branch) work offline and are fast.

## Git Components
| Component | What it is |
|---|---|
| **Working Directory** | The actual files on disk you're editing |
| **Staging Area (Index)** | A holding zone for changes you've `git add`ed, about to be committed |
| **Repository (.git folder)** | The committed history — snapshots, branches, tags |

```
Working Directory  --git add-->  Staging Area  --git commit-->  Repository
```
