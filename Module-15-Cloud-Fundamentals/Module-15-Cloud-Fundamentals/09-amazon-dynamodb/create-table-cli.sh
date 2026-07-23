#!/bin/bash
# create-table-cli.sh
# Creates the Orders table used in the README's examples -
# customerId as partition key, orderDate as sort key.

aws dynamodb create-table \
  --table-name Orders \
  --attribute-definitions \
      AttributeName=customerId,AttributeType=S \
      AttributeName=orderDate,AttributeType=S \
  --key-schema \
      AttributeName=customerId,KeyType=HASH \
      AttributeName=orderDate,KeyType=RANGE \
  --billing-mode PAY_PER_REQUEST

# Insert a sample item
aws dynamodb put-item \
  --table-name Orders \
  --item '{
      "customerId": {"S": "101"},
      "orderDate": {"S": "2026-01-15"},
      "totalAmount": {"N": "1499.00"},
      "status": {"S": "SHIPPED"}
  }'
