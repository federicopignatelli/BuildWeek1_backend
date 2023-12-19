package org.example.EntitiesDAO;

import org.example.Entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TrattaDAO {
    public final EntityManager em;


    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(tratta);
        transaction.commit();
    }

    public Tratta findById(long id){
        return em.find(Tratta.class, id);
    }

    public void findByIdandDelete(long id){
        Tratta found = em.find(Tratta.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        }else{
            System.err.println("Tratta non trovata!");
        }
    }
}
