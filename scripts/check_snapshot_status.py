#!/usr/bin/python3
# Author: Kienlt


import argparse
import sys

import requests
from requests.auth import HTTPBasicAuth

_user = "_user"
_passwd = "_passwd"

def Check_Snapshot_Status(_host, _repo):
    _res = requests.get('http://%s:9200/_snapshot/%s/*' % (_host, _repo), auth=HTTPBasicAuth(_user, _passwd))
    data = _res.json()
    #print(data['snapshots'])
    #return
    
    all_data = list()
    for _data in data['snapshots']:
        for _k, _v in _data.items():
            if (_k == 'snapshot'):
                print("%s and %s" % (_k, _v))
                return
                all_data.append("Snapshot: %s || State: %s" % (_k, _v ))
                #if (_k == 'duration_in_millis' and _v > 0 ):
                #all_data.append("Snapshot: %s || State: %s || Duration in Second: %s" % (_k, _v ))
        #_data.append("Snapshot: %s || State: %s" % ( v['snapshot'], v['state']))

    print(all_data)



Check_Snapshot_Status("_host_ipname", "_repo_name")
