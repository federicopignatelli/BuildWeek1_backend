package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;


public class DistributoreDAO {
    Logger logger = LoggerFactory.getLogger(DistributoreDAO.class);
    public final EntityManager em;

    public DistributoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Distributore distributore) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try{
            if (distributore instanceof Distributoreautomatico) {
                em.persist(distributore);
            } else if (distributore instanceof Distributorefisico) {
                em.persist(distributore);
            }
        }catch(RuntimeException e){
            logger.error(e.getMessage());
        }



        if (!em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        System.out.println(distributore.getIdBiglietteria());
    }

    public Distributore getById(Distributore d) {
        Distributorefisico di = em.find(Distributorefisico.class, d.getIdBiglietteria());
        System.out.println(di.toString());
        return di;
    }
    public void getDistributoreDb(){



    }
}
