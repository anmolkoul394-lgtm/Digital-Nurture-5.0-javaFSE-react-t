# Amazon EBS - Block Storage for EC2

## What EBS is, and how it's different from S3

**EBS (Elastic Block Store)** provides block-level storage volumes that attach to a
single EC2 instance, behaving like a regular hard drive - you format it, mount it,
and the OS sees it as a disk. This is different from S3 (object storage, accessed
over HTTP, not "mounted" as a filesystem, shareable across many consumers at once).

| | EBS | S3 |
|---|---|---|
| Attaches to | One EC2 instance at a time (mostly) | Accessed over HTTP from anywhere |
| Looks like | A regular disk/filesystem | A key-value object store |
| Good for | OS boot volumes, databases, anything needing a real filesystem | Files, backups, static assets, large-scale unstructured data |

## Creating and attaching a volume

```bash
# Create a 20GB gp3 volume in the same Availability Zone as your instance
aws ec2 create-volume \
  --availability-zone us-east-1a \
  --size 20 \
  --volume-type gp3

# Attach it to a running instance
aws ec2 attach-volume \
  --volume-id vol-0123456789abcdef0 \
  --instance-id i-0123456789abcdef0 \
  --device /dev/xvdf
```

After attaching, you still need to format and mount the volume from inside the
instance itself (EBS gives you raw block storage, not a ready-made filesystem):

```bash
sudo mkfs -t ext4 /dev/xvdf
sudo mkdir /data
sudo mount /dev/xvdf /data
```

## EBS Volume Types

| Type | Best for | Notes |
|---|---|---|
| **gp3** | General purpose (most workloads) | Current-generation default, predictable baseline performance, cheaper than gp2 |
| **gp2** | General purpose (older generation) | Performance scales with volume size |
| **io1/io2** | High-performance databases | Provisioned IOPS - you pay for guaranteed performance, independent of volume size |

For most everyday workloads, gp3 is the sensible default - it's what AWS now
recommends over gp2 for new volumes.

## Snapshots and backup

A **snapshot** is a point-in-time backup of an EBS volume, stored in S3 behind the
scenes (though you don't manage it as an S3 object directly). Snapshots are
incremental - after the first full snapshot, later ones only store the blocks that
changed, keeping backup costs down.

```bash
# Create a snapshot of a volume
aws ec2 create-snapshot \
  --volume-id vol-0123456789abcdef0 \
  --description "Daily backup - $(date +%F)"

# Restore: create a NEW volume from an existing snapshot
aws ec2 create-volume \
  --availability-zone us-east-1a \
  --snapshot-id snap-0123456789abcdef0
```

## Files

- `ebs-commands-reference.sh` - all the commands above, collected in one runnable
  reference script, with comments explaining each step in order (create -> attach ->
  format/mount -> snapshot -> restore).

Reference: https://www.geeksforgeeks.org/devops/aws-tutorial/
