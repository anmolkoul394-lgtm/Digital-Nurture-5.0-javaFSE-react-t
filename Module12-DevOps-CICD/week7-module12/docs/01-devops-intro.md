# 1. Introduction to DevOps

## What is DevOps?
DevOps = **Dev**elopment + **Op**erations — a set of practices and culture
that unifies software development and IT operations, aiming to shorten the
development lifecycle and deliver features, fixes, and updates frequently,
in close alignment with business goals.

## Goals and Benefits
| Goal | Benefit |
|---|---|
| Faster delivery | Smaller, frequent releases instead of big-bang launches |
| Improved collaboration | Dev and Ops share responsibility instead of "throwing code over the wall" |
| Higher quality | Automated testing catches issues earlier |
| Faster recovery | Automated rollback / monitoring reduces downtime |
| Scalability | Infrastructure-as-Code makes environments reproducible |

## Key DevOps Practices
- **Continuous Integration (CI)** — merge code changes frequently, build/test automatically.
- **Continuous Delivery/Deployment (CD)** — automatically prepare (or ship) every change that passes CI.
- **Infrastructure as Code (IaC)** — define servers/networks in version-controlled config (Terraform, CloudFormation).
- **Monitoring & Logging** — observe applications in production continuously.
- **Automated Testing** — unit, integration, and end-to-end tests run on every change.
- **Configuration Management** — tools like Ansible/Chef/Puppet keep environments consistent.
