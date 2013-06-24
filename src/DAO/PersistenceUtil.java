/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pedro
 */
public class PersistenceUtil {
    private static EntityManagerFactory emf = null;
    
    private PersistenceUtil(){        
    }
    
    public static EntityManager getEntityManager()
    {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("lp3-2013-1-trb2-pedrofelipePU");
        return emf.createEntityManager();
    }
    
    public static void close(EntityManager em)
    {
        if(em != null)
            em.close();
    }
        
}
