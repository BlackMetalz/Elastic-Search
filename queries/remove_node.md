-- Remove a data node from cluster:
```
PUT _cluster/settings
{
  "transient": {
    "cluster.routing.allocation.exclude._ip": "node_ip_here"
  }
}
```

Then check for health status


-- Set it to null if u want that node have data ( curl version ):
```
curl -XPUT “http://@host:9200/_cluster/settings” -d 
'{
  "transient" :{
      "cluster.routing.allocation.exclude._ip" : ""
   }
}'
```
