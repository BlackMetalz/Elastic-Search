-- Get cluster stats. This can see total shard, mem, heap size
```
GET /_cluster/stats
```

-- Get clused indices:
```
GET _cluster/state/blocks?pretty
```

-- Update cluster setting ( some setting doesn't need to restart service for set )
Source: https://www.elastic.co/guide/en/elasticsearch/reference/current/cluster-update-settings.html
Sadly update remote white list aren't updateable dynamically https://github.com/elastic/elasticsearch/issues/29153
```
PUT /_cluster/settings
{
  "persistent" : {
    "indices.recovery.max_bytes_per_sec" : "50mb"
  }
}

```
