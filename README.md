# hibernate-test-framework

This is simple test project which uses hibernate to interact with DB

## Start postgres DB and pgadmin
- start docker
- run: docker-compose up
- open browser: http://localhost:8888/
  * user: admin@admin.com
  * pass: admin
- Click 'Add New Server'
  * Set any name
  * In Connection tab
    * Host: postgres
    * Port: 5432
    * Maintenance db: hibernatedb
    * Username: admin
    * Password: admin
    * Click 'Save'
