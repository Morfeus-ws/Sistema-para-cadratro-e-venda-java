<%-- 
    Document   : telaRelatorio
    Created on : 09/11/2020, 08:57:28
    Author     : loure
--%>

<%@page import="entidade.TbCompra"%>
<%@page import="java.util.List"%>
<%@page import="dao.CompraDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio</title>
    </head>
    <body>
        <div class="column margin-bottom">
            <h2>Relatórios</h2>
            <div class="decoration"> </div>
        </div>
            <table id="products" class=" full-width" >
                <th class="full-width title">
                <td>
                Valor total 
                </td>
                <td>
                Data pedido
                </td>
                </th>
               <%
                    CompraDao compra = new CompraDao();
                    List<TbCompra> compras = compra.listarCompra();
                    
                    
                    for( TbCompra c : compras){
                %>
                    <tr>
                        <td><% out.print(c.getCodCompra()); %></td>
                        <td><% out.print(c.getValorTotal()); %></td>
                        <td><% out.print(c.getDataCompra());%></td>
                    </tr>
                <%}%>
            </table>
            <br>
        </body>
    </body>
</html>
