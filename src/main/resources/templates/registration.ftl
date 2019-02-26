<#import "parts/common.ftl" as cm>
<#import "parts/login.ftl" as log>
<@cm.page>

Create new User
${message}
<@log.login "/registration" />
</@cm.page>