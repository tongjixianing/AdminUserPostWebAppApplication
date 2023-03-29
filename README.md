# Project document

* IDE: Itellij
* Web Framework: Springboot 2.5.7
* JDK: 1.8.233

### Reference Documentation

* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#using.devtools)
* [Online tutorial](https://www.concretepage.com/spring-5/spring-resttemplate-getforobject)


# How to run

* Checkout the project from gitHub in Intellij

* Locate the main class - AdminUserPostWebAppApplication and Right click Run 'AdminUserPostWebAppApplication'

* In the console , watch for the following output to indicate Web server starts:

   - Tomcat started on port(s): 8080 (http) with context path ''

* Go to browser, type http://localhost:8080/admin/ which calls the admin API to list all posts for each user. 
  - The output is in Json format
  - There are 10 users and each user has 10 posts
  - The sample output Json file

* Test case is under com/example/adminuserpostwebapp/AdminAPIControllerTest.java