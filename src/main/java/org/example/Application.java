package org.example;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.EntitiesDAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;

public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    public static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        CardDAO cardDAO = new CardDAO(entityManager);
        UserDAO userDao = new UserDAO(entityManager);
        AbbonamentoDAO abbonamentoDao = new AbbonamentoDAO(entityManager);
        BigliettoDAO bigliettoDao = new BigliettoDAO(entityManager);
        DistributoreDAO distributoreDao = new DistributoreDAO(entityManager);
        MezzoDAO mezzoDao = new MezzoDAO(entityManager);
        TrattaDAO trattaDao = new TrattaDAO(entityManager);


        Distributore distributore = new Distributoreautomatico("Milano", "AUTOMATICO","ABBONAMENTI");
        distributoreDao.save(distributore);
        Biglietto biglietto = new Biglietto("GIORNALIERO", 1.50);
        bigliettoDao.creaBiglietto(biglietto, distributore);

        entityManager.close();
        managerFactory.close();

    }

}
