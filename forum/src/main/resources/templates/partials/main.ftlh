<#--
 объявляем макро-функцию используя которую мы создадим шаблон страницы
 https://freemarker.apache.org/docs/dgui_misc_userdefdir.html
 -->
<#import "/spring.ftl" as spring>
<#macro renderWith title scripts=[] styles=[] dir="ltr">
    <!doctype html>
    <html lang="${.locale}" dir="${dir}">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title> ${title}</title>
        <link rel="stylesheet" href="/css/styles.css">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <#--
    например если бы у нашего сайта было какое-то верхнее меню,
    то мы могли бы его тут указать
    и оно появится сразу на всех страницах которые используют
    этот шаблон
    -->

    <header class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
<#--        <nav class="navbar navbar-expand-lg navbar-light bg-light">-->
            <nav class="nav">
                <a class="navbar-brand" href="/">Main</a>
                <a class="navbar-brand" href="/create">Create theme</a>

            </nav>

            <#if user??>
                        <ul  class="nav justify-content-end navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/profile">Profile</a>
                            </li>
                            <li class="nav-item">
                                <form  action="/logout" method="post">
                                    <#if _csrf??>
                                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                                    </#if>
                                    <button class=" btn btn-light" > Logout</button>
                                </form>
                            </li>
                        </ul>
                    <#else>
                        <ul  class="nav justify-content-end navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/login">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/registration">Registration</a>
                            </li>
                        </ul>
                    </#if>

<#--        </nav>-->

        </div>
    </header>



    <div class="container ">
        <#--
         элемент nested указывает что в этом место
         будет подставлено некоторое содержимое,
         которое передаётся как тело макро-функции при её вызове
        -->
        <#nested>

    </div>
    <script src="js/main.js"></script>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>

</#macro>