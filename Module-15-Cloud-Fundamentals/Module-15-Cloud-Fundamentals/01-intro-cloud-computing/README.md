# Introduction to Cloud Computing & Service/Deployment Models

## Traditional IT vs Cloud

Before cloud computing, running an application meant buying physical servers,
racking them in a data center, and paying for that hardware whether you used it or
not. Scaling up meant ordering and installing more machines - a process that took
weeks. Cloud computing replaced this with **on-demand, pay-as-you-go access** to
compute, storage, and networking, provided by someone else's data centers (AWS,
Azure, GCP), reachable over the internet.

| Traditional (On-Premises) | Cloud |
|---|---|
| Buy hardware upfront (capital expense) | Pay only for what you use (operating expense) |
| Scaling takes weeks (new hardware) | Scaling takes minutes (spin up more instances) |
| You maintain the physical hardware | The cloud provider maintains the hardware |
| Fixed capacity - either over- or under-provisioned | Elastic - scales with actual demand |

## Virtualization - the idea that makes all of this possible

A single physical server can be split into multiple **virtual machines**, each
behaving like its own independent computer (own OS, own resources), via a layer
called a **hypervisor**. This is what lets a cloud provider rent out "a server" to
you that's actually a slice of a much bigger physical machine, shared safely among
many customers.

## Service-Oriented Architecture (SOA)

A design approach where an application is built from independent, loosely-coupled
**services** that communicate over a network (usually via well-defined APIs), rather
than one single tightly-coupled application. Cloud computing and SOA grew up
together - cloud infrastructure makes it practical to deploy and scale each service
independently. (This connects directly to the microservices style of building
applications that most modern cloud-native systems use.)

## Cloud Service Models: IaaS, PaaS, SaaS

Think of these as different levels of "how much AWS manages for you vs how much
you manage yourself":

| Model | What you manage | What the provider manages | Example |
|---|---|---|---|
| **IaaS** (Infrastructure as a Service) | OS, runtime, app, data | Physical hardware, virtualization, networking | Amazon EC2 |
| **PaaS** (Platform as a Service) | App code, data | OS, runtime, scaling infrastructure | AWS Elastic Beanstalk |
| **SaaS** (Software as a Service) | Just your own data/usage | Everything - the whole application | Gmail, Salesforce |

A useful mental model: IaaS gives you the building's foundation and walls, PaaS
gives you a fully furnished apartment, SaaS gives you a hotel room service already
running.

## Cloud Deployment Models

- **Public Cloud** - infrastructure shared across many customers, owned/operated by
  a provider (AWS, Azure, GCP) - the most common model, cheapest to start with.
- **Private Cloud** - infrastructure dedicated to a single organization, either
  on-premises or hosted by a provider but not shared - used when strict compliance
  or control requirements rule out shared infrastructure.
- **Hybrid Cloud** - a mix of public and private, often used to keep sensitive data
  on-premises while running less sensitive workloads in the public cloud.
- **Community Cloud** - shared infrastructure among a specific group of organizations
  with common concerns (e.g. several government agencies sharing compliance-specific
  infrastructure) - less common than the other three.

## Cloud Service Providers overview

- **AWS (Amazon Web Services)** - the largest and oldest major provider, broadest
  service catalog - this module focuses on AWS specifically, since it's the most
  widely used in industry today.
- **Azure (Microsoft)** - strong in enterprises already using Microsoft's ecosystem
  (Active Directory, .NET, Office 365 integration).
- **GCP (Google Cloud Platform)** - strong in data analytics/ML tooling (BigQuery,
  Vertex AI), grew out of Google's own internal infrastructure.

All three offer largely equivalent core services (compute, storage, networking,
databases) under different names - once you understand AWS's EC2/S3/RDS, the
equivalent Azure/GCP services are a quick mapping away.

Reference: https://www.freecodecamp.org/news/beginners-guide-to-cloud-computing-with-aws/
