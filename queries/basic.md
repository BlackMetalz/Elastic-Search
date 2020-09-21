-- Unassigned Shard check:
```
GET /_cluster/allocation/explain?pretty
```

Fix Solution:
```
POST /_cluster/reroute?retry_failed
```
