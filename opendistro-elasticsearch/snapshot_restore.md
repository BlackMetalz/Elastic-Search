1. Add path.repo to elasearch.yml
```
path.repo: ["/mnt/snapshots"]
```
After that have to restart cluster. I'm using lizardfs in for shared file system in this case.

2. Register repo
```
PUT _snapshot/my-fs-repository
{
  "type": "fs",
  "settings": {
    "location": "/mnt/snapshots"
  }
}
```

3. Check register
```
GET /_snapshot/_all
```

4. Create snapshot:

