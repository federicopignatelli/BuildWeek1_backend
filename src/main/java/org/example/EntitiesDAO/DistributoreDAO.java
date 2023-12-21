package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.Entities.Tipologia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class DistributoreDAO {
    Logger logger= LoggerFactory.getLogger(DistributoreDAO.class);
    public final EntityManager em;

    public DistributoreDAO(EntityManager em){this.em = em;}

    public void save(Distributore distributore){
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }

        em.persist(distributore);

        if(!em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
        System.out.println(distributore.getIdBiglietteria());
    }
    public Distributore getById(Distributore d){
        Distributorefisico di=em.find(Distributorefisico.class ,d.getIdBiglietteria());
        System.out.println(di.toString());
        return di;
    }
}
