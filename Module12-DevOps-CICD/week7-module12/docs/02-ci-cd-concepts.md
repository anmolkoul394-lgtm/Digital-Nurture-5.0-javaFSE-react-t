# 2. Understanding CI/CD

## Continuous Integration (CI)
Developers merge their code changes into a shared branch **frequently**
(multiple times a day). Every merge triggers an automated build + test
run, so integration problems are caught within minutes, not weeks.

## Continuous Delivery vs Continuous Deployment (CD)
Both start where CI ends (a tested, packaged build) but differ in the last
step:

| | Continuous Delivery | Continuous Deployment |
|---|---|---|
| Automated up to | Production-ready artifact, staged for release | Fully automatic release to production |
| Human approval needed? | Yes — a person clicks "deploy" | No — every passing build goes live automatically |
| Use case | Regulated industries, careful rollout | High-velocity teams with strong test coverage |

## CI vs CD — the short version
- **CI** = "does the code work together?" (build + test on every merge)
- **CD** = "can we safely ship it?" (package + deploy automatically or with one click)

## Benefits of CI/CD
- Catches bugs early (cheaper to fix)
- Removes manual, error-prone release steps
- Enables frequent, low-risk releases
- Fast feedback loop for developers
- Full audit trail of what was built/deployed and when
