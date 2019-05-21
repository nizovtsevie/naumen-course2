<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
    ${message?ifExists}
    <div class="col-md-3 col-md-offset-1 well" style="margin-top: 10vh;">
        <h3 class="text-center" style="padding-bottom: 10px">Регистрация</h3>
        <@login.login "/registration" />
        <div class="col-xs-12" style="padding-top: 15px">Уже зарегистрированы? <a href="/login">Войти</a></div>
    </div>
</@common.page>