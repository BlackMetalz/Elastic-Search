- Register new repo
```
curl -X PUT http://10.3.48.54:9200/_snapshot/backup-es -u admin:wtf -k -H 'Content-Type: application/json' \
-d '{
  "type": "fs",
  "settings": {
    "location": "/data/backup-es"
  }
}'
```

#Credit: https://opendistro.github.io/for-elasticsearch-docs/docs/elasticsearch/snapshot-restore/
