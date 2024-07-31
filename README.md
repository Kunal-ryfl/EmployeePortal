#Employee Management System#

#HOW TO RUN THIS PROJECT?# ###FROM THE IDE:###

Open the project in an IDE like Eclipse/IntelliJ.

Create H2 database (
Add following in application.properites file :-
spring.application.name=EmployeePortal
spring.h2.console.enabled=true
spring.datasource.url = jdbc:h2:mem:testdb
)

Check your database connection in src/main/resources/application.properties file and change if needed.

Go to com.project_name

Right Click on class Application.

Hit "Run As Java Application" in the IDE.

Check if localhost server has started.

Open Postman client service on Google chrome.

Hit url : "http://localhost:8080/emp/get" and url : "http://localhost:8080/dept/get"

Accordingly select the request method and the url as follows: Department: GET - "http://localhost:8080/dept/get" - gets list of all departments GET - "http://localhost:8080/dept/{id}" - gets department with selected id POST - "http://localhost:8080/dept/create" - inserts into department 

Employee: GET - "http://localhost:8080/emp/get" - gets list of all employees GET - "http://localhost:8080/emp/{id}" - gets employees with selected id POST - "http://localhost:8080/emp/create" - inserts into employees   DELETE - "http://localhost:8080/emp/del/{id}" - deletes employees with selected id PATCH - "http://localhost:8080/emp/patch/{id}" - patches/updates employees with selected id

#ASSUMPTIONS

* DATABASE and TABLES are created in dB.
* DepartmentID is a foreign key in Employee table.
* Make sure department table is populated with the department you refer for in employee.

#TECHNOLOGY STACK#

* Java Spring
* H2 dB

#DESIGN#

* The employee table has a department id foreign key.
* Department table needs to have a value existing to be referred by the employee table.
* Get mapping will fetch the results, Post mapping will insert results, Put mapping and Patch mapping will update results, Delete mapping will delete results.
* You will need to create database if not, change in the application.properties file.
