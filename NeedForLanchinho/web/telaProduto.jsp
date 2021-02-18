<%-- 
    Document   : telaProduto
    Created on : 09/11/2020, 08:57:09
    Author     : loure
--%>

<%@page import="entidade.TbCategoriaIngrediente"%>
<%@page import="dao.CategoriaIngredienteDao"%>
<%@page import="entidade.TbIngrediente"%>
<%@page import="java.util.List"%>
<%@page import="dao.IngredienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Produtos</title>
    </head>
    <body>
        <div class="column margin-bottom">
            <h2>Pedido</h2>
            <div class="decoration"> </div>
        </div>
        <form action="ProdutoServlet">
        <%
            IngredienteDao ingrediente = new IngredienteDao();
            List<TbIngrediente> ingredientes = ingrediente.listarIngredientes();
            CategoriaIngredienteDao categoria = new CategoriaIngredienteDao();
            List<TbCategoriaIngrediente> categorias = categoria.listarCategoria();
            
            for(TbCategoriaIngrediente c : categorias){
        %>
            <div>
                <p><%out.print(c.getCategoriaIngrediente());%></p>
        <%  for( TbIngrediente i : ingredientes){
                if(c.getCodCategoriaIngrediente() == 
                        i.getCodCategoriaIngrediente().getCodCategoriaIngrediente()){
        %>
                <div>
                    <input type="radio" name="<%out.print(c.getCategoriaIngrediente());%>"
                               value="<%out.print(i.getCodIngrediente());%>" class="margin-bottom">
                    <label class="margin-bottom"><% out.print(i.getNomeIngrediente()); %></label>
                    <label class="margin-bottom"><% out.print(i.getPrecoIngrediente()); %></label>
                </div>
        <%}}%>
            </div>
        <%}%>

        <div class="row justify-between">
            <input class="submit-btn" type="submit" value="Finalizar compra">
        </div>
        <form>
        
    </body>
</html>

