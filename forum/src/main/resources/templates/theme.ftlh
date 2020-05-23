<#import "partials/main.ftlh" as main />

<@main.renderWith title="Theme" scripts=["main.js"]>
<#--    <input type="hidden" id="user_status" name="user_status" value="${user_status}">-->


    <div class="card" style="width: 30rem;">
        <div class="card-body">
            <h5 class="card-title">Title: ${theme.name} </h5>
            <h6 class="card-subtitle mb-2 text-muted"> Time: ${theme.date} </h6>
            <p class="card-text">Description: ${theme.description}</p>
            <a href="#" class="card-link" onclick="addComment(this.form)">Add Comment</a>
        </div>
    </div>

    <div id="comments">
        <#list comments as comment>
            <div class="main">
                <div class="main-table">
                    <div class="d-flex justify-content-between">
                        <div> ${comment.user}  </div>
                        <div> ${comment.date} </div>
                        <div> ${comment.text} </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>

    <#include "partials/pagination.ftlh">
</@main.renderWith>