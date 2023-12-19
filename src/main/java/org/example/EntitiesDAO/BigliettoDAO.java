package org.example.EntitiesDAO;

import org.example.Entities.Biglietto;

import javax.persistence.EntityManager;

public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Biglietto bi){}

    public void delete(Biglietto bi){}

}
