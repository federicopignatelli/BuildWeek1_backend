package org.example;

import org.example.Entities.Abbonamento;
import org.example.Entities.Card;
import org.example.Entities.ENUM.Tipologia_abbonamento;
import org.example.Entities.User;
import org.example.EntitiesDAO.AbbonamentoDAO;
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

//creazione utente
        User user1 = new User("Gianni", "Morandi", LocalDate.of(1975,10,3), "Roma, via Bianchi");
        UserDAO userDAO = new UserDAO(entityManager);
        //userDAO.save(user1);

        User gianni = userDAO.findById(1);

//creazione tessera
        Card card1 = new Card("023", LocalDate.of(2022,10,15), gianni);
        CardDAO cardDAO = new CardDAO(entityManager);
        //cardDAO.create(card1);

        Card cardGianni = cardDAO.findById(1);

//creazione abbonamento
        Abbonamento abb1 = new Abbonamento(LocalDate.of(2023,10,15), Tipologia_abbonamento.MENSILE, 25.50,LocalDate.of(2023,10,15).plusMonths(1), cardGianni  );
        AbbonamentoDAO abbDAO = new AbbonamentoDAO(entityManager);
        //abbDAO.create(abb1);

        Abbonamento abbGianni = abbDAO.findById(2);
//verifica validità abbonamento
        boolean isValid = abbDAO.verificaValidita("023");




        System.out.println("ciaone");

        entityManager.close();
        managerFactory.close();
    }




}
