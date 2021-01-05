-- Create new template basic:

```
UT _index_template/k8s_logs
{
  "index_patterns": ["k8s_logs_*"],
  "template": {
    "settings": {
      "number_of_shards": 5,
      "number_of_replicas": 1
    }
  }
}
```

-- Hmmm
```
PUT _template/k9s_logs_test
{
    "order" : 0,
    "index_patterns" : [
      "k9s_logs_test*"
    ],
    "settings" : {
      "index" : {
        "number_of_shards" : "5",
        "number_of_replicas" : "1"
      }
    },
    "mappings" : {
      "_source" : {
        "enabled" : false
      },
      "properties" : {
        "created_at" : {
          "format" : "EEE MMM dd HH:mm:ss Z yyyy",
          "type" : "date"
        },
        "host_name" : {
          "type" : "keyword"
        }
      }
    },
    "aliases" : { }
}
```
