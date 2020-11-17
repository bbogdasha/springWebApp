<#import "macros/headerFooter.ftlh" as h>

<@h.menu>
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
                            <img src="/static/img/time.png"><p>-&nbsp;${recipe.time}</p>
                        </div>
                        <div class="box-info-author">
                            <img src="/static/img/author.png"><p>-&nbsp;${recipe.authorName}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@h.menu>