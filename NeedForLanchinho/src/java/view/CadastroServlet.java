package view;

import dao.ClienteDao;
import dao.EnderecoDao;
import entidade.TbCliente;
import entidade.TbEndereco;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet extends HttpServlet {

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
        
        TbEndereco endereco = new TbEndereco();
        endereco.setCep(request.getParameter("cep"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setRua(request.getParameter("rua"));
        endereco.setNumero(request.getParameter("numero"));
        endereco.setComplemento(request.getParameter("complemento"));
        
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.salvar(endereco);
        
        List<TbEndereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        
        TbCliente cliente = new TbCliente();
        cliente.setNomeCompleto(request.getParameter("userName") + " "
                + request.getParameter("lastName"));
        cliente.setCpf(request.getParameter("document"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setSenha(request.getParameter("password"));
        cliente.setTbEnderecoList(enderecos);
        
        ClienteDao cdao = new ClienteDao();
        cdao.salvar(cliente);
        
        
        Cookie cookie = new Cookie("IdCliente", Integer.toString(cliente.getCodCliente()));
        response.addCookie(cookie);
        
        response.sendRedirect("telaProduto.jsp"); 
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
