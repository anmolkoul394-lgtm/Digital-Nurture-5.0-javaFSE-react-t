# 3. Docker Compose

## What is Docker Compose?
A tool for defining and running **multi-container** applications using a
single YAML file (`docker-compose.yml`) — instead of typing many long
`docker run` commands by hand.

## Benefits
- One command (`docker compose up`) starts the entire stack.
- Services can reference each other by name (Compose sets up a shared
  network automatically).
- Environment-specific config lives in one readable file, version-controlled
  alongside the code.

## Install Docker Compose
Ships built into modern Docker Desktop / Docker Engine as `docker compose`
(no separate install needed). Verify with:
```bash
docker compose version
```

## Basic Commands
```bash
docker compose up            # start all services (foreground)
docker compose up -d         # start in detached mode
docker compose up --build    # rebuild images before starting
docker compose down          # stop and remove containers/network
docker compose down -v       # also remove named volumes
docker compose ps            # list services in this project
docker compose logs -f app   # follow logs for one service
```

## The YAML Configuration File
See `docker-demo-app/docker-compose.yml` in this repo for a real example
with two services (`app` + `db`), a custom network, and a named volume.
Key sections:
```yaml
services:
  app:
    build: .          # build from local Dockerfile
    ports: ["8080:8080"]
    depends_on: [db]
  db:
    image: mysql:8.0
    volumes: ["db-data:/var/lib/mysql"]
volumes:
  db-data:
```
