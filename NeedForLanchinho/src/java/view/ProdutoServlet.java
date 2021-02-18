/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDao;
import dao.CompraDao;
import dao.IngredienteDao;
import entidade.TbCliente;
import entidade.TbCompra;
import entidade.TbIngrediente;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vitor
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int codCliente = verifyCodClienteCookie(request.getCookies());
        if (codCliente == -1) {
            response.sendRedirect("login.jsp");
        }
        
        TbIngrediente carne, pao, molho, salada;
        carne = new IngredienteDao().buscaIngredienteId(Integer.parseInt(request.getParameter("Carne")));
        pao = new IngredienteDao().buscaIngredienteId(Integer.parseInt(request.getParameter("Pão")));
        molho = new IngredienteDao().buscaIngredienteId(Integer.parseInt(request.getParameter("Molho")));
        salada = new IngredienteDao().buscaIngredienteId(Integer.parseInt(request.getParameter("Salada")));
        
        float valorTotal = (float) (carne.getPrecoIngrediente() + pao.getPrecoIngrediente() 
                + molho.getPrecoIngrediente() + salada.getPrecoIngrediente());
        
        ClienteDao clienteDao = new ClienteDao();
        TbCliente cliente = clienteDao.buscaClienteId(codCliente);
        
        TbCompra compra = new TbCompra();
        compra.setCodCliente(cliente);
        compra.setCodEndereco(cliente.getTbEnderecoList().get(0));
        compra.setDataCompra(new Date());
        compra.setValorTotal(valorTotal);
        
        CompraDao compraDao = new CompraDao();
        compraDao.salvar(compra);
        
    }
    
    private int verifyCodClienteCookie(Cookie[] cookies) {
        int codCliente = -1;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("IdCliente")) {
                codCliente = Integer.parseInt(cookie.getValue());
                break;
            }
        }
        return codCliente;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
