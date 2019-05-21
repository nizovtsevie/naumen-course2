<#import "parts/common.ftl" as common>

<@common.page>
    <div>Данные пользователя:</div>
    <div>
        <form action="/profile/" method="get">
            <td>${user.username}</td>
            <div>Посты пользователя:</div>
            <#list messages as message>
                <div>
                    <b>${message.id}</b>
                    <span>${message.text}</span>
                    <i>${message.tag}</i>
                    <strong>${message.authorName}</strong>
                </div>
            </#list>
        </form>
    </div>
</@common.page>