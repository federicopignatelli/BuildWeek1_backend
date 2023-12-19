package org.example.EntitiesDAO;

import org.example.Entities.Distributorefisico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class DistributorefisicoDAO {
    public final EntityManager em;

    public DistributorefisicoDAO(EntityManager entityManager){this.em=entityManager;}


    public void save (Distributorefisico ds){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ds);
        transaction.commit();
    }


    public List getPiva(String piva){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        Query q= em.createQuery("SELECT c from  Distributore c where distributore_fisico.pIva = :piva");
        q.setParameter("piva", piva);
        List results = q.getResultList();
        transaction.commit();
        return results;
    }

}
