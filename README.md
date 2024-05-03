# hibernate-test-framework

This is simple test project which uses hibernate to interact with DB

## Start postgres DB and pgadmin
- start docker
- start postgres db and pgadmin: docker-compose up
- open pgadmin via browser: http://localhost:8888/
  * user: admin@admin.com
  * pass: admin
- Setup connection to postgres DB in pgadmin
  * Click 'Add New Server'
  * Set any name
  * In 'Connection' tab
    * Host: postgres
    * Port: 5432
    * Maintenance db: hibernatedb
    * Username: admin
    * Password: admin
    * Click 'Save'
