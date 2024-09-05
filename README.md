# Employee Management System

# HOW TO RUN THIS PROJECT?

Open the project in an IDE like Eclipse/IntelliJ.

* Create H2 database (
* Add following in application.properites file :-
spring.application.name=EmployeePortal
spring.h2.console.enabled=true
spring.datasource.url = jdbc:h2:mem:testdb
)

* Check your database connection in src/main/resources/application.properties file and change if needed.

* Go to com.project_name

* Right Click on class Application.

* Hit "Run As Java Application" in the IDE.

* Check if localhost server has started.

* Login - ADMIN (username : admin, password : 123) , USER (username : admin, password : 123)

* Open Postman/Any client service on your machine.

* Hit url : "http://localhost:8080/emp/get" and url : "http://localhost:8080/dept/get" 

* Accordingly select the request method and the url as follows (CREATE/DELETE/PATCH require ADMIN access ):
   - Department: GET - "http://localhost:8080/dept/get" - gets list of all departments GET - "http://localhost:8080/dept/{id}" - gets department with selected id POST - "http://localhost:8080/dept/create" - inserts into department 

    - Employee: GET - "http://localhost:8080/emp/get" - gets list of all employees GET - "http://localhost:8080/emp/{id}" - gets employees with selected id POST - "http://localhost:8080/emp/create" - inserts into employees   DELETE - "http://localhost:8080/emp/del/{id}" - deletes employees with selected id PATCH - "http://localhost:8080/emp/patch/{id}" - patches/updates employees with selected id

# ASSUMPTIONS

* DATABASE and TABLES are created in dB.
* DepartmentID is a foreign key in Employee table.
* Make sure department table is populated with the department you refer for in employee.

# TECHNOLOGY STACK

* Java Spring
* Spring Security
* H2 dB

# DESIGN

* The employee table has a department id foreign key.
* Department table needs to have a value existing to be referred by the employee table.
* Get mapping will fetch the results, Post mapping will insert results, Put mapping and Patch mapping will update results, Delete mapping will delete results.
* You will need to create database if not, change in the application.properties file.

# IMAGES
![Screenshot 2024-09-05 124201](https://github.com/user-attachments/assets/b9cc3287-fdec-49a1-be1d-46be26e181f7)
![Screenshot 2024-09-05 120929](https://github.com/user-attachments/assets/11cdd5ab-e58a-4d1a-9090-34600a422b2e)
![Screenshot 2024-09-05 121056](https://github.com/user-attachments/assets/243a8468-4c70-4856-a209-b620fcbd21fc)
![Screenshot 2024-09-05 121314](https://github.com/user-attachments/assets/c3cdb78b-41e1-456d-900b-2eef6487328a)
![Screenshot 2024-09-05 121353](https://github.com/user-attachments/assets/390599e8-6974-4621-a13f-33ae44fd4b55)
![Screenshot 2024-09-05 121505](https://github.com/user-attachments/assets/cd6e5e34-db19-40a9-b856-c7cb8b7889ea)
![Screenshot 2024-09-05 121543](https://github.com/user-attachments/assets/614168e0-be95-436b-90a0-d674295ef044)
![Screenshot 2024-09-05 121622](https://github.com/user-attachments/assets/72ba9f14-4c6a-4767-9558-d87ded03e8e6)
![Screenshot 2024-09-05 121644](https://github.com/user-attachments/assets/ca07f955-15ba-4392-8c82-f7ede99e7028)
![Screenshot 2024-09-05 121727](https://github.com/user-attachments/assets/91571adf-59f1-42b5-a730-8aa67c259b98)
![Screenshot 2024-09-05 121746](https://github.com/user-attachments/assets/ea76eef1-60c6-4288-b40b-195dd4aeb97f)
![Screenshot 2024-09-05 121958](https://github.com/user-attachments/assets/a84a11b1-d5f3-4f1d-9d8f-08df7e6fc733)
![Screenshot 2024-09-05 122021](https://github.com/user-attachments/assets/59cad23c-38f2-4c23-b4a1-9496938e55a2)
![Screenshot 2024-09-05 122326](https://github.com/user-attachments/assets/997b2b98-cf2b-48c0-892a-746c0004af0a)
![Screenshot 2024-09-05 122451](https://github.com/user-attachments/assets/a3e03b51-83a8-463f-8ae4-66d68b470ff2)
![Screenshot 2024-09-05 122504](https://github.com/user-attachments/assets/d279b3a6-d64f-402b-adef-46e26e62f4ab)
![Screenshot 2024-09-05 122523](https://github.com/user-attachments/assets/c9e3edf6-d282-4de0-adee-9fd82bab29ac)

