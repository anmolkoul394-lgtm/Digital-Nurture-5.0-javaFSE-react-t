# Amazon ECS - Containers Basics

## Docker and containers, quickly

A **container** packages an application together with everything it needs to run
(code, runtime, libraries, config) into a single portable unit. Unlike a full VM,
containers share the host machine's OS kernel, which makes them much lighter and
faster to start (seconds vs minutes for a VM). Docker is the tool most commonly
used to build and run containers.

```
VM: App + full guest OS + hypervisor + host OS   <- heavy, minutes to boot
Container: App + libraries, sharing the host OS kernel   <- light, seconds to boot
```

## What ECS actually is

**Amazon ECS (Elastic Container Service)** is AWS's service for running and managing
containers at scale - instead of manually SSH-ing into a server and running
`docker run`, ECS handles scheduling containers onto available compute, restarting
them if they crash, and scaling the number of running containers up or down.

## ECS vs EC2 - how they relate, not compete

This distinction confuses people early on: ECS isn't a replacement for EC2, it's
built to run ON TOP of compute - you get to choose:
- **EC2 launch type** - ECS schedules your containers onto a fleet of EC2 instances
  that you manage (you're still responsible for those instances' patching, sizing, etc.)
- **Fargate launch type** - "serverless" containers - you just describe what to run,
  AWS provisions the underlying compute for you, and you're billed per container
  resource usage instead of per EC2 instance.

Most new projects lean toward Fargate specifically because it removes server
management entirely.

## Core ECS concepts

- **Task Definition** - a blueprint describing which container image to run, how
  much CPU/memory it needs, and its port mappings (similar in spirit to a Docker
  Compose file, but AWS-specific).
- **Task** - one running instance of a task definition.
- **Service** - keeps a specified number of tasks running at all times, replacing
  any that crash, and can attach a load balancer in front of them.
- **Cluster** - a logical grouping of tasks/services, sitting on either EC2 or
  Fargate compute.

## Creating and managing containers in ECS (CLI walkthrough, simplified)

```bash
# 1) Create a cluster
aws ecs create-cluster --cluster-name demo-cluster

# 2) Register a task definition (see task-definition.json in this folder)
aws ecs register-task-definition --cli-input-json file://task-definition.json

# 3) Run the task on Fargate (no EC2 instances to manage)
aws ecs run-task \
  --cluster demo-cluster \
  --task-definition demo-task \
  --launch-type FARGATE \
  --network-configuration "awsvpcConfiguration={subnets=[subnet-0123456789],assignPublicIp=ENABLED}"
```

## Files

- `task-definition.json` - a sample ECS task definition for a simple web app container.
- `Dockerfile` - a minimal example Dockerfile for a small Java app, the kind of image
  you'd push to Amazon ECR (Elastic Container Registry) and reference in the task
  definition above.

Reference: https://www.geeksforgeeks.org/devops/aws-tutorial/
