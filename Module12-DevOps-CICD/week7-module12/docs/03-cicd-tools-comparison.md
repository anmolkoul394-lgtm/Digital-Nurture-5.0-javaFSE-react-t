# 3. CI/CD Tools and Platforms

| Tool | Hosting | Config format | Strengths |
|---|---|---|---|
| **Jenkins** | Self-hosted | `Jenkinsfile` (Groovy) | Extremely flexible, huge plugin ecosystem, full control |
| **GitHub Actions** | GitHub-hosted (or self-hosted runners) | YAML in `.github/workflows/` | Zero setup if code is already on GitHub, huge marketplace of reusable actions |
| **GitLab CI/CD** | GitLab-hosted (or self-hosted) | `.gitlab-ci.yml` | Deeply integrated with GitLab (issues, registry, environments) |
| **CircleCI** | Cloud-hosted | `.circleci/config.yml` | Fast parallel builds, good Docker-native support |

## Which one is used in this project?
`sample-app/.github/workflows/ci-cd.yml` uses **GitHub Actions** because
it needs zero extra infrastructure — the moment you push to GitHub, the
pipeline runs on GitHub's own servers.
