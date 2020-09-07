<#import "macros/login.ftlh" as l>

<!DOCTYPE HTML>
<html>
<head>
    <title>Recipes list</title>
    <link rel="stylesheet" href="/static/styles/recipes.css">
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="/static/js/script.js"></script>
</head>
<body>
    <div class="header-account">
        <div class="header-account-content content">
            <div class="hidden-logo">
                <a href="/recipes"><img src="/static/img/logo.png" alt="Logo"></a>
            </div>
            <div class="header-account-content-log" id="myHeader">
                <a href="/login">Sign in</a><span>/</span> <a href="/registration">Register</a>
            </div>
        </div>
    </div>
    <div class="header-logo">
        <div class="header-logo-content content">
            <div class="header-logo-content-img">
                <a href="/recipes"><img src="/static/img/logo.png" alt="Logo"></a>
            </div>
        </div>
    </div>
    <div class="header-menu">
        <div class="header-menu-content content">
            <ul>
                <li><a href="/greeting">Home</a></li>
                <li><a href="/recipes">Recipes</a></li>
                <li><a href="/createRecipe">Create new recipe</a></li>
                <li><a href="/user">User list</a></li>
            </ul>
        </div>
    </div>


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
    <@l.logout />
</body>
</html>