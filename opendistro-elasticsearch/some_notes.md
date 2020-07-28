-- Ports: https://discuss.elastic.co/t/elasticsearch-port-9200-or-9300/72080/2
9200 for Representational state transfer ( Rest )
9300 for node communication
For discover other node or master require port 9300 open.
For 9200. It depends if you want to send REST requests to that node.

-- or easy explain:
```
9200 is the HTTP port. The Java transport client needs to use port 9300 to
connect to the other nodes.
```
