<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.page>
Страница авторизации
<@login.login "/login" />
<a href="/registration">Зарегистрироваться</a>
</@common.page>