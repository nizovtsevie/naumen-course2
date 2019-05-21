<#macro login path>
    <form class="form" action="${path}" method="post">
        <div class="col-xs-12">
            <div class="form-group">
                <input class="form-control" type="text" name="username" placeholder="Введите имя пользователя">
            </div>
        </div>
        <div class="col-xs-12">
            <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Введите пароль">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="text-center col-xs-12">
            <input type="submit" class="btn btn-default" value="Войти">
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти">
    </form>
</#macro>