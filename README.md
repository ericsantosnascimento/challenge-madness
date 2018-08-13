# challenge-madness

Challenge madness is just a challenge :P

Its a spring boot based service, besides running with Spring 2 i'm not using anything from Spring 5 yet.

the database is an in memo database, feign is the client for communication with external apis.

integration tests were build with RestAssured.

available endpoint are:

/api/v1/heroes
/api/v1/heroes/{hero_id}
/api/v1/heroes/{hero_id}/abilities
/api/v1/heroes/sync
/api/v1/abilities
/api/v1/abilities/{id}
/api/v1/abilities/sync