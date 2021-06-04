-- Remove a data node from cluster:
```
PUT _cluster/settings
{
  "transient": {
    "cluster.routing.allocation.exclude._ip": "node_ip_here"
  }
}
```

Then check for health status
