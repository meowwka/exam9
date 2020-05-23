<#import "partials/main.ftlh" as main />

<@main.renderWith title="Seccess!">

<#if user??>
        <h2>Profile</h2>
    <div class="card border-dark mb-3" style="max-width: 60rem;margin-left: 5rem;">
        <div class="card-header">
<#--            ${(user.name)!'-- missing --'}-->
        </div>
        <div class="card-body text-dark">
            <h5 class="card-title">Name: ${user.name!'--name missing--'}</h5>
            <h5 class="card-title">Email: ${user.email!'--email missing--'}</h5>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias dolores fugiat maiores perferendis provident qui, quidem quo similique tempore voluptate.</p>
        </div>
    </div>
    <#else>
        <h1><@spring.message "user-not-found"/></h1>
    </#if>
</@main.renderWith>