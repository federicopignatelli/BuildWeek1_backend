package org.example.EntitiesDAO;

import org.example.Entities.Abbonamento;
import org.example.Entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;

public class AbbonamentoDAO {
    EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Abbonamento abbonamento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(abbonamento);
        transaction.commit();
    }

    public Abbonamento findById(long id){
        return em.find(Abbonamento.class, id);
    }

    public void delete(long id) {
        Abbonamento found = em.find(Abbonamento.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        }else{
            System.err.println("Abbonamento non trovato!");
        }
    }
    //funzione per la verifica rapida della validità di un abbonamento
    // in base al numero di tessera

    public boolean verificaValidita(String cardNumber){
        String queryString = "SELECT a FROM Abbonamento a WHERE a.card.cardNumber = :cardNumber AND a.currentDate BETWEEN a.dataemissioneAbbondamento AND a.dataScadenzaAbbondamento"; //filtra gli abbonamenti della tessera passata come parametro
        Query query =  em.createQuery(queryString);
                query.setParameter("cardNumber", cardNumber);
                query.setParameter("currentDate", LocalDate.now() );
        //eseguo la query restituendo il risultato
        Abbonamento abbonamento = (Abbonamento) query.getSingleResult();
        return true;
    }


}