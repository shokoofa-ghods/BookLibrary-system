Teamwork project with [v-nafise](https://github.com/v-nafiseh)

# BookLibrary-system 
This project has been designed to implement the back-end system of a book library application using technologies such as:
- Spring Boot java framework
- MVC architecture and modular-based applications
- RESTful API
- Spring Data JPA
- PostgreSQL
- JSP (java server pages)

### Details
Three modules is used in this app and the user roles are divided to Admins - Publishers - Ordinary users
## `Book` </br>
- Pulisher's permisions such as add/ delete/ edit books are defined in this module
- all User's actions like get a book information/ get all book information are defined here
- data information fetch is based on pagination 
- controller pass the request to service package and the information save to database in repository package
- the desinged model (valued parameters) for book is declared in model package
- configuration for database are in application.properties
- this module interact with auther module via RESTful API
## `Auther` 
- UI module interacting with user via JSP  
- main module which interacts with Book and Search module via RESTful API
- controller package is for monitoring user, publisher, admin tasks
- AdminController requests the User entity defined in this module for modifying users
- spring security is used for authentication manners
- Publisher/User Controller fetch their information from Search and Book
- Users can comment on each book post and their comments save in file system
## `Search`
- all User's actions like filtering by published-year or posted-date or book-name is declared in this module
- all User's actions like searching by tags is implemented here
- service module implements main function for searching and filtering
- this module interact with auther module via RESTful API
