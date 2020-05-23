<#import "partials/main.ftlh" as main />

<@main.renderWith title="Theme" scripts=["main.js"]>
<#--    <input type="hidden" id="user_status" name="user_status" value="${user_status}">-->


    <div class="card mt-3" style="width: 30rem; text-align: center">
        <div class="card-body">
            <h5 class="card-title">Title: ${theme.name} </h5>
            <h6 class="card-subtitle mb-2 text-muted"> Time: ${theme.date} </h6>
            <p class="card-text">Description: ${theme.description}</p>
            <form action="/theme/add/comment" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <input type="hidden" name="theme_id" value="${theme.id}"/>
                <input type="text" name="text" id="title" class="form-control"  placeholder="Your comment" required>
                <button type="submit" class="btn btn-outline-info btn-block" >Add Comment</button>




            </form>
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

    <br><br><br>

    <#include "partials/pagination.ftlh">
</@main.renderWith>