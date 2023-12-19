package org.example.EntitiesDAO;

import org.example.Entities.Abbonamento;
import org.example.Entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class AbbonamentoDAO {
    private final EntityManager entityManager;

    public AbbonamentoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Abbonamento abbonamento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(abbonamento);
        transaction.commit();
    }

    public Abbonamento findById(long id){
        return entityManager.find(Abbonamento.class, id);
    }

    public void delete(long id) {
        Abbonamento found = entityManager.find(Abbonamento.class, id);
        if(found != null){
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(found);
            transaction.commit();
        }else{
            System.err.println("Abbonamento non trovato!");
        }
    }

    //funzione per la verifica rapida della validità di un abbonamento
    // in base al numero di tessera

    public boolean verificaValidita(String cardNumber){
        LocalDate today = LocalDate.now();
        String queryString = "SELECT a FROM Abbonamento a WHERE a.card.cardNumber = :cardNumber AND :today BETWEEN a.dataemissioneAbbondamento AND a.dataScadenzaAbbondamento < :today"; //filtra gli abbonamenti della tessera passata come parametro
        TypedQuery<Abbonamento> query = entityManager.createQuery(queryString, Abbonamento.class);
        query.setParameter("cardNumber", cardNumber);
        query.setParameter("today", today );
        //eseguo la query restituendo il risultato
        Abbonamento abbonamento = query.getSingleResult();
        return true;
    }
}