# Elastic Load Balancer - ALB & NLB

## What a load balancer does

Distributes incoming traffic across multiple backend instances/containers, so no
single server gets overwhelmed, and so traffic automatically stops going to any
instance that's unhealthy. This is what sits in the "public subnet" position in the
VPC diagram from the previous topic - the ONE thing directly reachable from the
internet, fanning requests out to instances that aren't.

```
Internet --> Load Balancer --> [Instance A, Instance B, Instance C]
                                (traffic spread across all healthy instances)
```

## Application Load Balancer (ALB) - Layer 7

Operates at the HTTP/HTTPS level (Layer 7 of the OSI model) - meaning it understands
the actual content of requests, not just raw packets. This lets it make routing
decisions based on things like the URL path or hostname:

```
/api/*      -> routes to the API service's target group
/static/*   -> routes to a target group serving static assets
```

Most modern web applications use an ALB, since path-based routing like this is
extremely common (e.g. splitting a monolith's traffic across several newer
microservices during a migration).

## Network Load Balancer (NLB) - Layer 4

Operates at the TCP/UDP level (Layer 4) - it doesn't look at HTTP content at all,
just forwards raw connections. This makes it extremely fast and able to handle
massive traffic spikes, but it can't do the path-based routing an ALB can.

## ALB vs NLB - when to use which

| | ALB | NLB |
|---|---|---|
| Layer | 7 (HTTP/HTTPS) | 4 (TCP/UDP) |
| Routing | Can route by path, hostname, headers | Simple connection forwarding only |
| Performance | Very good | Extremely high (millions of requests/sec) |
| Use case | Typical web apps, REST APIs, microservices | Ultra-low-latency needs, non-HTTP protocols, extreme throughput |

For a typical Spring Boot REST API (like the one built in Week 3 of this course), an
ALB is almost always the right choice - path-based routing and HTTPS termination are
exactly what a REST API's load balancer needs.

## Target Groups and Health Checks

A **target group** is the set of instances/containers a load balancer sends traffic
to. The load balancer periodically sends a **health check** request to each target
(e.g. `GET /actuator/health` - tying back to the Actuator topic from Week 3) - any
target that fails enough consecutive health checks gets marked unhealthy and
temporarily removed from rotation, until it starts passing again.

```
Health check config example:
  Path: /actuator/health
  Interval: 30 seconds
  Healthy threshold: 2 consecutive successes
  Unhealthy threshold: 3 consecutive failures
```

## Files

- `alb-target-group-config.json` - a sample ALB target group configuration, including
  health check settings, pointed at the same `/actuator/health` endpoint built in
  Week 3's Actuator topic.

Reference: https://www.geeksforgeeks.org/cloud-computing/top-aws-services/
