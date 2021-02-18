package dao;

import static dao.UtilDao.em;
import entidade.TbIngrediente;
import java.util.List;

public class IngredienteDao extends UtilDao {
    
    public List<TbIngrediente> listarIngredientes(){
        List<TbIngrediente> ingredientes;
        this.abreConexao();
        ingredientes = em.createQuery("SELECT i FROM TbIngrediente i").getResultList();
        this.fecharConexao();
        return ingredientes;
    }
    
    public List<TbIngrediente> listarIngredientesAtivos(){
        List<TbIngrediente> ingredientes;
        this.abreConexao();
        ingredientes = em.createQuery("SELECT i FROM TbIngrediente i WHERE i.fgAtivo = true").getResultList();
        this.fecharConexao();
        return ingredientes;
    }
    
    public TbIngrediente buscaIngredienteId(int idIngrediente) {
        this.abreConexao();
        TbIngrediente ingrediente = 
                em.find(TbIngrediente.class, idIngrediente);
        this.fecharConexao();
        return ingrediente;
    }
    
}
