package org.example.EntitiesDAO;

import org.example.Entities.Mezzo;
import org.example.Entities.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ViaggioDAO {
    private final EntityManager em;
    public ViaggioDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Viaggio viaggio) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(viaggio);
        transaction.commit();
        System.out.println("Viaggio " +  " di id: " + viaggio.getId()+ "  aggiunto al db");
    }
    public void delete(Viaggio viaggio) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(viaggio);
        transaction.commit();
        System.out.println("Viaggio " + viaggio.getId()  + " rimosso dal db");
    }
}
