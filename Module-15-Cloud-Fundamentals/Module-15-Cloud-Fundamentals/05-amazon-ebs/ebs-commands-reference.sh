#!/bin/bash
# ebs-commands-reference.sh
# Full lifecycle of an EBS volume: create -> attach -> format/mount -> snapshot -> restore.
# Replace the placeholder IDs (vol-..., i-..., snap-...) with real values from your account.

# 1) CREATE a new gp3 volume in a specific Availability Zone
aws ec2 create-volume \
  --availability-zone us-east-1a \
  --size 20 \
  --volume-type gp3

# 2) ATTACH it to a running EC2 instance as a new device
aws ec2 attach-volume \
  --volume-id vol-0123456789abcdef0 \
  --instance-id i-0123456789abcdef0 \
  --device /dev/xvdf

# 3) From INSIDE the instance (via SSH), format and mount the new volume:
#    sudo mkfs -t ext4 /dev/xvdf
#    sudo mkdir /data
#    sudo mount /dev/xvdf /data

# 4) SNAPSHOT the volume for backup - incremental after the first one
aws ec2 create-snapshot \
  --volume-id vol-0123456789abcdef0 \
  --description "Daily backup"

# 5) RESTORE - create a brand new volume from a snapshot, e.g. to recover from failure
aws ec2 create-volume \
  --availability-zone us-east-1a \
  --snapshot-id snap-0123456789abcdef0

# 6) LIST all volumes and their attachment status
aws ec2 describe-volumes --query 'Volumes[*].{ID:VolumeId,State:State,Size:Size}'
