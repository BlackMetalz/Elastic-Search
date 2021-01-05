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
