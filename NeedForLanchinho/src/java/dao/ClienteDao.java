package dao;

import entidade.TbCliente;
import java.util.List;

public class ClienteDao extends UtilDao {
    
    public List<TbCliente> listarClientes(){
        List<TbCliente> clientes;
        this.abreConexao();
        clientes = em.createQuery("SELECT c FROM TbCliente c").getResultList();
        this.fecharConexao();
        return clientes;
    }
    
    public TbCliente buscaClienteId(int idCliente) {
        this.abreConexao();
        TbCliente cliente = em.find(TbCliente.class, idCliente);
        this.fecharConexao();
        return cliente;
    }
    
    public TbCliente buscaClienteEmail(String emailCliente) {
        this.abreConexao();
        
        Integer idCliente = (Integer) em.createNativeQuery("SELECT c.cod_cliente "
                + "FROM tb_cliente c "
                + "WHERE c.email = '"+emailCliente+"'").getSingleResult();
        
        TbCliente cliente = em.find(TbCliente.class, idCliente);
        
        this.fecharConexao();
        return cliente;
    }
    
    public boolean validarSenha(String email, String senha){
        this.abreConexao();
        boolean validacao = (boolean) em.createNativeQuery("SELECT EXISTS(SELECT c.email, c.senha "
                + "FROM tb_cliente c "
                + "WHERE c.email = '"+email+"' "
                + "AND c.senha = '"+senha+"')").getSingleResult();
        this.fecharConexao();
        return validacao;
    }
    
}
