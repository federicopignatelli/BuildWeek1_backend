package org.example;

import org.example.Entities.*;
import org.example.Entities.ENUM.Tipologia_abbonamento;
import org.example.EntitiesDAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
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
        /*Distributore dis= new Distributorefisico("Via dei Gimmy", "FISICO","Biglietteria al tramonto s.n.c");
        distributoreDao.save(dis);
        User gimmy = new User("Gimmy","Gimmy", LocalDate.of(2001,7,23),"Via dei Gimmy");
        userDao.save(gimmy);
        Card card = new Card(LocalDate.now(), gimmy );
        cardDAO.create(card);
        Abbonamento abbonamento = new Abbonamento(LocalDate.now(), Tipologia_abbonamento.ANNUALE, 1000.00, LocalDate.now().plusYears(1));
        abbonamentoDao.create(abbonamento, card,dis);*/
        entityManager.close();
        managerFactory.close();

    }

}
