package org.example.EntitiesDAO;

import org.example.Entities.Manutenzione;
import org.example.Entities.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ManutenzioneDAO {
    private final EntityManager em;
    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Manutenzione manutenzione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manutenzione);
        transaction.commit();
        System.out.println("Manutenzione " + manutenzione.getDescrizione_manutenzione() + " aggiunto al db");
    }
    public void delete(Manutenzione manutenzione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(manutenzione);
        transaction.commit();
        System.out.println("Manutenzione " + manutenzione.getDescrizione_manutenzione() + " rimosso dal db");
    }
}
