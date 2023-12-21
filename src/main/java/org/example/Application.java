package org.example;

import org.example.Entities.*;
import org.example.Entities.ENUM.Tipologia_abbonamento;
import org.example.EntitiesDAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.Entities.ENUM.Tipologia_abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Application {
        public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
        public static Logger logger = LoggerFactory.getLogger(Application.class);

        public static void main(String[] args) {
                EntityManager entityManager = managerFactory.createEntityManager();


                entityManager.close();
                managerFactory.close();

        }

}
