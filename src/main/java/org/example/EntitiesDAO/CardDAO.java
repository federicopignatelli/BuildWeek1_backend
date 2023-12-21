package org.example.EntitiesDAO;

import org.example.Entities.Card;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

    public Card findById(long id){
        return em.find(Card.class, id);
    }

    public void delete(long id) {
        Card found = em.find(Card.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        }else{
            System.err.println("Tessera non trovata!");
        }
    }

}
