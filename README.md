## Description
This is an API for mocking up the upload multipartFile receiving from the client and storing it either locally or at database which is particularly PostgreSQL.

## Swagger Documentation
Please go through this link [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

## Docker Container Setup Sample
```
sudo docker run -d \
--name docker-postgres \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_USER=hooman \
-e POSTGRES_DB=postgres \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v /custom/mount:/var/lib/postgresql/data \
-p 5432:5432 \
postgres
```

## Misc
#### Port `8081`
#### Database Name `postgres`
#### Max file Size `300MB`


