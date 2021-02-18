package dao;

import entidade.TbCategoriaIngrediente;
import java.util.List;

public class CategoriaIngredienteDao extends UtilDao {
    
    public List<TbCategoriaIngrediente> listarCategoria() {
        List<TbCategoriaIngrediente> listaCategoria;
        this.abreConexao();
        listaCategoria = em.createQuery("SELECT cp FROM TbCategoriaIngrediente cp").getResultList();
        this.fecharConexao();
        return listaCategoria;
    }
    
    public TbCategoriaIngrediente buscaCategoriaId(int idCategoria) {
        this.abreConexao();
        TbCategoriaIngrediente categoria = 
                em.find(TbCategoriaIngrediente.class, idCategoria);
        this.fecharConexao();
        return categoria;
    }
    
}
