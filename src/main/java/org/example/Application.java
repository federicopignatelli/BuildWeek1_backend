package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    private static Logger logger= LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        // Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
        /*DistributoreDAO dm = new DistributoreDAO(entityManager);
        BigliettoDAO bid = new BigliettoDAO(entityManager);

        *//*Distributore ds = new Distributorefisico("Padova", "FISICO", 0, 34, "Gimmy S.N.C");*//*

        Distributore da = new Distributorefisico("Milano", "FISICO", 0, 0, "Biglietteria al crepuscolo' s.n.c");
        dm.save(da);
        Biglietto biglietto = new Biglietto("SESSANTAMINUTI", 1.70);
        bid.create(biglietto, da);
        System.out.println(da.toString());*/



        entityManager.close();
        managerFactory.close();
    }
}
