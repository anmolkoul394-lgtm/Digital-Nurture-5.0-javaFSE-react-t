# Week 7 — Module 13: Containerization using Docker

DN5.0 Java FSE plan ke **Module 13** subtopics — concept cheat-sheets +
ek real **Spring Boot + MySQL** app jo Docker Compose se ek command mein
chal jaata hai (multi-container, volumes, networking sab demonstrate karta hai).

## Contents

| File | Covers |
|---|---|
| `docs/01-docker-commands.md` | Basic commands, `docker run` variants, exec |
| `docs/02-docker-images.md` | Image layers, base/parent image, Dockerfile method, build context |
| `docs/03-docker-compose.md` | What is Compose, YAML config, basic commands |
| `docs/04-docker-storage-and-networking.md` | Volumes, storage drivers, networks |
| `docs/05-docker-engine-and-orchestration.md` | Docker Engine (CLI/daemon/REST API), Kubernetes/orchestration overview |
| `docker-demo-app/Dockerfile` | Multi-stage build for the Spring Boot app |
| `docker-demo-app/docker-compose.yml` | App + MySQL, custom network, named volume |
| `docker-demo-app/.dockerignore` | Keeps the build context small |

## Run it
```bash
cd docker-demo-app
docker compose up --build
```
- App: `http://localhost:8080/api/notes`
- MySQL data persists in a named volume (`db-data`) across restarts.

```bash
docker compose down          # stop
docker compose down -v       # stop AND wipe the volume (fresh DB next time)
```

## GitHub pe push karna
```bash
git init
git add .
git commit -m "Week 7: Module 13 - Containerization using Docker"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
