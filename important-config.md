- Change virtual memory
```
sysctl -w vm.max_map_count=262144
```

Remember to change in /etc/sysctl.conf for permanent
```
echo 'vm.max_map_count = 262144' >> /etc/sysctl.conf
```
