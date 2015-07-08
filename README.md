# openhierarchy
OpenHierarchy Template project - Configured with Maven and the Spring JPA

* Java 1.8, some projects still use 1.6
* Tomcat 8
* 

## Get started
* In Eclipse, from the Git repository view
* Clone a Git repository
* Right click Working Directory -> Import Maven Projects...

## Configurations
Project is configured using two db configs. One is for the OpenHierarchy system and the other is a project specific one.

### OpenHierarchy
From the example web project -> WebContent -> WEB-INF -> openhierarchy-clean.sql.  Use that sql to create the openhierarchy database. Check the name of the database in this sql, default should be openhierarchy-system. Use Heidi SQL för example to set up your db. After you have configured the dabase. Check the configuration file: WebContent -> WEB-INF -> config.xml to confirm that the connection is correct accordin g to your database setup.

### The project specific Database
Start by create a database with a name of your choice.
From the example web project -> src -> main.resources -> jpaContext.xml. Check out the bean-tag with id "dataSource". Change the properties to match your database.

### The server
There is a .zip-file in the example web project -> WebContent -> WEB-INF -> apache-tomcat.zip. Take the server folder you would like to use and place it somewhere local. From the Servers view in Eclipse -> New Server ->  Choose your apache version and click next. Point out the directory of your apache folder. After adding the server, add the example web project to the server by right click the server and choose Add and remove..

Configure ports by double click on the server.

Start the server. Enter the following url in your browser (depending of your port choice): http://localhost:8080/example/


