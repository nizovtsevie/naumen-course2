<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
    <div class="col-md-3 col-md-offset-1 well" style="margin-top: 10vh;">
        <h3 class="text-center" style="padding-bottom: 10px">Авторизация</h3>
        <@login.login "/login" />
        <div class="col-xs-12" style="padding-top: 15px">Нет аккаунта? <a href="/registration">Зарегистрироваться</a></div>
    </div>
</@common.page>