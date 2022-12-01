# Note-server
## Stack
+ Java 11
+ Spring(boot,web,data-jpa,security,test)
+ hibernate(envers)
+ PostgreSQL
+ Maven
+ Flyway
+ Lombok
+ JUnit
+ Springfox

# Description
Authorization by roles (admin and user) using Spring Security. The user can CRUD notes. The admin can do it too, but besides that, he also removes, adds, changes users. The database migration is fixed using Flyway. The notes are versioned by Hibernate envers
