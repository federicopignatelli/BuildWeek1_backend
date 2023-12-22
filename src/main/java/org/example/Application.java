package org.example;

<<<<<<<HEAD

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.Entities.*;
import org.example.EntitiesDAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Application {
        public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
        public static Logger logger = LoggerFactory.getLogger(Application.class);
        static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

                EntityManager entityManager = managerFactory.createEntityManager();
                DistributoreDAO dm = new DistributoreDAO(entityManager);
                BigliettoDAO bid = new BigliettoDAO(entityManager);
                AbbonamentoDAO abb = new AbbonamentoDAO(entityManager);
                UserDAO user = new UserDAO(entityManager);
                CardDAO cardDAO = new CardDAO(entityManager);
                Biglietto biglietto;


 

                entityManager.close();
                managerFactory.close();

        }
    }
