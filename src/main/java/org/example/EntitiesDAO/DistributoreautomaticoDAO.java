package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;

import javax.persistence.EntityManager;

public class DistributoreautomaticoDAO {
    EntityManager em;

    public DistributoreautomaticoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Distributore da) {

        em.persist(da);
    }
}
