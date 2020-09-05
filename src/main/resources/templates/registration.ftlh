<#import "macros/common.ftlh" as c>
<#import "macros/login.ftlh" as l>

<@c.page>
    <h3>Registration new user:</h3>
    ${#message}
    <@l.login "/registration" />
</@c.page>