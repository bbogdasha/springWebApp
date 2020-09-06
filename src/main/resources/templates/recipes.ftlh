<#import "macros/login.ftlh" as l>

<!DOCTYPE HTML>
<html>
<head>
    <title>Recipes list</title>
    <link rel="stylesheet" href="/static/styles/recipes.css">
</head>
<body>
    <header class="main-header">
        <div class="account-header">
            <a href="/login">Sign in</a> / <a href="/registration">Register</a>
        </div>
        <div class="logo-header">
            LOGO
        </div>
        <div class="menu-header">
            <ul>
                <li><a href="/greeting">Home</a></li>
                <li><a href="/recipes">Recipes</a></li>
                <li><a href="/createRecipe">Create new recipe</a></li>
            </ul>
        </div>
    </header>
    <@l.logout /></br>
    <a href="/user">User list</a>
    <div class="content">
        <h3>Recipes list:</h3>
        <div class="container">
            <#list recipes as recipe>
                <div class="box">
                    <div class="box_picture">
                        <#if recipe.filename??>
                            <img src="/img/${recipe.filename}">
                        </#if>
                    </div>
                    <div class="box_name">
                        <span>Recipe name: ${recipe.name}</span>
                        <span>Cooking time: ${recipe.time}</span>
                        <span>Author: ${recipe.authorName}</span>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</body>
</html>