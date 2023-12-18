package org.example;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.EntitiesDAO.DistributoreDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static final EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("bw1812");
    public static void main(String[] args) {
        EntityManager entityManager= managerFactory.createEntityManager();
        DistributoreDAO dm= new DistributoreDAO(entityManager);
        Distributoreautomatico ds= new Distributoreautomatico("Padova", "AUTOMATICO", 30, 34, "ABBONAMENTI");
        dm.save(ds);
        /*System.out.println(ds.toString());*/

        entityManager.close();
        managerFactory.close();
    }
}
