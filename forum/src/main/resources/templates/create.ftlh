<#import "partials/main.ftlh" as main />
<@main.renderWith title="Main">

    <form action="/create" class="mt-3" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <input type="text" name="name" placeholder="Enter title" class="form-control"><br>


            <textarea name="description" placeholder="Enter description" class="form-control"></textarea><br>
        <button type="submit" class="btn btn-success">Add </button>
    </form>
</@main.renderWith>