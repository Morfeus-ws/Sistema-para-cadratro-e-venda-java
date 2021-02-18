package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilDao {
    private static EntityManagerFactory  emf;
    public static EntityManager  em;

    public void abreConexao(){
        emf = Persistence.createEntityManagerFactory("NeedForLanchinhoPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void fecharConexao(){
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
  
    public void salvar (Object o){
        this.abreConexao();
        em.persist(o);
        this.fecharConexao();
    }

    public void alterar (Object o){
        this.abreConexao();
        em.merge(o);
        this.fecharConexao();
    }

    public void excluir (Object o){
        this.abreConexao();
        em.remove(em.merge(o));
        this.fecharConexao();
    }
}
