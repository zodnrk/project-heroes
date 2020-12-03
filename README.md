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

# create party
curl -H "Content-Type: application/json" -X POST -d '{"name":"The United Independants"}' localhost:8080/parties | jq

# let two parties battle
curl -H "Content-Type: application/json" -X POST -d '[{... list of two response objects of /parties ...}]' localhost:8083/parties | jq

# use the promoter to let two parties battle
curl localhost:8082/promoteFight
```
The use of `jq` is optional but recommended.
