<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
<span class="auth-title">Авторизация</span>
    ${message ?ifExists}
<@login.login "/login" />
<a href="/registration">Зарегистрироваться</a>
</@common.page>

