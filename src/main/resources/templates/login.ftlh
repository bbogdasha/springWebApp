<#import "macros/common.ftlh" as c>
<#import "macros/login.ftlh" as l>

<@c.page>
    <h3>Login page: </h3>
    <@l.login "/login" />
    <a href="/registration">Create new user</a></br>
    <a href="/recipes">Recipes list</a>
</@c.page>