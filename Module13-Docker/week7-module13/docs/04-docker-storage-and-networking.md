# 4. Docker Storage & Networking

## Storage Drivers
Docker uses a storage driver (overlay2 by default on Linux) to manage the
layered filesystem for images/containers. You rarely change this unless
you have a specific performance/compatibility need.

## Data Volumes
Containers are ephemeral — data written inside a container's writable
layer disappears when the container is removed. **Volumes** solve this by
storing data outside the container's lifecycle, managed by Docker itself.

```bash
docker volume create db-data          # create a named volume
docker volume ls                       # list all volumes
docker volume inspect db-data           # see where it lives on disk
docker run -v db-data:/var/lib/mysql mysql   # mount it into a container
```
In Compose, this is just:
```yaml
volumes:
  - db-data:/var/lib/mysql
```

## Docker Networking
### Default Networks
Every Docker install has 3 built-in networks: `bridge` (default for
standalone containers), `host` (shares the host's network stack), and
`none` (fully isolated).

```bash
docker network ls                       # list all networks
docker network inspect bridge            # inspect a network's containers/config
docker network create my-app-network      # create a custom network
docker run --network my-app-network ...    # attach a container to it
```

### Why a custom network matters
Containers on the SAME custom network can reach each other **by service
name** (Docker's built-in DNS) — e.g. the Spring Boot app connects to
`jdbc:mysql://db:3306/notesdb`, where `db` is just the other service's
name in `docker-compose.yml`. Compose creates this network for you
automatically.
