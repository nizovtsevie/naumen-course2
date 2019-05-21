<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
    <div>
        <@login.logout />
        <span><a href="/user">Список пользователей</a></span>
        <span><a href="/profile/search">Искать пользователей</a></span>
        <span><a href="/me">Моя страница</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Введите текст поста">
            <input type="text" name="tag" placeholder="Хэштэг">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список постов</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter?ifExists}">
        <button type="submit">Найти</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        Нет постов
    </#list>
</@common.page>