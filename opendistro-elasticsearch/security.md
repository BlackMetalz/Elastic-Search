## Source: https://discuss.opendistrocommunity.dev/t/users-gone-after-using-securityadmin-sh/1781/4

```
Question: So i will lose configuration from kibana when i use securityadmin.sh?

Answer: No, if you only load the config.yml instead of the entire /securityconfig/ dir you will retain your configured Kibana roles
```

``` 
Question: Can i export the settings i did to the .yml files?

Answer: 

```

- Here is the script I use when I reboot my cluster that does not erase any of the users and roles
```
./securityadmin.sh -h YOUR-HOST -cn YOUR-CLUSTER-NAME -f ../securityconfig/config.yml -nhnv -cacert ../../../config/root-ca.pem -cert ../../../config/admin.pem -key ../../../config/admin-key.pem
```


