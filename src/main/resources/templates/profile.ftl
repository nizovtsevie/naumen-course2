<#import "parts/common.ftl" as common>

<@common.page>
    <div style="margin-left: 50px">
        <div>
            <form action="/profile/" method="get">
                <h3>Данные пользователя <b>${user.username}</b>:</h3>

                <br>
                <h5>Посты пользователя:</h5>
                <#list messages as message>
                    <div style="border-bottom: 1px solid lightgray; width: 300px;">
                        <span><span style="color: dodgerblue">${message.tag} </span>${message.text}</span>
                    </div>
                </#list>
            </form>

            <br><br>
            <a href="/main">Вернуться на главную</a>
        </div>
    </div>
</@common.page>