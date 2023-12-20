package org.example;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.Entities.ENUM.Tipologia_biglietto;
import org.example.EntitiesDAO.BigliettoDAO;
import org.example.EntitiesDAO.DistributoreDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");

    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        // Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
        DistributoreDAO dm = new DistributoreDAO(entityManager);
        BigliettoDAO bid = new BigliettoDAO(entityManager);

        /*Distributore ds = new Distributorefisico("Padova", "FISICO", 0, 34, "Gimmy S.N.C");*/

        Distributore da = new Distributorefisico("Milano", "FISICO", 0, 0, "Biglietteria al Santo' s.n.c");
        dm.save(da);
        Biglietto biglietto = new Biglietto("SESSANTAMINUTI", 1.70, LocalDate.of(2023, 12, 20));
        bid.create(biglietto, da);
        System.out.println(da.toString());

        entityManager.close();
        managerFactory.close();
    }
}
