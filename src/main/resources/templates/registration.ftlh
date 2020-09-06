<#import "macros/common.ftlh" as c>
<#import "macros/login.ftlh" as l>

<@c.page>
    <h3>Registration new user:</h3>
    <@l.login "/registration" />
    ${message?ifExists}
    <a href="/recipes">Recipes list</a>
</@c.page>