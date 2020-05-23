<#import "partials/main.ftlh" as main />
<@main.renderWith title="Main">
    <h2 style="text-align: center">Themes</h2>
    <#list  themes as t>
<div class="list-group">
    <a href="/theme/${t.id}"  class="list-group-item list-group-item-action list-group-item-info"> № : ${t.id} Name: ${t.name} Date: ${t.date} Comments:${t.comments}</a>

</div>
    </#list>
    <#include "partials/pagination.ftlh">

</@main.renderWith>
