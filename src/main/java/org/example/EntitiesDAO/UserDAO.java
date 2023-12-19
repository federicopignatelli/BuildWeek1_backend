package org.example.EntitiesDAO;

import org.example.Entities.Tratta;
import org.example.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    public final EntityManager em;


    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    public User findById(long id){
        return em.find(User.class, id);
    }

    public void findByIdandDelete(long id){
        User found = em.find(User.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        }else{
            System.err.println("User non trovato!");
        }
    }

}
