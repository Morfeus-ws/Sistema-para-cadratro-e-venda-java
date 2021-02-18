<%-- 
    Document   : cadastro
    Created on : 09/11/2020, 08:56:14
    Author     : loure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
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
                            <h2>Registrar</h2>
                            <div class="decoration"> </div>
                        </div>
                        <a href="http://localhost:8090/NeedForLanchinho/login.jsp" class="link">Já possui uma conta?</a>
                    </div>
                    
                    <form action="CadastroServlet" class="form">
                        <div class="row margin-bottom">
                            <div class="column full-width margin-right-sm">
                                <label for="userName">Nome:</label>
                                <input type="text" id="userName" name="userName" class="input">
                            </div>
                            <div class="column full-width margin-left-sm">
                                <label for="lastName">Sobrenome:</label>
                                <input type="text" id="lastName" name="lastName" class="input">
                            </div>
                        </div>
                        <label for="document" >CPF:</label>
                        <input type="text" id="document" name="document" class="margin-bottom input">
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" class="margin-bottom input">
                        <div class="row margin-bottom">
                            <div class="column full-width margin-right-sm">
                                <label for="password">Senha:</label>
                                <input type="password" id="password" name="password" class="input">
                            </div>
                            <div class="column full-width margin-left-sm">
                                <label for="repassword">Repita a senha:</label>
                                <input type="password" id="repassword" name="repassword" class="input">
                            </div>
                        </div>
                        
                        
                        <label for="cidade">Cidade:</label>
                        <input type="text" name="cidade" class="margin-bottom input">
                        <label for="bairro">Bairro:</label>
                        <input type="text" name="bairro" class="margin-bottom input">
                        <label for="rua">Rua:</label>
                        <input type="text" name="rua" class="margin-bottom input">
                        
                        <div class="row margin-bottom">
                            <div class="column full-width margin-right-sm">
                                <label for="numero">Número:</label>
                                <input type="text" name="numero" class="margin-bottom input">
                            </div>
                            <div class="column full-width margin-left-sm">
                                <label for="cep">Cep:</label>
                                <input type="text" name="cep" class="margin-bottom input">
                            </div>
                        </div>
                        <label for="complemento">Complemento:</label>
                        <input type="text" name="complemento" class="margin-bottom input">
                        
                        <input type="submit" value="Cadastrar-se" class="submit-btn">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>