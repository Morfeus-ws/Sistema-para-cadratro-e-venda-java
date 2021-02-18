package dao;

import entidade.TbEndereco;
import java.util.List;

public class EnderecoDao extends UtilDao {
    
    public List<TbEndereco> listarEnderecos() {
        List<TbEndereco> listaEnderecos;
        this.abreConexao();
        listaEnderecos = em.createQuery("SELECT e FROM TbEndereco e").getResultList();
        this.fecharConexao();
        return listaEnderecos;
    }
    
    public List<String> buscaCidades(String cidade) {
        List<String> listaCidades;
        this.abreConexao();
        listaCidades = em.createQuery("SELECT DISTINCT(e.cidade) "
                + "FROM TbEndereco e "
                + "WHERE e.cidade LIKE '"+cidade+"%'").getResultList();
        this.fecharConexao();
        return listaCidades;
    }
    
    public List<String> buscaBairros(String cidade, String bairro) {
        List<String> listaCidades;
        this.abreConexao();
        listaCidades = em.createQuery("SELECT DISTINCT(e.bairro) "
                + "FROM TbEndereco e "
                + "WHERE e.cidade = '"+cidade+"'"
                + "AND e.bairro LIKE '"+bairro+"%'").getResultList();
        this.fecharConexao();
        return listaCidades;
    }
    
    public List<String> buscaRuas(String cidade, String bairro, String rua) {
        List<String> listaCidades;
        this.abreConexao();
        listaCidades = em.createQuery("SELECT DISTINCT(e.rua) "
                + "FROM TbEndereco e "
                + "WHERE e.cidade = '"+cidade+"'"
                + "AND e.bairro = '"+bairro+"'"
                + "AND e.rua LIKE '"+rua+"%'").getResultList();
        this.fecharConexao();
        return listaCidades;
    }
    
    public TbEndereco buscaEnderecoId(int idEndereco) {
        this.abreConexao();
        TbEndereco categoria = em.find(TbEndereco.class, idEndereco);
        this.fecharConexao();
        return categoria;
    }
    
}
