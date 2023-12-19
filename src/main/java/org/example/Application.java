package org.example;

import org.example.Entities.Card;
import org.example.Entities.User;
import org.example.EntitiesDAO.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    public static final EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("bw1812");
    public static void main(String[] args) {
EntityManager entityManager= managerFactory.createEntityManager();
//        DistributoreDAO dm= new DistributoreDAO(entityManager);
//        Distributoreautomatico ds= new Distributoreautomatico("Padova", "AUTOMATICO", 30, 34, "ABBONAMENTI");
//        dm.save(ds);
//        System.out.println(ds.toString());

//        DistributorefisicoDAO df= new DistributorefisicoDAO(entityManager);
//
//        Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
//        df.save(ds);

/*        UserDAO ud= new UserDAO(entityManager);
        User marco = new User("marco", "pezza", LocalDate.of(1998, 1, 1),"via lorenzo gasperi 2");

        System.out.println("ciaone");*/

        entityManager.close();
        managerFactory.close();
    }
}
