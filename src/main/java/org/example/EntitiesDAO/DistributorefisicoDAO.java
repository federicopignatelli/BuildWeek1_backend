package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributorefisico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class DistributorefisicoDAO {
    public final EntityManager em;

    public DistributorefisicoDAO(EntityManager entityManager){this.em=entityManager;}
    Logger logger= LoggerFactory.getLogger(DistributorefisicoDAO.class);

    public void save (Distributorefisico ds){
        Query dfExist=em.createQuery("SELECT d FROM Distributorefisico d WHERE d.companyName =:nome");
        String name=ds.getCompanyName();
        dfExist.setParameter("nome",name);
        List resultList = dfExist.getResultList();
        if(!resultList.isEmpty()){
            logger.error("esisto gia");
            em.getTransaction().rollback();
        }else{
            em.persist(ds);
        }

        em.getTransaction().begin();
    }


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
