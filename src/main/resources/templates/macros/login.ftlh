<#macro login path>
	<form action="${path}" method="post">
	    <div class="input-field">
	        <label><input class="input-line" placeholder="Username" type="text" name="username"/> </label>
	        <label><input class="input-line" placeholder="Password" type="password" name="password"/> </label>
	        <input type="hidden" name="_csrf" value="${_csrf.token}" />
	        <div class="error">${message?ifExists}</div>
            <div><input class="button-reg" type="submit" value="Log In"/></div>
	    </div>
	</form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Log Out"/>
    </form>
</#macro>