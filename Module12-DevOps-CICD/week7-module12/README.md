# Week 7 — Module 12: DevOps and CI/CD

DN5.0 Java FSE plan ke **Module 12** subtopics — concept guides + ek chhota
Spring Boot app jisme ek **real, runnable GitHub Actions CI/CD pipeline**
already wired hai.

## Contents

| File | Covers |
|---|---|
| `docs/01-devops-intro.md` | What is DevOps, goals/benefits, key practices |
| `docs/02-ci-cd-concepts.md` | CI vs CD (Continuous Delivery vs Deployment), benefits |
| `docs/03-cicd-tools-comparison.md` | Jenkins vs GitHub Actions vs GitLab CI/CD vs CircleCI |
| `sample-app/` | Minimal Spring Boot service |
| `sample-app/.github/workflows/ci-cd.yml` | Actual CI/CD pipeline: build → test → package → (simulated) deploy |

## Try the pipeline
1. Push `sample-app/` to a GitHub repo (instructions below).
2. Go to the repo's **Actions** tab on GitHub — the workflow in
   `.github/workflows/ci-cd.yml` runs automatically on every push to `main`
   and on every Pull Request.
3. It runs: checkout → set up Java 17 → `mvn test` → `mvn package` →
   uploads the built JAR as a downloadable artifact → a final "deploy"
   job that only runs on `main` (simulated with an echo, since there's no
   real server here — replace it with your actual deploy step).

## GitHub pe push karna
```bash
cd sample-app
git init
git add .
git commit -m "Week 7: Module 12 - DevOps and CI/CD demo"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
Push hote hi Actions tab mein pipeline apne aap chalegi.
