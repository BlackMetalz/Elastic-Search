1. Add path.repo to elasearch.yml
```
path.repo: ["/mnt/snapshots"]
```
After that have to restart cluster. I'm using lizardfs in for shared file system in this case.

2. Register repo
```
PUT _snapshot/my-fs-repository
{
  "type": "fs",
  "settings": {
    "location": "/mnt/snapshots"
  }
}
```

3. Check register
```
GET /_snapshot/_all
```

4. Create snapshot:

```
PUT _snapshot/backup/snapshot_20201006?wait_for_completion=true&pretty
```
Advance: Remove some index and include some index when create snapshot
```
PUT _snapshot/backup/notify-cmt_snapshot_4?wait_for_completion=true&pretty
{
  "indices": "-security-auditlog*,-.opendistro*,-.kibana*,lala*,fafa*,live*",
  "ignore_unavailable": true,
  "include_global_state": false
}
```

- Check status: 
```
GET _snapshot/_status
```

5. Restore step:
- See all snapshot available:
```
GET _snapshot/backup/*
```
- Delete index for testing purpose: 
```
DELETE index_name
```

- Then restore: Have to exclude opendistro_security and kibana. You can create snapshot for specific indices.
```
POST _snapshot/backup/snapshot_20201006/_restore 
{
  "indices": "-.opendistro_security,-.kibana",
  "include_global_state": false
}
```
