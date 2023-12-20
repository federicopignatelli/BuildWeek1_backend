package org.example.EntitiesDAO;

import org.example.Application;
import org.example.Entities.Mezzo;
import org.example.Entities.Tratta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

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

//    public void percorriTratta(Mezzo mezzi, Tratta tratta){
//        EntityTransaction transaction = em.getTransaction();
//        long idMezzo = mezzi.getMezzoId();
//        long idTratta = tratta.getId_tratta();
//        long valoreIncrementale = 1;
//        transaction.begin();
//        String targaMezzo = mezzi.getTarga();
//        Query findMezzo = em.createQuery("SELECT n FROM Mezzo n WHERE n.targa = :targa");
//        Query findTratta = em.createQuery("SELECT a FROM Mezzo a JOIN a.Tratta r WHERE r.tratta_id = :idTratta ");
//        Query countAdd = em.createQuery("UPDATE Mezzo g SET g" +
//                ".num_percorrenza=g.num_percorrenza + :valoreIncrementale WHERE g.targa =:targa");
//
//
//
//
//        findMezzo.setParameter("targa", mezzi.getTarga());
//        List mezziList = findMezzo.getResultList();
//        System.out.println(mezziList.size());
//        Mezzo risultatoMezzo = (Mezzo) mezziList.get(0);
//        findTratta.setParameter("idTratta", idTratta);
//        List trattaList = findTratta.getResultList();
//        System.out.println(trattaList.size());
//        trattaList.stream().findFirst().equals(risultatoMezzo);
//        do {
//            for(int i = 0; i < trattaList.size(); i++) {
//                Mezzo mezzox = (Mezzo) trattaList.get(i);
//                if (Objects.equals(mezzox.getTarga(), risultatoMezzo.getTarga())) {
//                    countAdd.setParameter("valoreIncrementale", valoreIncrementale);
//                    countAdd.setParameter("targa", risultatoMezzo.getTarga());
//                    countAdd.executeUpdate();
//                    transaction.commit();
//                } else if (trattaList.isEmpty()) {
//                    System.out.println("Non esiste veicolo assegnato a quella targa!!!");
//                }
//            }
//        } while (mezzox)
//
//    }
}
