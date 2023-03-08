# Service Manual Backend with Spring Boot  

Java's Spring Boot based backend for making records for factory device maintenance tasks. This project is part of Etteplan's job recruitment process.  

## Installation  

1. Download the repository with git clone.  
2. Install dependencies from [pom.xml](./pom.xml) file with Maven.  
3. Compile and run the source files.  

The API can be tested with Postman. There is ready made Postman-queries in the [Postman](./Postman) folder.  

The application has also JUnit tests in [./src/test/java/*](./src/test/java/).  

Service Manual uses H2 database. Database can be accessed with browser from [localhost:8080/h2-ui](http://localhost:8080/h2-ui) (if the settings in [application.properties](./src/main/resources/application.properties) are not modified). In browser log in form, remember to change `JDBC URL` to `jdbc:h2:mem:servicemanual`.  