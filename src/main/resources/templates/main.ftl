<#import "parts/common.ftl" as c>

<@c.page>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить заметку
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="Введите текст" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="priority" placeholder="Приоритет">
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Выбрать файл</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
<div class="card-columns">


<#list notes as note>
    <div class="card my-3">
        <#if note.fileName??>
            <img src="/img/${note.fileName}" class="card-img-top">
        </#if>
        <div class="m-2">
            <span>${note.text}</span>
            <i>${note.priority}</i>
        </div>
        <div class="card-footer text-muted">
            ${note.authorName}
        </div>
    </div>
<#else>
    Нет заметок
</#list>
</div>
</@c.page>