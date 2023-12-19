package org.example.EntitiesDAO;

import org.example.Entities.Mezzo;
import org.example.Entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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

    public List<Object[]> countMezziPerTratta (long id){
        TypedQuery<Object[]> query = em.createNamedQuery("Mezzo.countMezziPerTratta", Object[].class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
