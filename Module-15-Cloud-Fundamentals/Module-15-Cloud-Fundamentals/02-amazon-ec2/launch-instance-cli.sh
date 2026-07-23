#!/bin/bash
# launch-instance-cli.sh
# The AWS CLI equivalent of the EC2 console "Launch Instance" walkthrough.
# Requires the AWS CLI installed and configured (aws configure) with valid credentials.

# 1) Create a key pair and save the private key locally
aws ec2 create-key-pair \
  --key-name my-demo-key \
  --query 'KeyMaterial' \
  --output text > my-demo-key.pem

chmod 400 my-demo-key.pem

# 2) Create a security group (using the rules described in sample-security-group.json)
aws ec2 create-security-group \
  --group-name web-server-sg \
  --description "Allows SSH from admin IP, and public HTTP/HTTPS traffic"

# 3) Launch a t2.micro instance using Amazon Linux 2023, with the key pair and security group above
aws ec2 run-instances \
  --image-id ami-0abcdef1234567890 \
  --instance-type t2.micro \
  --key-name my-demo-key \
  --security-groups web-server-sg \
  --count 1

# 4) Once running, find its public DNS name to SSH into it
aws ec2 describe-instances \
  --query 'Reservations[*].Instances[*].PublicDnsName' \
  --output text

# 5) Connect (replace <public-dns> with the value from the command above)
# ssh -i my-demo-key.pem ec2-user@<public-dns>
