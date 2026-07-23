# 2. Docker Images

## What is a Docker Image?
A read-only template with everything needed to run an app — code, runtime,
libraries, environment variables, config files.

## Image Layers
Each instruction in a Dockerfile (`FROM`, `RUN`, `COPY`, ...) creates a new
**layer**. Layers are cached and shared between images, which is why
rebuilds are usually fast (only changed layers get rebuilt).

- **Base/Parent Image**: the starting point (e.g. `eclipse-temurin:17-jre`).
- **Container Layer**: the single writable layer added on top when a
  container is created from an image — anything the running app writes
  goes here (and is lost when the container is removed, unless a volume
  is mounted).

## Docker Manifest / Registries / Repositories
- **Manifest**: metadata describing an image (layers, architecture, config).
- **Container Registry**: a server that stores images (Docker Hub, GHCR,
  AWS ECR, Azure ACR).
- **Repository**: a named collection of related image tags within a
  registry (e.g. `myorg/hello-service:1.0`, `myorg/hello-service:latest`).

## How to Create a Docker Image
1. **Interactive method** (rarely used in practice): `docker run -it <base>`,
   make changes inside the shell, then `docker commit <container> <new-image>`.
2. **Dockerfile method** (standard): write a `Dockerfile`, then
   `docker build -t my-app:1.0 .`

## Docker Build Context
The `.` at the end of `docker build -t my-app .` is the **build context** —
the set of files sent to the Docker daemon that `COPY`/`ADD` instructions
can reference. Use a `.dockerignore` file to exclude `target/`,
`node_modules/`, `.git/`, etc. so the context stays small and builds fast.
