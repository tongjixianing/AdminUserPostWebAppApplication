# Project document

* IDE: Intellij
* Web Framework: Springboot 2.5.7
* JDK: 1.8.333

### Reference Documentation

* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#using.devtools)
* [Online tutorial](https://www.concretepage.com/spring-5/spring-resttemplate-getforobject)


# How to run

* Checkout the project from gitHub in Intellij: 
    - New -> project from version control 
    - Use the git repo url -> https://github.com/tongjixianing/AdminUserPostWebAppApplication.git
    - It will load all depedencies from maven pom.xml and build the project

* Locate the main class - AdminUserPostWebAppApplication and Right click Run 'AdminUserPostWebAppApplication'

* In the console, watch for the following output which indicate Web server starts:

   - Tomcat started on port(s): 8080 (http) with context path ''

* Go to browser, type http://localhost:8080/admin/ which calls the admin rest API to list all posts for each user. 
  - The output is in Json format
  - There are 10 users and each user has 10 posts. One thing to illustrate is that the output is with tailored user information of userID, name, username and email which is good enough to identify the user and its posts by UserId. I explictly do not include other user information such as address, phone, website, company because there is no need to merge everything together.
  - The [sample API output Json file](https://github.com/tongjixianing/AdminUserPostWebAppApplication/blob/master/alluserposts.json)

* Test case is under com/example/adminuserpostwebapp/AdminAPIControllerTest.java
  - Test cases conduct the verification of returned values for each method as well as simulating the API http service unavailibility for the app to handle such exceptions
