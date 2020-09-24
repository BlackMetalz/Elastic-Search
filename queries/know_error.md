1. throttled
```
"allocate_explanation" : "allocation temporarily throttled"
"explanation" : "reached the limit of incoming shard recoveries [2], cluster setting [cluster.routing.allocation.node_concurrent_incoming_recoveries=2] (can also be set via [cluster.routing.allocation.node_concurrent_recoveries])"
```

Solution: change index.allocation.max_retries to higher value than [2] 
```
PUT /index-name-with-wildcard*/_settings 
{
  "index.allocation.max_retries": 3
}
```
