<#import "macros/login.ftlh" as l>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<title>Registration</title>
		<link rel="stylesheet" href="/static/styles/registration.css">
	</head>
	<body>
        <div class="container">
            <div class="window">
                <div class="overlay"></div>
                <div class="content">
                    <div class="logo"><img src="/static/img/logo.png" alt="Logo"></div>
                    <div class="title">Registration</div>
                    <div class="text">If you want to create and upload your recipes to the site, you need to create an account:</div>
                    <div class="form"><@l.login "/registration" /></div>
                    <div><button class="button-back"><a href="/recipes">Back</a></button></div>
                </div>
            </div>
        </div>
    </body>
</html>