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
//
//        transaction.begin();
//
//        Query findMezzo = em.createQuery("SELECT n FROM Mezzo n WHERE n.targa = :targa");
//        findMezzo.setParameter("targa", mezzi.getTarga());
//        // Esecuzione della query e salvataggio dei risultati in una lista
//        List mezziList = findMezzo.getResultList();
//        //controllo se la lista dei mezzi è vuota e rollback
//        if(mezziList.isEmpty()){
//            System.out.println("Non esiste veicolo assegnato a quella targa!!!");
//            transaction.rollback();
//            return;
//        }
//        //estrazione del primo Mezzo trovato nella lista
//        Mezzo risultatoMezzo = (Mezzo) mezziList.get(0);
//
//        Query findTratta = em.createQuery("SELECT a FROM Mezzo a JOIN a.Tratta r WHERE r.tratta_id = :idTratta ");
//        findTratta.setParameter("idTratta", idTratta);
//        List trattaList = findTratta.getResultList();
//
//        if(trattaList.isEmpty()){
//            System.out.println("Non esiste veicolo assegnato a quella targa!!!");
//            transaction.rollback();
//            return;
//        }
//
//        Query countAdd = em.createQuery("UPDATE Mezzo g SET g" +
//                ".num_percorrenza=g.num_percorrenza + :valoreIncrementale WHERE g.targa =:targa");
//
//        countAdd.setParameter("valoreIncrementale", valoreIncrementale);
//        countAdd.setParameter("targa", risultatoMezzo.getTarga());
//        countAdd.executeUpdate();
//        transaction.commit();
//
//    }
}
