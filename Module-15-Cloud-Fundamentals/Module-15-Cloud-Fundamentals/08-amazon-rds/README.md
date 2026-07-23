# Amazon RDS - Managed Relational Databases & Multi-AZ

## Managed vs self-managed databases

Running your own database on an EC2 instance means YOU handle patching, backups,
replication, and failover. **RDS (Relational Database Service)** takes that
operational burden away - AWS handles the underlying OS, database engine patching,
automated backups, and (if you enable it) failover, while you just connect to it
like any other database.

This is essentially the same "how much do you manage vs how much does AWS manage"
spectrum from the intro topic's IaaS/PaaS discussion - RDS sits closer to PaaS for
databases specifically, compared to running your own database engine on a raw EC2
instance (which would be closer to IaaS).

## Supported DB engines

RDS supports several engines behind one consistent management interface:
- **MySQL**
- **PostgreSQL**
- **SQL Server**
- **Aurora** - AWS's own MySQL/PostgreSQL-compatible engine, built for higher
  performance and scalability than stock MySQL/PostgreSQL, at a higher cost

If your Spring Boot app already uses `spring-boot-starter-data-jpa` (Week 2, Module
6) with a MySQL or PostgreSQL driver, pointing it at an RDS instance instead of a
local database is just a connection string change - the JPA/Hibernate code itself
doesn't need to know or care that the database is now managed by AWS.

## Creating an RDS instance (Console walkthrough, summarized)

1. RDS Console → "Create database"
2. Choose an engine (e.g. PostgreSQL)
3. Choose a template (Free tier / Dev-Test / Production)
4. Set instance size, storage, master username/password
5. Choose the VPC/subnet - almost always a PRIVATE subnet (see the VPC topic - a
   database should never be directly internet-reachable)
6. Create - takes a few minutes to provision

## Multi-AZ deployments for high availability

A **Multi-AZ** deployment keeps a synchronized standby replica of your database in
a DIFFERENT Availability Zone (a physically separate data center within the same
region). If the primary fails, RDS automatically fails over to the standby - usually
within a minute or two, with no manual intervention needed.

```
Availability Zone A          Availability Zone B
   Primary DB  <---sync--->   Standby DB
   (active)                   (passive, ready to take over)
```

This is purely for availability, not read scaling - queries always go to the
primary. (For read scaling, RDS separately offers **Read Replicas**, which DO serve
read queries, but aren't automatically promoted on failure the way a Multi-AZ
standby is.)

## Automated backups and snapshots

RDS takes automated daily backups (retained for a configurable period, e.g. 7 days)
plus continuous transaction logs, enabling **point-in-time recovery** - restoring
the database to any specific moment within the retention window, not just to the
time of the last daily backup.

## Files

- `rds-create-instance-cli.sh` - creates a Multi-AZ PostgreSQL instance via the AWS CLI.
- `spring-boot-rds-connection.properties` - shows exactly how little changes in a
  Spring Boot app's `application.properties` to point at RDS instead of a local database
  (compare against the `application.properties` files from Week 2/3 of this course).

Reference: https://www.geeksforgeeks.org/devops/configuring-rds-instances-in-a-private-subnet/
