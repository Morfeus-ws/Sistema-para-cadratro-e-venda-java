package dao;

import entidade.TbCliente;
import entidade.TbCompra;
import entidade.TbCompraProduto;
import entidade.TbCompraProdutoPK;
import java.util.List;

public class CompraDao extends UtilDao {
    
    @Override
    public void salvar(Object o) {
        TbCompra compra = (TbCompra) o;
        this.abreConexao();
        
        List<TbCompraProduto> cpList = compra.getTbCompraProdutoList();
        compra.setTbCompraProdutoList(null);
        
        em.persist(compra);
        em.flush();
        
        
        if (cpList.size() > 0) {
            for (TbCompraProduto cp: cpList) {
                TbCompraProdutoPK cpPK = 
                        new TbCompraProdutoPK(
                                compra.getCodCompra(), 
                                cp.getTbProduto().getCodProduto()
                        );
                
                cp.setTbCompraProdutoPK(cpPK);
                cp.setTbCompra(compra);
                
                em.persist(cp);
            }
            
            compra.setTbCompraProdutoList(cpList);
        }
        
        this.fecharConexao();
    }
    
    @Override
    public void alterar(Object o) {
        TbCompra compra = (TbCompra) o;
        
        List<TbCompraProduto> novoCpL = compra.getTbCompraProdutoList();
        List<TbCompraProduto> antigoCpL = 
                this.buscaCompraId(
                        compra.getCodCompra()
                ).getTbCompraProdutoList();
        
        this.abreConexao();
        
        for (TbCompraProduto cp: antigoCpL) {
            if (!novoCpL.contains(cp)) {
                em.remove(em.merge(cp));
            }
        }
        em.flush();
        
        em.merge(compra);
        
        this.fecharConexao();
    }
    
    public List<TbCompra> listarCompra() {
        List<TbCompra> listaCompra;
        this.abreConexao();
        listaCompra = em.createQuery("SELECT c FROM TbCompra c").getResultList();
        this.fecharConexao();
        return listaCompra;
    }
    
    public List<TbCompra> listarCompra(int limit, int offset) {
        List<TbCompra> listaCompra;
        this.abreConexao();
        listaCompra = em.createQuery("SELECT c FROM TbCompra c")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        this.fecharConexao();
        return listaCompra;
    }
    
    public TbCompra buscaCompraId(int idCompra) {
        this.abreConexao();
        TbCompra compra = em.find(TbCompra.class, idCompra);
        this.fecharConexao();
        return compra;
    }
    
    public List<TbCompra> buscaCompraCliente(TbCliente cliente) {
        List<TbCompra> listaCompra;
        this.abreConexao();
        listaCompra = em.createQuery("SELECT c "
                + "FROM TbCompra c "
                + "WHERE c.codCliente = :idCliente")
                .setParameter("idCliente", cliente)
                .getResultList();
        this.fecharConexao();
        return listaCompra;
    }
    
    public List<TbCompra> buscaCompraCliente(TbCliente cliente, int limit, int offset) {
        List<TbCompra> listaCompra;
        this.abreConexao();
        listaCompra = em.createQuery("SELECT c "
                + "FROM TbCompra c "
                + "WHERE c.codCliente = :idCliente")
                .setParameter("idCliente", cliente)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        this.fecharConexao();
        return listaCompra;
    }
    
}
