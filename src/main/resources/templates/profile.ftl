<#import "parts/common.ftl" as common>

<@common.page>
    <div style="margin-left: 50px">
        <div>
            <form action="/profile/" method="get">
                <h3>Данные пользователя <b>${user.username}</b>:</h3>

                <br>
                <h5>Посты пользователя:</h5>
                <#list messages as message>
                    <div style="border-bottom: 1px solid lightgray; width: 300px; margin-bottom: 40px">
                        <span><span style="color: dodgerblue">${message.tag} </span>${message.text}</span>
                    </div>
                </#list>
            </form>

            <!---
            ${message?ifExists}
            <form method="form">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Password:</label>
                    <div class="col-sm-6">
                        <input type="password" name="password" class="form-control" placeholder="Password" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email:</label>
                    <div class="col-sm-6">
                        <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}" />
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button class="btn btn-primary" type="submit">Save</button>
            </form>
    -->

            <br><br>
            <a href="/main">Вернуться на главную</a>
        </div>
    </div>
</@common.page>