<#import "partials/main.ftlh" as main />

<@main.renderWith title="Login">
    <h2>Please Sign In</h2>
    <div>
        <#if error!false>
            <p style="color: red"> Invalid data entry</p>
        </#if>
    </div>

    <div class="d-flex justify-content-center">
        <div class="mx-3">

            <form   action="/login" method="post" style=" margin-left: 15rem;">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                    <input type="text" class="form-control" name="username" placeholder="Your email"  value="${(user.email)!''}" autofocus >
                    <input type="password" class="form-control" name="password" placeholder="password" value="" autofocus>
                <div>
                    <button type="submit" class="btn btn-outline-info  btn-block">Sign In</button>
                    <a href="/registration"  class="btn btn-outline-info  btn-block">Registration</a>
                </div>
            </form>
        </div>
    </div>
</@main.renderWith>