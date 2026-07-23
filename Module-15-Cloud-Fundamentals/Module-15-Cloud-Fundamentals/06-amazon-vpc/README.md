# Amazon VPC - Subnets, Route Tables, Security Groups & VPC Peering

## What a VPC is

A **VPC (Virtual Private Cloud)** is an isolated virtual network within AWS - your
own private slice of the AWS network, where you control IP ranges, subnets, routing,
and who can talk to what. Every EC2 instance, RDS database, etc. launches inside a
VPC (AWS gives every account a "default VPC" so you can get started without
configuring one yourself, but real projects usually build a custom one).

```
VPC (e.g. 10.0.0.0/16)
├── Public Subnet  (10.0.1.0/24)  - has a route to the internet
└── Private Subnet (10.0.2.0/24)  - no direct route to the internet
```

## Public Subnet vs Private Subnet

A subnet is "public" or "private" purely based on its **route table** - specifically,
whether it has a route to an Internet Gateway.

- **Public subnet** - route table includes a route to an Internet Gateway. Typically
  holds things that need to be reachable from the internet: load balancers, bastion hosts.
- **Private subnet** - no direct route to the internet. Typically holds things that
  should NEVER be reachable directly: application servers, databases (an RDS
  instance almost always lives in a private subnet).

## Route Tables

A route table is just a set of rules saying "traffic to this IP range goes out
through this gateway/device". Every subnet is associated with exactly one route table.

```
Destination        Target
10.0.0.0/16         local              <- traffic within the VPC stays within the VPC
0.0.0.0/0           igw-0123456789     <- everything else goes out through the Internet Gateway
```

## Internet Gateway (IGW) vs NAT Gateway

- **Internet Gateway** - attached to the VPC itself, lets resources in a PUBLIC
  subnet send/receive traffic directly to/from the internet.
- **NAT Gateway** - sits in a public subnet, lets resources in a PRIVATE subnet
  reach OUT to the internet (e.g. to download an update) WITHOUT being reachable
  FROM the internet - one-way access, which is exactly what a private app server
  usually needs (outbound only).

## Security Groups (recap from EC2, at the VPC level)

Security groups were introduced in the EC2 topic - worth repeating here because they're
fundamentally a VPC/networking concept, just applied at the instance level. There's
also **Network ACLs**, which apply at the subnet level and are stateless (unlike
security groups, which are stateful) - less commonly configured day-to-day, but worth
knowing they exist as a second layer of network control.

## VPC Peering

Connects two VPCs so resources in each can talk to each other privately, as if they
were on the same network - useful when, say, a company has separate VPCs for
different teams/environments but needs a shared database. Peering connections are
NOT transitive - if VPC A peers with B, and B peers with C, A cannot automatically
reach C through B.

## Files

- `vpc-architecture.txt` - a text diagram of a typical 2-tier VPC layout (public
  subnet with a load balancer, private subnet with app servers and a database),
  the standard shape most real applications end up using.
- `create-vpc-cli.sh` - CLI commands walking through creating this exact layout.

Reference: https://www.geeksforgeeks.org/devops/amazon-vpc-introduction-to-amazon-virtual-cloud/
