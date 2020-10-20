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
