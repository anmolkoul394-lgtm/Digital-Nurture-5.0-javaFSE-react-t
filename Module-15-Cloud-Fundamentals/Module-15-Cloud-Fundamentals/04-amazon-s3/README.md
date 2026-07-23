# Amazon S3 - Buckets, Objects & Storage Classes

## What S3 is

**S3 (Simple Storage Service)** is object storage - you store files ("objects") in
containers called **buckets**, addressed by a key (essentially a path/filename).
Unlike EBS (block storage, attached to one instance - next topic) or a filesystem,
S3 is accessed over HTTP(S), scales to essentially unlimited size, and is designed
for 99.999999999% ("11 nines") durability.

## Buckets and Objects

- A **bucket** is a top-level container - bucket names must be globally unique
  across ALL of AWS, not just your account.
- An **object** is the actual file, plus metadata, stored at a key inside a bucket
  (e.g. `images/profile-pic.jpg`).

```
s3://my-app-uploads-bucket/images/profile-pic.jpg
        ^bucket                ^key
```

## Creating a bucket (Console walkthrough, summarized)

1. S3 Console → "Create bucket"
2. Choose a globally-unique name, and a region
3. Choose public/private access settings (default: block all public access - a
   sensible default you should only change deliberately)
4. Create

## Uploading and downloading objects (CLI)

```bash
# Upload a file
aws s3 cp report.pdf s3://my-app-uploads-bucket/reports/report.pdf

# Download a file
aws s3 cp s3://my-app-uploads-bucket/reports/report.pdf ./report.pdf

# List everything in a bucket
aws s3 ls s3://my-app-uploads-bucket --recursive
```

## Bucket access permissions - public vs private

By default, every bucket and object is **private** - only the bucket owner's
account can access it. Public access requires an explicit bucket policy (see
`sample-bucket-policy.json`) - accidentally making a bucket public is one of the
most common real-world cloud security mistakes, so AWS makes you go out of your way
to do it.

## S3 Storage Classes

Same durability everywhere, different cost/retrieval speed trade-offs based on
how often you actually need the data:

| Storage Class | Use case | Retrieval time |
|---|---|---|
| **Standard** | Frequently accessed data | Milliseconds |
| **Intelligent-Tiering** | Access pattern unknown/changing - AWS moves it automatically | Milliseconds |
| **Standard-IA** (Infrequent Access) | Accessed rarely, but needed fast when it is | Milliseconds |
| **Glacier** | Long-term archival, rarely ever accessed | Minutes to hours |

## Lifecycle policies and Versioning

- **Lifecycle policies** automatically transition objects between storage classes
  (or delete them) based on age - e.g. "move to Glacier after 90 days, delete after
  2 years" - without you writing a script to do it manually.
- **Versioning** keeps every version of an object instead of overwriting it on
  update - protects against accidental deletes/overwrites, at the cost of storing
  every historical version (which also costs money, so it's usually paired with a
  lifecycle policy to clean up old versions eventually).

## Files

- `sample-bucket-policy.json` - a policy making one specific folder in a bucket
  publicly readable (commonly used for serving static website assets), with
  everything else staying private.
- `lifecycle-policy.json` - transitions objects to Standard-IA after 30 days, then Glacier after 90 days.

Reference: https://www.geeksforgeeks.org/cloud-computing/amazon-s3-creating-a-s3-bucket/
