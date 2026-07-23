# Amazon EC2 - Instances, AMIs, Security Groups & Key Pairs

## What EC2 is

**EC2 (Elastic Compute Cloud)** is AWS's core "rent a virtual server" service - this
is the IaaS building block from the previous topic, made concrete. You choose a
size/type, a starting image, click launch, and a few seconds later you have a
running virtual machine you can SSH into.

## Amazon Machine Images (AMIs)

An **AMI** is a template used to launch an instance - it bundles an OS, any
pre-installed software, and configuration. AWS provides a set of ready-made AMIs
(Amazon Linux, Ubuntu, Windows Server), or you can create your own from a
configured instance (useful for launching many identical instances quickly, without
re-running setup scripts every time).

## Instance types

Instance types describe the hardware profile (CPU, memory, network performance)
behind the VM. Named like `t2.micro`, `t3.medium`, `m5.large` - the letter is the
family (t = burstable general purpose, m = balanced general purpose, c = compute
optimized, r = memory optimized), the number is the generation, and the size
(micro/small/medium/large...) scales resources up.

`t2.micro` specifically is what's covered under the AWS Free Tier - 750 hours/month
free for the first 12 months, which is why it's the standard "let's try this out"
instance type.

## Launching an instance (Console walkthrough, summarized)

1. EC2 Dashboard → "Launch Instance"
2. Choose an AMI (e.g. "Amazon Linux 2023")
3. Choose an instance type (e.g. `t2.micro`)
4. Create or select a key pair (see below)
5. Configure a security group (see below)
6. Launch - the instance boots in under a minute

## Security Groups - the virtual firewall

A **security group** controls what traffic is allowed in/out of an instance, at
the instance level (as opposed to a VPC's network ACLs, which apply at the subnet
level - covered in the VPC topic). Rules are defined as:

| Type | Protocol | Port Range | Source | Purpose |
|---|---|---|---|---|
| SSH | TCP | 22 | Your IP only | Remote administration |
| HTTP | TCP | 80 | 0.0.0.0/0 (anywhere) | Public web traffic |
| HTTPS | TCP | 443 | 0.0.0.0/0 (anywhere) | Public secure web traffic |

Security groups are **stateful** - if you allow inbound traffic on a port, the
matching outbound response is automatically allowed too, without a separate rule.

## Key Pairs - how you actually log in

AWS uses public-key cryptography instead of passwords for SSH access. When you
create a key pair, AWS gives you the **private key** (a `.pem` file) once - it's
never stored by AWS after that download, so losing it means losing access to that
instance (unless you have another way in).

```bash
# Restrict permissions - SSH refuses to use a key file that's too open
chmod 400 my-key.pem

# Connect to your instance (replace with your instance's public IP/DNS)
ssh -i my-key.pem ec2-user@ec2-3-91-45-100.compute-1.amazonaws.com
```

## Files

- `sample-security-group.json` - an example security group definition, the kind of
  JSON you'd see if you exported one via the AWS CLI, annotated with comments
  explaining each field.
- `launch-instance-cli.sh` - the AWS CLI equivalent of the console walkthrough above,
  so you can see exactly what the console is doing under the hood.

Reference: https://www.geeksforgeeks.org/devops/amazon-ec2-creating-an-elastic-cloud-compute-instance/
