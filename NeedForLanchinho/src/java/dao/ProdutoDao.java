package dao;

import entidade.TbProduto;
import entidade.TbProdutoIngrediente;
import entidade.TbProdutoIngredientePK;
import java.util.List;

public class ProdutoDao extends UtilDao {
    
    @Override
    public void salvar(Object o) {
        TbProduto produto = (TbProduto) o;
        
        this.abreConexao();
        
        List<TbProdutoIngrediente> piList = produto.getTbProdutoIngredienteList();
        produto.setTbProdutoIngredienteList(null);
        
        em.persist(produto);
        em.flush();
        
        
        if (piList.size() > 0) {
            for (TbProdutoIngrediente pi: piList) {
                TbProdutoIngredientePK piPK = 
                        new TbProdutoIngredientePK(
                                produto.getCodProduto(), 
                                pi.getTbIngrediente().getCodIngrediente()
                        );
                
                pi.setTbProdutoIngredientePK(piPK);
                pi.setTbProduto(produto);
                
                em.persist(pi);
            }
            
            produto.setTbProdutoIngredienteList(piList);
        }
        
        this.fecharConexao();
    }
    
    @Override
    public void alterar(Object o) {
        TbProduto produto = (TbProduto) o;
        
        List<TbProdutoIngrediente> novoPiL = produto.getTbProdutoIngredienteList();
        List<TbProdutoIngrediente> antigoPiL = 
                this.buscaProdutoId(
                        produto.getCodProduto()
                ).getTbProdutoIngredienteList();
        
        this.abreConexao();
        
        for (TbProdutoIngrediente pi: antigoPiL) {
            if (!novoPiL.contains(pi)) {
                em.remove(em.merge(pi));
            }
        }
        em.flush();
        
        em.merge(produto);
        
        this.fecharConexao();
    }
    
    public List<TbProduto> listarProdutos(){
        List<TbProduto> produtos;
        this.abreConexao();
        produtos = em.createQuery("SELECT p FROM TbProduto p").getResultList();
        this.fecharConexao();
        return produtos;
    }
    
    public List<TbProduto> listarProdutos(int limit, int offset){
        List<TbProduto> produtos;
        this.abreConexao();
        produtos = em.createQuery("SELECT p FROM TbProduto p")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        this.fecharConexao();
        return produtos;
    }
    
    public List<TbProduto> listarProdutosAtivos(){
        List<TbProduto> produtos;
        this.abreConexao();
        produtos = em.createQuery("SELECT p FROM TbProduto p WHERE p.fgAtivo = true").getResultList();
        this.fecharConexao();
        return produtos;
    }
    
    public List<TbProduto> listarProdutosAtivos(int limit, int offset){
        List<TbProduto> produtos;
        this.abreConexao();
        produtos = em.createQuery("SELECT p FROM TbProduto p WHERE p.fgAtivo = true")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        this.fecharConexao();
        return produtos;
    }
    
    public List<TbProduto> listarProdutosListados(){
        List<TbProduto> produtos;
        this.abreConexao();
        produtos = em.createQuery("SELECT p FROM TbProduto p WHERE p.fgAtivo = true AND p.listado = true").getResultList();
        this.fecharConexao();
        return produtos;
    }
    
    public List<TbProduto> listarProdutosListados(int limit, int offset){
        List<TbProduto> produtos;
        this.abreConexao();
        produtos = em.createQuery("SELECT p FROM TbProduto p WHERE p.fgAtivo = true AND p.listado = true")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        this.fecharConexao();
        return produtos;
    }
    
    public TbProduto buscaProdutoId(int idProduto) {
        this.abreConexao();
        TbProduto produto = em.find(TbProduto.class, idProduto);
        this.fecharConexao();
        return produto;
    }
    
}
