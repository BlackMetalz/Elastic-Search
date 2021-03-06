# Ref: https://opendistro.github.io/for-elasticsearch-docs/docs/troubleshoot/security-admin/

-- Some how your cluster is fucked by you and become in red status:
```
cd /usr/share/elasticsearch/plugins/opendistro_security/tools/ && bash securityadmin.sh -cd ../securityconfig -nhnv -cacert /etc/elasticsearch/root-ca.pem -cert /etc/elasticsearch/kirk.pem -key /etc/elasticsearch/kirk-key.pem -icl --accept-red-cluster
```

# Source: https://discuss.opendistrocommunity.dev/t/users-gone-after-using-securityadmin-sh/1781/4

```
Question: So i will lose configuration from kibana when i use securityadmin.sh?

Answer: No, if you only load the config.yml instead of the entire /securityconfig/ dir you will retain your configured Kibana roles
```

``` 
Question: Can i export the settings i did to the .yml files?

Answer: 
https://opendistro.github.io/for-elasticsearch-docs/docs/security/configuration/security-admin/#backup-restore-and-migrate
```

- Here is the script I use when I reboot my cluster that does not erase any of the users and roles
```
./securityadmin.sh -h YOUR-HOST -cn YOUR-CLUSTER-NAME -f ../securityconfig/config.yml -nhnv -cacert ../../../config/root-ca.pem -cert ../../../config/admin.pem -key ../../../config/admin-key.pem
```


## What i learned
- Change admin password by run only internal_users.yml file ( ofc, have to change hash pass in there xD )
```
./securityadmin.sh -h HOST_IP -cn CLUSTER_NAME -f ../securityconfig/internal_users.yml -nhnv -cacert /etc/elasticsearch/root-ca.pem -cert /etc/elasticsearch/kirk.pem -key /etc/elasticsearch/kirk-key.pem
```

- Export setting in cluster:
```
./securityadmin.sh -backup /root/odfe/ -h HOST_IP -icl -nhnv -cacert /etc/elasticsearch/root-ca.pem -cert /etc/elasticsearch/kirk.pem -key /etc/elasticsearch/kirk-key.pem
```

