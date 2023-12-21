package org.example.EntitiesDAO;

import org.example.Entities.Distributorefisico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DistributorefisicoDAO {
    public final EntityManager em;

    public DistributorefisicoDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    Logger logger = LoggerFactory.getLogger(DistributorefisicoDAO.class);

    /*public void save(Distributorefisico ds) {
        *//*Query dfExist=em.createQuery("SELECT d FROM Distributorefisico d WHERE d.companyName =:nome");*//*

        Query dfExist = em.createNamedQuery("existsByCompanyNameLike");
        String name = ds.getCompanyName();
       *//* dfExist.setParameter("companyName", name);*//*
        List<Distributorefisico> distList= dfExist.getResultList();
        try {
            if (distList.isEmpty()) {
                em.persist(ds);
                logger.error("Non esisto e sto impazzendo");
            } else {
                logger.error("esisto gia");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            em.getTransaction().commit();
        }


    }*/


    /*public List getPiva(String piva){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        Query q= em.createQuery("SELECT c from  Distributore c where distributore_fisico.pIva = :piva");
        q.setParameter("piva", piva);
        List results = q.getResultList();
        transaction.commit();
        return results;
    }
*/

}
