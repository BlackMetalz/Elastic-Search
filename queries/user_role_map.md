# note: update roles and update role mapping equal to create. So you just need re-run create role/mapping query with new data. Run security will flush those users >.>
# Permissions: https://opendistro.github.io/for-elasticsearch-docs/docs/security/access-control/permissions/

# 1. Create user
```
PUT _opendistro/_security/api/internalusers/wtf_user
{
  "password": "wtfpassword",
  "backend_roles": ["wtf_user"]
}
```

# 2. Create Roles with permission
```
PUT _opendistro/_security/api/roles/wtf_user
{
  "cluster_permissions": [
    "cluster_composite_ops",
    "indices_monitor"
  ],
  "index_permissions": [{
    "index_patterns": [
      "wtf_index*"
    ],
    "dls": "",
    "fls": [],
    "masked_fields": [],
    "allowed_actions": [
      "indices:admin/get",
      "indices:data/read/search"
    ]
  }]
}
```

# 3. Map role to user
```
PUT _opendistro/_security/api/rolesmapping/wtf_user
{
  "backend_roles" : [ "wtf_user" ],
  "hosts" : [ "*" ],
  "users" : [ "wtf_user" ]
}
```
