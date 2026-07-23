# 5. Docker Engine & Container Orchestration

## What is Docker Engine?
The client-server application that makes Docker work, made of 3 parts:
- **Docker Daemon (`dockerd`)** — background service that builds/runs/manages containers.
- **REST API** — the interface tools use to talk to the daemon.
- **Docker CLI (`docker`)** — the command-line client you type commands into, which talks to the daemon over the REST API.

## Container Orchestration
### What is it?
Automated management of many containers across many machines: scheduling
where they run, restarting failed ones, scaling up/down, load balancing
traffic between replicas, and rolling out updates safely.

### Why do we need it?
Running a handful of containers by hand with `docker run`/Compose is fine
for local dev or a single server. In production with dozens/hundreds of
containers across a cluster of machines, you need automation for:
- Placing containers on machines with available capacity
- Restarting containers that crash
- Scaling a service up under load
- Rolling updates with zero downtime
- Service discovery between containers across nodes

### Benefits
- High availability (auto-restart, self-healing)
- Horizontal scaling on demand
- Efficient resource utilization across a cluster
- Declarative desired-state management ("I want 5 replicas" — the
  orchestrator makes it so, continuously)

### What is Kubernetes?
The most widely used container orchestration platform. You describe
your desired state (Deployments, Services, ConfigMaps) in YAML, and
Kubernetes continuously works to match the cluster's actual state to it.

### Container Orchestration vs plain Docker
| | Plain Docker / Compose | Orchestration (Kubernetes) |
|---|---|---|
| Scope | Single host | Cluster of many hosts |
| Scaling | Manual | Automatic / declarative |
| Self-healing | No | Yes — restarts/reschedules failed containers |
| Best for | Local dev, small single-server apps | Production, multi-service, high-availability systems |
