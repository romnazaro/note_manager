<#import "parts/common.ftl" as cm>
<#import "parts/login.ftl" as log>



<@cm.page>
Create new User
${message?ifExists}
<@log.login "/registration" true />
</@cm.page>