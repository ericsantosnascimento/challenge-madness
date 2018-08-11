# challenge-madness

Once you are done, send us a link to the git repository.

Get hero information into the database from the unofficial Overwatch API:
https://overwatch-api.net/api/v1/hero/
https://overwatch-api.net/api/v1/hero/{hero_id}

Fields required: id, name, real_name, health, armour, shield

Also get information about the Heroes abilities and provide them using a relation:
https://overwatch-api.net/api/v1/ability/
https://overwatch-api.net/api/v1/ability/{ability_id}

Fields required: id, name, description, is_ultimate

Create an API that provides information about Overwatch heroes and their abilities
Your API should have the following endpoints:

/api/heros - hero list
/api/heros/{hero_id} - hero data
/api/heros/{hero_id}/abilities - hero ability list
/api/abilities/ - ability list
/api/abilities/{ability_id} - ability data

Hints:
A user-agent might be required to use the API programmatically
Bonus points:
API documentation, e.g. Swagger
Data persistence, e.g. file system, H2 or other database
Tests