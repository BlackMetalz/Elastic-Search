- Index setting for reindex
```
PUT /wtf_index_name/_settings
{
  "index" : {
    "number_of_replicas" : 0,
    "refresh_interval" : "60s"
  },
  "translog": {
    "flush_threshold_size": "2gb"
  }
}
```
