<#import "parts/common.ftl" as common>

<@common.page>
    <a href="/main">Вернуться на главную</a>
    <form method="get" action="/profile/search">
        <input type="text" name="username" value="${username?ifExists}">
        <button type="submit">Найти</button>
    </form>
    <#list users as user>
        <td>${user.id}</td>
        <td><a href="/profile/${user.id}">${user.username}</a></td>
    </#list>
</@common.page>