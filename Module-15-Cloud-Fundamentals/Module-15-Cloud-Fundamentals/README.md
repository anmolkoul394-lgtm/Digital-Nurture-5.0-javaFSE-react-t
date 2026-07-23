# Module 15 - Cloud Fundamentals

This one's different from the earlier modules - there's no application to build here,
it's about understanding cloud infrastructure concepts and the core AWS services you'd
actually reach for when deploying a real application. Where it makes sense, folders
include CLI commands, config file examples (JSON policies, CloudFormation-style
templates, Dockerfiles), and a couple of small runnable snippets (a Lambda function),
but a lot of this is genuinely "read, understand, and try it in the AWS Console"
material - AWS itself has a free tier that covers everything here.

## Topics

| # | Topic | Folder |
|---|---|---|
| 1 | Introduction to Cloud Computing, Service & Deployment Models | `01-intro-cloud-computing` |
| 2 | Amazon EC2 - Instances, AMIs, Security Groups, Key Pairs | `02-amazon-ec2` |
| 3 | Amazon ECS - Container basics | `03-amazon-ecs` |
| 4 | Amazon S3 - Buckets, Objects, Storage Classes | `04-amazon-s3` |
| 5 | Amazon EBS - Block storage for EC2 | `05-amazon-ebs` |
| 6 | Amazon VPC - Subnets, Route Tables, Peering | `06-amazon-vpc` |
| 7 | Elastic Load Balancer - ALB & NLB | `07-elastic-load-balancer` |
| 8 | Amazon RDS - Managed relational databases, Multi-AZ | `08-amazon-rds` |
| 9 | Amazon DynamoDB - NoSQL basics | `09-amazon-dynamodb` |
| 10 | AWS Lambda - Serverless functions | `10-aws-lambda` |
| 11 | AWS API Gateway - Managing REST APIs | `11-aws-api-gateway` |

## Suggested order

Read 1 → 2 → 4 → 5 first (compute + storage basics), then 6 → 7 (networking), then
8 → 9 (databases), then 10 → 11 (serverless) - each builds a bit of vocabulary the
next one assumes you already have. Topic 3 (ECS) fits naturally right after EC2, since
it's really just "containers instead of full VMs".

## A note on hands-on practice

Everything here can be tried for free using an AWS Free Tier account (t2.micro EC2
instances, 5GB of S3, a small RDS instance, and generous Lambda/API Gateway limits are
all covered). None of this needs real money to actually go click through - just don't
forget to stop/terminate anything you spin up once you're done, since forgetting a
running EC2 instance is the classic way people get an unexpected bill.
