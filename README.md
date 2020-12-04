# Spring Web

This site is a collection of culinary recipes, with the ability to view recipes, create, delete and administer, register and login. The site has access restrictions for a 
visitor, for an authorized user and full administrator rights. A database is connected to the site, which stores information about the user (usr), recipes (recipes) and 
roles of each user (user_role). For convenience, the result of the work is demonstrated in three videos on YouTube.

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
4. Filter by recipe name and username.
5. Visitor rights: 
   - access to a few pages 
   - view recipes.
6. User rights: 
   - access to many pages 
   - view recipes 
   - view your recipes 
   - create recipes 
   - delete **your** recipes.
7. Admin rights: 
   - full rights
   - additional buttons
   - removing any users
   - removing any recipes
   - granting admin rights to other users.
8. Implemented information pages reporting various errors (404, 403, 400, 500).
9. Implemented web interface.
10. Passwords are encrypted.

### Result

**1. Visitor** 
The video shows the functions and capabilities of the visitor: viewing the main page, a list of recipes and a recipe page; filter by recipe name (Burger) or username (Bob); the visitor, when clicking on the recipe creation, redirects to the authorization page.

**Video result №1 (click on the picture to see the result on YouTube or copy link: https://youtu.be/3gAx6448cB0):**

👇

[![Video](https://github.com/bbogdasha/springWebApp/blob/master/screenshots/YouTube.jpg)](https://youtu.be/3gAx6448cB0)

---

**2. User** 
The visitor can create an account on the site. The registration process checks the correctness of the entered data:
- [x] Must start with a capital letter followed by one or more lowercase letters.
- [x] Must be minimum 8 characters, at least one letter and one number.

After registration, the user must log in and after that it becomes possible to create new recipes. When creating a new recipe, the user did not select a photo for the recipe - the default picture was set.

The user has his own page, where all his recipes are displayed, where the user can delete them.

**Video result №2 (click on the picture to see the result on YouTube or copy link: https://youtu.be/oG2SRbM1oMs):**

  👇
  
[![Video](https://github.com/bbogdasha/springWebApp/blob/master/screenshots/YouTube.jpg)](https://youtu.be/oG2SRbM1oMs)

---

**3. Admin**
Before logging into the admin, the user tries to enter the list of all users, and receives a page with an error 403 - no access, with a small description.

After logging in as an administrator, new opportunities appear: 
- [x] a list of users 
- [x] editing user roles 
- [x] deleting any recipes from the list.

**Video result №3 (click on the picture to see the result on YouTube or copy link: https://youtu.be/xGURxnNdMzU):**

  👇
  
[![Video](https://github.com/bbogdasha/springWebApp/blob/master/screenshots/YouTube.jpg)](https://youtu.be/xGURxnNdMzU)

---

**4. Password**
Passwords are stored encrypted in the database:

![screenshot](https://github.com/bbogdasha/springWebApp/blob/master/screenshots/screen1.jpg)

---
