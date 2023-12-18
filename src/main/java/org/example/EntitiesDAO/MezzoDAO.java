package org.example.EntitiesDAO;

import org.example.Entities.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MezzoDAO {
    private final EntityManager em;
    public MezzoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Mezzo mezzo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mezzo);
        transaction.commit();
        System.out.println("Mezzo " + mezzo.getMezzoType() + " di ID: " + mezzo.getMezzoId() + " aggiunto al db");
    }
    public void delete(Mezzo mezzo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(mezzo);
        transaction.commit();
        System.out.println("Mezzo " + mezzo.getMezzoType() + " di ID: " + mezzo.getMezzoId() + " rimosso dal db");
    }
}
