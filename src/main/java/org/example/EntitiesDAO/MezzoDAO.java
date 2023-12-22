package org.example.EntitiesDAO;

import org.example.Entities.Manutenzione;
import org.example.Entities.Mezzo;
import org.example.Entities.Viaggio;

import javax.persistence.*;
import java.util.List;

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
        System.out.println("Mezzo " + mezzo.getMezzoType() + " di id: " + mezzo.getMezzoId()+ "  aggiunto al db");
    }
    public void delete(Mezzo mezzo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(mezzo);
        transaction.commit();
        System.out.println("Mezzo " + mezzo.getMezzoType()  + " rimosso dal db");
    }
    public void stampaInfoManutenzioneMezzo(Long mezzoId) {
        TypedQuery<Manutenzione> queryManutenzione = em.createQuery(
                "SELECT m FROM Manutenzione m WHERE m.mezzi.mezzoId = :mezzoId", Manutenzione.class);
        queryManutenzione.setParameter("mezzoId", mezzoId);

        List<Manutenzione> manutenzioni = queryManutenzione.getResultList();

        if (manutenzioni.isEmpty()) {
            System.out.println("Il mezzo con ID " + mezzoId + " non è in manutenzione.");

            TypedQuery<Viaggio> queryViaggio = em.createQuery(
                    "SELECT v FROM Viaggio v WHERE v.mezzo.mezzoId = :mezzoId", Viaggio.class);
            queryViaggio.setParameter("mezzoId", mezzoId);

            List<Viaggio> viaggi = queryViaggio.getResultList();

            if (viaggi.isEmpty()) {
                System.out.println("Non ci sono viaggi registrati per il mezzo con ID " + mezzoId + ".");
            } else {
                for (Viaggio viaggio : viaggi) {
                    System.out.println("Il Mezzo è in servizio:");
                    System.out.println("Viaggio ID: " + viaggio.getId() + ", Tratta: " + viaggio.getTratta().getId_tratta() +
                            ", Partenza: " + viaggio.getOraPartenza() + ", Arrivo: " + viaggio.getOraArrivo());
                }
            }
        } else {
            for (Manutenzione manutenzione : manutenzioni) {
                System.out.println("Il mezzo con ID " + mezzoId + " è in manutenzione. Data inizio: " +
                        manutenzione.getData_inizio() + ", Data fine: " + manutenzione.getData_fine());
            }
        }
    }

}
