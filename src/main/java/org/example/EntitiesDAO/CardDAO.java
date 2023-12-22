package org.example.EntitiesDAO;

import org.example.Entities.Card;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class CardDAO {
    EntityManager em;

    public CardDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
    }

    public Card findById(long id) {
        return em.find(Card.class, id);
    }

    public void delete(long id) {
        Card found = em.find(Card.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.err.println("Tessera non trovata!");
        }
    }

    public boolean getUserByUserByCard(String cardNumber) {
        TypedQuery<Card> query = em.createNamedQuery("getCard", Card.class);
        query.setParameter("cardNumber", cardNumber);
        List<Card> cards = query.getResultList();

        if (cards.isEmpty()) {
            System.out.println("User non presente");
            return false;
        } else {
            System.out.println("Utente Trovato: " + cards.get(0).toString());
            return true;
        }
    }

    public void scadenzaTessera(String code) {
        TypedQuery<Card> query = em.createNamedQuery("getCard", Card.class);
        query.setParameter("cardNumber", code);
        List <Card> card = query.getResultList();
        if (card.isEmpty()) {
            System.err.println("Tessera non trovata!");
        }else if (LocalDate.now().isAfter(card.get(0).getIssueDate())) {
            System.err.println("Tessera scaduta il " + card.get(0).getStopDate());
        } else
        {
            System.out.println("Tessera valida fino al " + card.get(0).getIssueDate());
        }

    }

}


