package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;

import javax.persistence.EntityManager;

public class DistributoreDAO {
    public final EntityManager em;

    public DistributoreDAO(EntityManager em){this.em = em;}
    public void save(Distributoreautomatico dm){
        em.getTransaction().begin();

        em.persist(dm);

        em.getTransaction().commit();
    }


}
