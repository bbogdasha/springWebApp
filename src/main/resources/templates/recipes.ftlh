<#import "macros/login.ftlh" as l>

<!DOCTYPE HTML>
<html>
<head>
    <title>Recipes list</title>
    <style type="text/css">
        .main {
            max-width: 1140px;
            margin-right: auto;
            margin-left: auto;

        }
        .container {
            background: #bbb;
	        display: flex;
	        flex-wrap: wrap;
	        justify-content: space-between;
        }
        .box {
            width: 32%;
            height: 400px;
            margin: 1% 0 1% 0;
        }
        .box_picture {
            width: 100%;
            height: 300px;
            background: blue;
        }
        .box_name {
            width: 100%;
            height: 100px;
            background: red;
        }
    </style>
</head>
<body>
    <@l.logout /></br>
    <a href="/user">User list</a>
    <div class="main">
        <a href="/createRecipe">Create new recipe</a><br>

        <h3>Recipes list:</h3>
        <div class="container">
            <#list recipes as recipe>
                <div class="box">
                    <div class="box_picture">
                        Picture
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