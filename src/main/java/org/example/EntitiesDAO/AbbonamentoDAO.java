package org.example.EntitiesDAO;

import org.example.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class AbbonamentoDAO {
    private final EntityManager entityManager;

    public AbbonamentoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Abbonamento abbonamento, Card card, Distributore distributore) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        if (distributore instanceof Distributorefisico) {
            abbonamento.setDistributorefisico((Distributorefisico) distributore);
        } else {
            abbonamento.setDistributoreautomatico((Distributoreautomatico) distributore);
        }
        abbonamento.setCard(card);
        entityManager.persist(abbonamento);
        if (transaction.isActive()) {
            transaction.commit();
        }

    }

    public Abbonamento findById(long id) {
        return entityManager.find(Abbonamento.class, id);
    }

    public void delete(long id) {
        Abbonamento found = entityManager.find(Abbonamento.class, id);
        if (found != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(found);
            transaction.commit();
        } else {
            System.err.println("Abbonamento non trovato!");
        }
    }

    //funzione per la verifica rapida della validità di un abbonamento
    // in base al numero di tessera

    public void verificaValidita(String cardNumber) {
        LocalDate today = LocalDate.now();
        String queryString = "SELECT a FROM Abbonamento a WHERE a.card.cardNumber = :cardNumber AND a" +
                ".dataScadenzaAbbondamento >= :today"; //filtra gli abbonamenti della tessera passata come parametro
        TypedQuery<Abbonamento> query = entityManager.createQuery(queryString, Abbonamento.class);
        query.setParameter("cardNumber", cardNumber);
        query.setParameter("today", today);

        //eseguo la query restituendo il risultato
        try {
            List<Abbonamento> list = query.getResultList();
            //se ci sono risultati è true
            if (!list.isEmpty()) {
                System.err.println("Abbonamento è scaduto il: " + list.get(0).getDataScadenzaAbbondamento());
                /*return true;*/
            } else {
                System.err.println("L'abbonamento è ancora valido");
            }
        } catch (NoResultException e) {
            //se non ci sono risultati è false
            System.err.println(e.getMessage());
        }
    }

    /*-------------------------------------------------------------------------------*/
    //QUESTO RITORNA GLI ABBONAMENTI(id) CHE SCADONO OGGI TRAMITE NUMERO CARTA

    public Card giveId(String cardNumber) {
        TypedQuery<Card> query = entityManager.createNamedQuery("getCard", Card.class);
        query.setParameter("cardNumber", cardNumber);
        List<Card> listCard = query.getResultList();
        return listCard.get(0);
    }

    public Long getAbbonamento(Long id) {
        TypedQuery<Long> abbqu = entityManager.createNamedQuery("getAbbonamentoByIdCard", Long.class);
        abbqu.setParameter("thisId", id);
        abbqu.setParameter("thisDate", LocalDate.now());
        List<Long> list = abbqu.getResultList();
        System.out.println(list.get(0).toString());
        return list.get(0);
    }

    public void getAbbScadutiByCard(String cardNumber) {
        getAbbonamento(giveId(cardNumber).getId());
    }
    /*----------------------------------------------------------*/

    // ABBONAMENTI CHE SONO SCADUTI
    public List<Abbonamento> getAbbonamentiScaduti() {
        TypedQuery<Abbonamento> query = entityManager.createNamedQuery("getAbbonamentiScaduti", Abbonamento.class);
        query.setParameter("thisDate", LocalDate.now().plusDays(1));
        List<Abbonamento> list = query.getResultList();
        list.forEach(System.out::println);
        return list;
    }
}