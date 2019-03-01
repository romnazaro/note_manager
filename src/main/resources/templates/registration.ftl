<#import "parts/common.ftl" as cm>
<#import "parts/login.ftl" as log>
<@cm.page>

Create new User
${message?if_exists}
<@log.login "/registration" />
</@cm.page>