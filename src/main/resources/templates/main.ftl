<#import "parts/common.ftl" as cm>
<#import "parts/login.ftl" as l>
<@cm.page>
    <div>
        <@l.logout />
        <span><a href="/user">User List</a></span>
    </div>

    <div>
        <form method="POST">
            <input type="text" name="text" placeholder="Введите задачу">
            <input type="number" name="priority" placeholder="Приоритет">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список дел</div>
   <#list notes as note>
    <div>
        <b>${note.id}</b>
        <b>${note.text}</b>
        <b>${note.priority}</b>
        <strong>${note.authorName}</strong>
    </div>
    <#else>
       Нет заметок
   </#list>
</@cm.page>