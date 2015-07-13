# OpenHierarchy 

Read more about OpenHierarchy - http://openhierarchy.org/

OpenHierarchy Template project - Configured with Maven and the Spring JPA

* Java 1.8, some projects still use 1.6
* Tomcat 8

## Environment Configurations

To configure the environment, you may use the tools located in the example web project. WebContent -> WEB-INF -> environment. There you´ll find apache-tomcat and apache-maven. Use the Spring Tool Suite(STS)  which is a configured eclipse bundle including maven, git, Spring support and more.. Get the latest version here - https://spring.io/tools. You will also need the Java Runtime Environment 8, jre8.

### System variables

Add system variables, for example:
- JAVA_HOME : PATH_TO\jre8
- MAVEN_HOME : PATH_TO\apache-maven-3.3.1
- CATALINA_HOME : PATH_TO\apache-tomcat-8.0.21

Edit the system variable Path and add the following:
```
%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%CATALINA_HOME%\bin;
```

### Database

Install MySQL, you may get it from here (Choose the developer default installation and setup your MySQL server):
http://dev.mysql.com/downloads/windows/installer/

I recommend using HeidiSQL as the database environment:
http://www.heidisql.com/download.php

The mysql connector to be used is specified in the example web project´s pom.xml file.

## Get started

* In Eclipse, from the Git repositories view
* Clone a Git repository...
* Expand the repository after downloaded
* Right click Working Directory -> Import Maven Projects...

Project is configured using two db configs. One is for the OpenHierarchy system and the other is a project specific one.

### The OpenHierarchy Database
From the example web project -> WebContent -> WEB-INF -> openhierarchy-clean.sql.  Use that sql to create the openhierarchy database. Check the name of the database in this sql, default should be openhierarchy-system. You may use Heidi SQL to set up your db. After you have configured the dabase. Check the configuration file: WebContent -> WEB-INF -> config.xml to confirm that the connection is correct accordin g to your database setup.

### The Project Specific Database
Start by create a database with a name of your choice.
From the example web project -> src -> main.resources -> jpaContext.xml. Check out the bean-tag with id "dataSource". Change the properties to match your database.

### The server
There is a .zip-file in the example web project -> WebContent -> WEB-INF -> environment -> apache-tomcat.zip. Take the server folder you would like to use and place it somewhere local. From the Servers view in Eclipse -> New Server ->  Choose your apache version and click next. Point out the directory of your apache folder. After adding the server, add the example web project to the server by right click the server and then Add and remove..

Configure ports by double click on the server.

Start the server. Enter the following url in your browser (depending of your port choice): http://localhost:8080/example/
Default login is admin \ admin.

## FAQ

##### When I add the example-web project to the server I get the following error "Project facet Java Version 1.8 is not supported."
Right click the example web project and choose properties. Java Build Path -> Libraries. Click Add library.. and locate the jre8 if installed. Add this library and you´re good to go.

##### How do I resolve XSL-errors?
Window -> Preferences -> XML -> XSL -> Validation. Switch all to ignore and click apply

##### How to handle "The type javax.servlet.http.HttpServletRequest cannot be resolved."?
Make sure Tomcat is installed in your solution and configured for that project correctly. Have you added the Server Runtime to the example project? Right click example project -> Properties -> Java Build Path -> Libraries -> Add Library.. -> Server Runtime.

##### How can I get debug information about the .xml file for the current page?
For this demo project go to: PATH_TO_YOUR_PROJECT_DIRECTORY/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/demo.oeplatform.org/WEB-INF/module_xmldebug.xml

##### What about logging runtime errors?
Look in the same directory as above:
PATH_TO_YOUR_PROJECT_DIRECTORY\\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\demo.oeplatform.org\WEB-INF
