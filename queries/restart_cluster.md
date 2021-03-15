## Rolling Restart

# Step 1: Disable Shard Allocation:
```
PUT _cluster/settings
{
  "persistent": {
    "cluster.routing.allocation.enable": "primaries"
  }
}
```

# Step 2: Stop indexing and perform a synced flush
```
POST _flush/synced
```

# Step 3: Restart single node
```
service elasticsearch restart
```

# Step 4: Check if node joined
```
GET _cat/nodes
```

# Step 5: Reenable shard allocation
```
PUT _cluster/settings
{
  "persistent": {
    "cluster.routing.allocation.enable": null
  }
}
```

# Step 6: Wait till cluster green
```
GET _cluster/health
```

# Step 7: Repeat from step 1
