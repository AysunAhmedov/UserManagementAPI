Application Startup Instructions 

  

Introduction 

## Introduction

This is a web REST API application utilizing standard HTTP methods – GET, POST, PUT, DELETE. It is built with Spring Boot and Maven, uses a MySQL database, and incorporates Swagger for API documentation. Additionally, Flyway is used to manage database migrations and generate random data for easier testing.
 

  

Prerequisites 

Make sure you have the following installed: 

  

 1. Java Development Kit (JDK) 17 or higher 

 	- Download Oracle from - https://www.oracle.com/bg/java/technologies/downloads/

- Apache Maven 3.6.0 or higher 

- Download  Maven from - https://maven.apache.org/download.cgi

2. MySQL 8.0 or higher 

 - Download from - https://dev.mysql.com/downloads/mysql/

  

 Installation 

1. Clone the Repository: 

- Open git bash and type :	 

 		 git clone https://github.com/AysunAhmedov/UserManagementAPI

     

2. Build the Project: 

- Open terminal in /UserManagementAPI folder and type:  

 		mvn clean package 

    

  

    This will create an executable JAR file in the `target` directory. 

  

Database Setup 

1. Ensure the MySQL server is running. 

 

 2. Create the Database 

         

3. Configure Database Connection: 

     - Edit the `src/main/resources/application.properties` file. 

     spring.datasource.url=jdbc:mysql://localhost:3306/(your database name) 

     spring.datasource.username=(your username) 

     spring.datasource.password= (your password) 

     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver 

     spring.jpa.hibernate.ddl-auto=none

     spring.flyway.url=jdbc:mysql://localhost:3306/(your database name)
   
     spring.flyway.user=(your username) 
   
     spring.flyway.password=(your password) 



  

Running the Application 

1. Run the JAR File: 

- Double click on the jar file or open terminal and write:  

Java -jar target/UsersCrud-0.0.1-SNAPSHOT.jar 

 

 2. Access the Application: 

   	- Open your web browser and navigate to `http://localhost:8080/swagger-ui.html` 	to access the Swagger UI for API documentation and testing.
      
 3.Additional Notes

- Ensure that the database credentials in the `application.properties` file are correct.
- Flyway will automatically run the migration scripts in the `db/migration` directory and will create a "users" table and populate the database with random users data for easier testing.

  

         
