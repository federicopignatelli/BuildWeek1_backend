package org.example;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.EntitiesDAO.AbbonamentoDAO;
import org.example.EntitiesDAO.BigliettoDAO;
import org.example.EntitiesDAO.DistributoreDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    public static Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        DistributoreDAO dm = new DistributoreDAO(entityManager);
        BigliettoDAO bid = new BigliettoDAO(entityManager);
        AbbonamentoDAO abb = new AbbonamentoDAO(entityManager);
        Biglietto biglietto;

        try {
            Distributore distributori_fisico = new Distributorefisico("Milano","FISICO","Biglietteria al Duomo");
            /*Distributore distributori_automatici = new Distributoreautomatico("Milano", "AUTOMATICO", "BOTH");*/
            Biglietto biglietto1 = new Biglietto("SESSANTAMINUTI");
            bid.save(biglietto1,distributori_fisico);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        bid.findAll("Biglietteria al Duomo");

        entityManager.close();
        managerFactory.close();

    }

}
