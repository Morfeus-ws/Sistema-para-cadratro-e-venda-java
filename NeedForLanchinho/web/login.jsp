<%-- 
    Document   : login
    Created on : 09/11/2020, 08:55:59
    Author     : loure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="justify-center column align-center full-height">
            <div class="justify-center row">
                <div style="height: min-content;" class="margin-right-md">
                    <img src="undraw_on_the_way_ldaq.svg" class="image">
                </div>

                <div class="container column align-center">
                    <div class="row justify-between margin-bottom">
                        <div class="column">
                            <h2>Acessar</h2>
                            <div class="decoration"> </div>
                        </div>
                        <a href="http://localhost:8090/NeedForLanchinho/cadastro.jsp" class="link">Não possui uma conta?</a>
                    </div>
                   
                    <form action="LoginServlet" method="GET" class="form">
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" class="margin-bottom input">
                        <label for="password">Senha:</label>
                        <input type="password" id="password" name="password" class="margin-bottom input">
           <input type="submit" value="Entrar" class="submit-btn">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
