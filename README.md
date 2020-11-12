# Project Heroes
Project for the SWOS-Module at BFH.

## Testing the API
```bash
# get all heroes
curl localhost:8080/heroes | jq

# get specific hero by id
curl localhost:8080/heroes/<id> | jq

# create hero
curl -X POST -H "Content-Type: application/json" -d '{"name":"Jack Norris","atk":999,"def":999,"hp":999}'  localhost:8080/heroes

# update hero
curl -X PUT -H "Content-Type: application/json" -d '{"id":"<id>","name":"Lame Duck","atk":1,"def":1,"hp":1}'  localhost:8080/heroes

# delete hero
curl -X DELETE localhost:8080/heroes/<id> | jq
```
The use of `jq` is optional but recommended.