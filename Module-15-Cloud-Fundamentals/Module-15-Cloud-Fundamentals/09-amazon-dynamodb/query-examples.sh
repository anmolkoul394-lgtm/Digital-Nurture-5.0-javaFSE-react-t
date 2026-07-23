#!/bin/bash
# query-examples.sh
# Shows the difference between an efficient Query (uses the partition key directly)
# and an inefficient Scan (reads every item in the table) against the same Orders table.

# EFFICIENT - Query: "give me all orders for customer 101"
# Uses the partition key directly - fast, and cost scales with the RESULT size, not table size.
aws dynamodb query \
  --table-name Orders \
  --key-condition-expression "customerId = :cid" \
  --expression-attribute-values '{":cid": {"S": "101"}}'

# INEFFICIENT - Scan: "find all orders with status SHIPPED"
# Reads every single item in the ENTIRE table, then filters - cost scales with
# TABLE size, not result size. Fine for a tiny table, a real problem at scale.
aws dynamodb scan \
  --table-name Orders \
  --filter-expression "#s = :status" \
  --expression-attribute-names '{"#s": "status"}' \
  --expression-attribute-values '{":status": {"S": "SHIPPED"}}'
