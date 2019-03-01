<#import "parts/common.ftl" as cm>
<#import "parts/login.ftl" as l>
<@cm.page>
    <div>
        <@l.logout />
        <span><a href="/user">User List</a></span>
    </div>

    <div>
        <form method="POST" enctype="multipart/form-data">
            <input type="text" name="text" placeholder="Введите задачу">
            <input type="number" name="Priority" placeholder="Приоритет">
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список дел</div>
   <#list notes as note>
    <div>
        <b>${note.id}</b>
        <span>${note.text}</span>
        <b>${note.priority}</b>
        <strong>${note.authorName}</strong>
        <div>
            <#if note.filename??>
                <img src="/img/${note.fileName}" alt="">
            </#if>
        </div>
    </div>
    <#else>
       Нет заметок
   </#list>
</@cm.page>