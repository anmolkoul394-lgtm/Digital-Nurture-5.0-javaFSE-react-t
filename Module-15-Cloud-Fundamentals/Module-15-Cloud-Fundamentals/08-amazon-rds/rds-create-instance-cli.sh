#!/bin/bash
# rds-create-instance-cli.sh
# Creates a Multi-AZ PostgreSQL RDS instance, placed in a private subnet group
# (see the VPC topic - databases should never be directly internet-reachable).

aws rds create-db-instance \
  --db-instance-identifier task-api-db \
  --db-instance-class db.t3.micro \
  --engine postgres \
  --engine-version 16.3 \
  --master-username taskapi_admin \
  --master-user-password "ChangeMeBeforeRealUse123!" \
  --allocated-storage 20 \
  --multi-az \
  --no-publicly-accessible \
  --db-subnet-group-name private-subnet-group \
  --vpc-security-group-ids sg-0123456789abcdef0

# Once available, get its connection endpoint:
aws rds describe-db-instances \
  --db-instance-identifier task-api-db \
  --query 'DBInstances[0].Endpoint.Address'
