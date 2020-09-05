<#import "macros/common.ftlh" as c>

<@c.page>
    <h3>List of users:</h3>
    <table>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
    </table></br>
    <a href="/recipes">Recipes list</a>
</@c.page>