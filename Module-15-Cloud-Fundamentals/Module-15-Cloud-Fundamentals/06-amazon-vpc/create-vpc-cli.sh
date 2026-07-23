#!/bin/bash
# create-vpc-cli.sh
# Builds the 2-tier layout described in vpc-architecture.txt, step by step.

# 1) Create the VPC itself
aws ec2 create-vpc --cidr-block 10.0.0.0/16

# 2) Create a public subnet (for the load balancer / NAT gateway)
aws ec2 create-subnet \
  --vpc-id vpc-0123456789abcdef0 \
  --cidr-block 10.0.1.0/24 \
  --availability-zone us-east-1a

# 3) Create a private subnet (for app servers / database)
aws ec2 create-subnet \
  --vpc-id vpc-0123456789abcdef0 \
  --cidr-block 10.0.2.0/24 \
  --availability-zone us-east-1a

# 4) Create and attach an Internet Gateway to the VPC
aws ec2 create-internet-gateway
aws ec2 attach-internet-gateway \
  --vpc-id vpc-0123456789abcdef0 \
  --internet-gateway-id igw-0123456789abcdef0

# 5) Create a route table for the public subnet, with a route to the internet
aws ec2 create-route-table --vpc-id vpc-0123456789abcdef0
aws ec2 create-route \
  --route-table-id rtb-0123456789abcdef0 \
  --destination-cidr-block 0.0.0.0/0 \
  --gateway-id igw-0123456789abcdef0

# 6) Associate that route table with the public subnet
aws ec2 associate-route-table \
  --subnet-id subnet-0123456789abcdef0 \
  --route-table-id rtb-0123456789abcdef0

# The private subnet keeps the VPC's default (local-only) route table -
# it gets no route to the Internet Gateway, which is exactly what makes it "private".
