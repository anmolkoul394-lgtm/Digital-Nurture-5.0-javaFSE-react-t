# Amazon DynamoDB - NoSQL Basics & Creating Tables

## What DynamoDB is

**DynamoDB** is AWS's fully managed NoSQL database - a key-value and document store,
built for extremely low, predictable latency at any scale (single-digit
milliseconds, whether your table has a hundred rows or a hundred billion). Unlike
RDS, there's no database engine to choose or patch - DynamoDB IS the engine.

## RDS (relational/SQL) vs DynamoDB (NoSQL)

| | RDS (SQL) | DynamoDB (NoSQL) |
|---|---|---|
| Schema | Fixed - every row has the same columns | Flexible - items in the same table can have different attributes |
| Relationships | Joins across tables | No joins - data is usually denormalized (duplicated) instead |
| Scaling | Vertical (bigger instance) or read replicas | Scales horizontally, near-limitless, near-automatic |
| Query language | SQL | API calls (GetItem, Query, Scan) - no SQL |
| Best for | Complex relationships, transactions, reporting | High-scale, simple access patterns, unpredictable/huge traffic |

The rule of thumb: if your data has complex relationships and you need to ask
varied, ad-hoc questions of it (reporting, analytics) - relational (RDS). If you
have a small number of well-known access patterns and need to scale to huge volume
with predictable low latency (e.g. a shopping cart, a session store, an IoT sensor
feed) - DynamoDB.

## Creating a table (Console walkthrough, summarized)

1. DynamoDB Console → "Create table"
2. Name the table, define the primary key (partition key, optionally + sort key)
3. Leave capacity mode as "On-demand" for unpredictable traffic (or "Provisioned"
   if you know your throughput needs and want to control cost more tightly)
4. Create - tables are ready in seconds

## Primary Keys - Partition Key and Sort Key

- **Partition key** (required) - determines which physical partition an item is
  stored on; DynamoDB hashes this value to spread data (and traffic) evenly.
- **Sort key** (optional) - lets you have multiple items with the SAME partition
  key, sorted by this second value. Together they form a **composite key**.

```
Table: Orders
Partition Key: customerId      Sort Key: orderDate
---------------------------------------------------
customerId=101   orderDate=2026-01-15   -> Order A
customerId=101   orderDate=2026-03-02   -> Order B
customerId=202   orderDate=2026-02-10   -> Order C
```

This layout lets you efficiently ask "give me all of customer 101's orders,
sorted by date" - a single, fast query, without scanning the whole table.

## Basic querying and scanning

- **Query** - efficient; looks up items by partition key (and optionally a sort key
  range) - this is what you should be using for almost everything.
- **Scan** - reads every item in the table, then filters - works, but slow and
  expensive at scale; generally a sign the table's key design doesn't match the
  access pattern you actually need.

## DynamoDB for high-scale, low-latency use cases

Common real-world uses: shopping carts, user session storage, real-time
leaderboards, IoT device data - anywhere you have massive, unpredictable read/write
volume but relatively simple, well-known lookup patterns.

## Files

- `create-table-cli.sh` - creates the `Orders` table shown above via the AWS CLI.
- `query-examples.sh` - a Query (efficient) vs a Scan (inefficient) against the same table, for comparison.

Reference: https://www.geeksforgeeks.org/devops/aws-tutorial/
