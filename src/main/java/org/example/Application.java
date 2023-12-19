package org.example;

import org.example.Entities.Card;
import org.example.Entities.User;
import org.example.EntitiesDAO.CardDAO;
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

//        UserDAO ud= new UserDAO(entityManager);
//        CardDAO cd = new CardDAO(entityManager);
////        Card general = new Card("348576", LocalDate.of(2023, 9,8), LocalDate.of(2023, 10,8), marco);
////        User marco = new User("marco", "cielo", LocalDate.of(1998, 02,22), "via ciaone 33", general);

        System.out.println("ciaone");

        entityManager.close();
        managerFactory.close();
    }
}
