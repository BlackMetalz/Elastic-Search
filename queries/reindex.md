-- Source: https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-reindex.html

-- Reindex: Copies documents from a source to a destination.
index: wtf_1 have 20k documents
index: test_data have 100k documents
```
POST _reindex 
{
  "source": {
    "index": "wtf_1"
  },
  "dest": {
    "index": "test_data"
  }
}
```

after reindex
```
GET _refresh
GET _cat/count/test_data?
```

output:
```
epoch      timestamp count
1603168599 04:36:39  120000
```

So 120000 documents in total.


-- Reindex from remote cluster:
```
https://www.elastic.co/guide/en/elasticsearch/reference/current/reindex-upgrade-remote.html
```


-- Reindex from remote cluster
```
POST _reindex
{
  "source": {
    "remote": {
      "host": "http://oldhost:9200",
      "username": "user",
      "password": "pass"
    },
    "index": "index_name"
  },
  "dest": {
    "index": "index_name"
  }
}
```
Don't forget to add: 
```
reindex.remote.whitelist : oldhost:9200
```

into elasticsearch.yml ( master node only and restart )
