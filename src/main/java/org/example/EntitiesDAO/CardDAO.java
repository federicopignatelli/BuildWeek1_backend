package org.example.EntitiesDAO;

import org.example.Entities.Card;
import org.example.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CardDAO {
    public final EntityManager em;

    public CardDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
    }

    public Card findById(Long id) {
        return em.find(Card.class, id);
    }

    public void findByIdandDelete(long id) {
        Card found = em.find(Card.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.err.println("Card non trovata!");
        }
    }

}
