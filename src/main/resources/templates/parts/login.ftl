<#macro login path>
    <form action="${path}" method="post">
        <div>
            <label>Логин:
                <input class="form-control" type="text" name="username">
            </label>
        </div>
        <div>
            <label>Пароль:
                <input type="password" name="password">
            </label>
        </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="some@some.com" />
                </div>

            </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div>
            <input type="submit" value="Войти">
        </div>
    </form>

</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти">
    </form>
</#macro>