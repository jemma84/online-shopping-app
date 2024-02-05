# Getting Started
### Additional Links
Run postgres
```bash
  docker run -d --name demo-postgres 
  -e POSTGRES_PASSWORD=password 
  -e POSTGRES_USER=developer 
  -e POSTGRES_DB=shopping_app 
  -p 5432:5432 postgres:13
```
