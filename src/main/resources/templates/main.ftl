<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
    <nav class="nav nav-tabs">
        <li role="presentation" style="padding-left: 10px;">
            <a href="/user">Список пользователей</a>
        </li>
        <li role="presentation">
            <a href="/profile/search">Поиск пользователей</a>
        </li>
        <li role="presentation">
            <a href="/me">Мой профиль</a>
        </li>
        <li role="presentation" style="float: right; margin-top: 5px; margin-right: 35px;">
            <@login.logout />
        </li>
        <li role="presentation" style="float: right;">
            <form method="get" action="/main" style="margin-top: 5px; margin-right: 35px;">
                <input type="text" name="filter" value="${filter?ifExists}">
                <button type="submit" class="btn btn-default" style="margin-bottom: 2px;">Найти</button>
            </form>
        </li>

    </nav>
    <div class="form-group col-xs-3" style="margin-top: 50px; margin-left: 30px;">
        <form method="post" style="padding: 5px; border: 1px solid lightgray">
            <input class="form-control" type="text" name="tag" placeholder="Хэштэг"; style="margin-top: 5px;">
            <textarea class="form-control" rows="3" name="text" placeholder="Введите текст поста"; style="margin-top: 5px;"></textarea>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-default" style="margin-top: 5px;">Добавить</button>
        </form>

        <div style="margin-top: 25px;">
            <h3>Новостная лента:</h3>

            <#list messages as message>
                <div style="border-bottom: 1px solid lightgray; padding-bottom: 5px">
                    <span><span style="color: dodgerblue">${message.tag} </span>${message.text}</span>
                    <br>
                    Автор: <strong>${message.authorName}</strong>
                </div>
            <#else>
                Нет постов
            </#list>
        </div>

    </div>

</@common.page>