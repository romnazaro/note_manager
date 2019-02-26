<#import "parts/common.ftl" as cm>
<#import "parts/login.ftl" as log>
<@cm.page>

Авторизация
<@log.login "/login" />
<a href="/registration">Регистрация</a>

</@cm.page>
