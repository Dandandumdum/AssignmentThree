# AssignmentThree
AssignmentThree for Noroff and Experis Academy

AssignmentThree for Noroff and Experis academy

This project follows the outline of the specification provided by Noroff, as outlined below.

Use Hibernate to create a database with the following minimum requirements: 

a) Create models and Repositories for Character, Movie and Franchise entities and to cater for these specifications:

    -Business rules
      Characters and Movies: One movie may contain many characters, and a character can play in many movies.
      Movies and Franchises: One movie belongs to one franchise, but a franchise can contain many movies.
    -Data requirements
      The Character entity must contain:
        - An autoincrmented id
        - Full name
        - Alias (if apllicable)
        - Gender
        - Picture (URL)
      The Movie entity must contain:
        - Autoincremented id
        - Movie Title
        - Genre
        - Release year
        - Director
        - Picture (URL)
        - Trailer (URL)
      The Franchise entity must contain:
        -Autoincremented id
        -Name
        -Description
    
 b) Create a Web API in Spring Web with these requirements:
 
      - Create controllers according to these specifications:
          - CRUD operations to: - Get all Movies in a Franchise
                                - Get all Characters in a Movie
                                - Get all Characcters in a Franchise
                                - Update Characters in a Movie
                                - Update Characters in a Franchise      
                                
          - Swagger/Open API documentation

This assignment was done using Java in IntelliJ and the Heroku link is as follows:
Swagger can be acessed via this link when the program is running through port8080:
http://localhost:8080/swagger-ui.html


Postman was also used to for endpoint testing and the Json file is included within this repository.

Authors Daniel Dumville and Sebastian Almqvist
      
