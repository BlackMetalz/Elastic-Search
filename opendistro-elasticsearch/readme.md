# Some notes
Change password default: https://aws.amazon.com/blogs/opensource/change-passwords-open-distro-for-elasticsearch/

- Gen hashed pass: 
```
sh /usr/share/elasticsearch/plugins/opendistro_security/tools/hash.sh -p 8qhlASrXHsR4bk73dzjH
```

- Active Security for first time, in 1 master node
```
cd /usr/share/elasticsearch/plugins/opendistro_security/tools/ && bash securityadmin.sh -cd ../securityconfig -icl -nhnv -cacert /etc/elasticsearch/root-ca.pem -cert /etc/elasticsearch/kirk.pem -key /etc/elasticsearch/kirk-key.pem 
```
