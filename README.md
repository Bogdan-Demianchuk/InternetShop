# Internet Shop 
[Project purpose](#purpose)<br>
[Project structure](#structure)<br>
[Available functions](#avaiable_functions)<br>
[The technology used in this project](#technology)<br>
[For developer](#developer-start)<br>
[Authors](#authors)

# <a name="purpose"></a>Project purpose
This is an implementation of a website template with the basic functions of an online store

# <a name="structure"></a>Project Structure
   The project has a structure of two layers and five entities. There are layers of service and DAO. The service layer is responsible for the business logic of the application, the DAO layer responsible for CRUD operations with entities in the database. Also, the project has controllers for managing requests from clients.

# <a name="avvailable_functions"></a>Available Functions
For **all** users
* View the main page 
* View menu of the store
* View items of the store
* Inject data

For **unregistered** users<br>
For all users plus
* Registration
* Log in

For users with a **USER role only**<br>
For all users plus
* View shopping cards
* Adding and removing products from shopping cards
* Make an order
* View orders
* Log out

For users with a **ADMIN role only**<br>
For all users plus

* View shopping cards
* Adding and removing products from shop
* View all registered users
* View orders of all users
* Log out

# <a name="technology"></a>Technology
* Java 11
* Maven 4.0.0
* maven-checkstyle-plugin 3.1.1
* JSTL 1.2
* Servlets 3.1.0
* Log4j 1.2.17
* mysql-connector-java 8.0.20
* Tomcat 9.0.34
* Bootstrap 4.4.1

# <a name="developer-start"></a>For developer
To test this project you need to have installed:

* Java 11+
* Tomcat
* MySQL (Optional)

To start
* Open the project in your IDE.
* Add it as maven project.
* Configure Tomcat
    * add an artifact
    * add Java SDK (prefer version 11 or higher)
* Change a path in **src/main/resources/log4j2.xml** on line 12. It has to reach your logFile.
* Run the project.
7. If you launch this project for the first time: 
    * Run InjectDefaultUsersController by URL = .../inject-data to create default users. By default, there are one user with the USER role (login = "user", password = "user") 
and one with an ADMIN role (login = "admin", password = "admin")*.

To work with MySQL you need to*:

1. At src/main/java/bogdan/internetshop/util/ConnectionUtil class on line 19-21 use username, password and URL for your DB to create a Connection.
2. Use file src/main/resources/init_db.sql to create a schema and all the tables required by this app in MySQL database.

# <a name="authors"></a>Authors
[Bogdan Demianchuk](https://github.com/Bogdan-Demianchuk)