<#import "partials/main.ftlh" as main />

<@main.renderWith title="Registration">

  <div class="d-flex justify-content-center">
    <div class="mx-3">
      <form action="/registration" id="registration-form" method="post">
        <h3>Registration</h3>
          <#if _csrf??>
              <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
          </#if>
        <input type="email" name="email" class="form-control mb-2" placeholder="email" value="${form.email!''}">
        <input type="text"  name="name" class="form-control mb-2" placeholder="name" value="${form.name!''}" >
        <input type="password" name="password" class="form-control mb-2" placeholder= "password" value="">
        <button type="submit" class="btn btn-outline-info btn-block"> Registration</button>
          <a type="submit" href="/login" class="btn btn-outline-info btn-block">Sign-in</a>
      </form>
      <div>
        <#if errors?? >
          <p>input-error</p>
          <#list errors as fieldError>
            <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
          </#list>
        </#if>
        <#if user?? >
          <p>${user.name} - ${user.login}- ${user.email} already registered!</p>
        </#if>
      </div>

    </div>

  </div>

</@main.renderWith>
