/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Estoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
public class EstoqueDAO {
    private static EstoqueDAO instance = new EstoqueDAO();

    public static EstoqueDAO getInstance() {
        return instance;
    }
    
    private EstoqueDAO(){
    }
    
    public void criarEstoque(Estoque estoque)
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            if(estoque.getId() != null)
                em.merge(estoque);
            else
                em.persist(estoque);
            et.commit();
        }
        catch(Exception ex)
        {
            if(et != null && et.isActive())
                et.rollback();
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
    }
    
    public Estoque getById(Long id)
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        return em.find(Estoque.class, id);
    }
    
    public List<Estoque> getByFilial(String filial)
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        List<Estoque> estoques = null;
        try
        {
            Query query = em.createQuery("SELECT estoque FROM Estoque estoque WHERE estoque.filial = :filial");
            query.setParameter("filial", filial);
            estoques = query.getResultList();
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
        return estoques;
    }
    
    
    public List<Estoque> getAllEstoques()
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        List<Estoque> estoques = null;
        try
        {
            Query query = em.createQuery("SELECT estoque FROM Estoque estoque ORDER BY estoque.filial");
            estoques = query.getResultList();
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
        return estoques;
    }
    
    public Estoque getByProdutoByFilial(String produto, String filial)
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        Estoque estoque = null;
        try
        {
            Query query = em.createQuery("SELECT e FROM Estoque e WHERE e.produto=:produto AND e.filial=:filial");
            query.setParameter("produto", produto);
            query.setParameter("filial", filial);
            estoque = (Estoque)query.getSingleResult();
        }
        catch(NoResultException nre)
        {
            return null;
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
        return estoque;
    }
    
    public List<String> getAllFiliais()
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        List<String> estoques = null;
        try
        {
            Query query = em.createQuery("SELECT distinct(estoque.filial) FROM Estoque estoque");
            estoques = query.getResultList();
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
        return estoques;
    }
    
    public void atualizaEstoque(Long id, Estoque newEstoque)
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        int linhasAfetadas = 0;
        try
        {
            et.begin();
            Query query = em.createQuery("UPDATE Estoque e SET e.filial = :filial, e.produto = :produto, e.quantidade = :quantidade WHERE e.id = :id");
            query.setParameter("filial", newEstoque.getFilial());
            query.setParameter("produto", newEstoque.getProduto());
            query.setParameter("quantidade", newEstoque.getQuantidade());
            query.setParameter("id", id);
            linhasAfetadas = query.executeUpdate();
            et.commit();
        }
        catch(Exception ex)
        {
            if(et != null && et.isActive())
                et.rollback();
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
    }
    
    public void excluiEstoque(Estoque estoque)
    {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            em.remove(em.contains(estoque) ? estoque : em.merge(estoque));
            et.commit();
        }
        catch(Exception ex)
        {
            if(et != null && et.isActive())
                et.rollback();
            throw new RuntimeException(ex);
        }
        finally
        {
            PersistenceUtil.close(em);
        }
    }
}
