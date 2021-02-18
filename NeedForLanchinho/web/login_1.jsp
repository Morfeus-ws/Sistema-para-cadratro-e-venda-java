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
        <div class="menuGrid">
            <img src="undraw_on_the_way_ldaq.svg" class="image">
            <div class="formDiv">
                <form action="/action_page.php" class="form">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email">
                    <label for="password">Senha:</label>
                    <input type="text" id="password" name="password">
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </body>
</html>