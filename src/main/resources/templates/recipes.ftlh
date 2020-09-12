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


    <div class="body-part content">
        <div class="body-part-title"><p>Recipes list:</p></div>
        <div class="body-part-container">
            <#list recipes as recipe>
                <div class="box">
                    <div class="box-picture">
                        <a href="/user">
                            <#if recipe.filename??>
                                <img src="/img/${recipe.filename}">
                            </#if>
                        </a>
                    </div>
                    <div class="box-info">
                        <p class="box-info-name">${recipe.name}</p>
                        <div class="box-info-time">
                            <img src="/static/img/time.png"><p>:&nbsp;${recipe.time}</p>
                        </div>
                        <div class="box-info-author">
                            <img src="/static/img/author.png"><p>:&nbsp;${recipe.authorName}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    <@l.logout />


    <footer class="footer">
        <div class="footer-logo">
            <div class="footer-logo-content content">
                <div class="footer-logo-content-img">
                    <a href="/recipes"><img src="/static/img/logo.png" alt="Logo"></a>
                </div>
                <div class="footer-logo-content-icons">
                    <ul>
                        <li><a href="#"><img src="/static/img/instagram.png" /></a></li>
                        <li><a href="#"><img src="/static/img/twitter.png" /></a></li>
                        <li><a href="#"><img src="/static/img/telegram.png" /></a></li>
                        <li><a href="#"><img src="/static/img/google.png" /></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-menu">
            <div class="footer-menu-content content">
                <ul>
                    <li><a href="/greeting">Home</a></li>
                    <li><a href="/recipes">Recipes</a></li>
                    <li><a href="/createRecipe">Create new recipe</a></li>
                    <li><a href="/user">User list</a></li>
                </ul>
                <div class="footer-menu-author content">
                    <p>Site created by <a href="https://github.com/bbogdasha">Bogdan</a> for educational purposes in 2020 year</p>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>