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

-- Create basic template with setting. Remember the index pattern: I don't know why k9s_log_test* doesn't work but k9s_logs_test_* work
```
PUT _template/k9s_logs_test
{
    "order" : 0,
    "index_patterns" : [
      "k9s_logs_test_*"
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

-- Delete Template:
```
DELETE _template/template_name
```
