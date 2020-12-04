# Spring Web

This site is a collection of culinary recipes, with the ability to view recipes, create, delete and administer, register and login. The site has access restrictions for a 
visitor, for an authorized user and full administrator rights. A database is connected to the site, which stores information about the user (usr), recipes (recipes) and 
roles of each user (user_role).

### Tech

* Spring Boot;
* Spring MVC;
* Spring Security;
* Postgresql;
* Hibernate;
* Html/Css/Js;
* Thymeleaf.

### Functions 

1. Registration, authorization and logout.
2. Validity of the entered data (during registration, authorization, recipe creation).
3. Checking for an existing user.
4. Visitor rights: 
   - access to a few pages 
   - view recipes.
5. User rights: 
   - access to many pages 
   - view recipes 
   - view your recipes 
   - create recipes 
   - delete **your** recipes.
6. Admin rights: 
   - full rights
   - additional buttons
   - removing any users
   - removing any recipes
   - granting admin rights to other users.
7. Implemented information pages reporting various errors (404, 403, 400, 500).
8. Implemented web interface.

### Result

**1.** 
The video shows the functions and capabilities of the visitor: viewing the main page, a list of recipes and a recipe page; authorization is required to create your own recipe.

Video result:
[![Video](https://github.com/bbogdasha/springWebApp/blob/master/screenshots/YouTube.jpg)](https://youtu.be/3gAx6448cB0)
