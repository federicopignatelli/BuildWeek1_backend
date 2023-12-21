package org.example;

import org.example.Entities.*;
import org.example.EntitiesDAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.Entities.ENUM.Tipologia_abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        // Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
        /*
         * DistributoreDAO dm = new DistributoreDAO(entityManager);
         * BigliettoDAO bid = new BigliettoDAO(entityManager);
         * 
         *//*
            * Distributore ds = new Distributorefisico("Padova", "FISICO", 0, 34,
            * "Gimmy S.N.C");
            *//*
               * 
               * Distributore da = new Distributorefisico("Milano", "FISICO", 0, 0,
               * "Biglietteria al crepuscolo' s.n.c");
               * dm.save(da);
               * Biglietto biglietto = new Biglietto("SESSANTAMINUTI", 1.70);
               * bid.create(biglietto, da);
               * System.out.println(da.toString());
               */

        // DistributoreDAO dm= new DistributoreDAO(entityManager);
        // Distributoreautomatico ds= new Distributoreautomatico("Padova", "AUTOMATICO",
        // 30, 34, "ABBONAMENTI");
        // dm.save(ds);
        // System.out.println(ds.toString());

//********************************************* MEZZI - TRATTE - VIAGGI *************************************************************************************
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
        TrattaDAO trattaDAO = new TrattaDAO(entityManager);
        ViaggioDAO viaggioDAO = new ViaggioDAO(entityManager);
        Tratta colosseo = new Tratta("Colosseo","Testaccio",19);
        Tratta eur = new Tratta("Termini","Trevi",9);
        Mezzo arpa1 = new Mezzo(MezzoType.AUTOBUS, 100);
        Mezzo arpa2 = new Mezzo(MezzoType.AUTOBUS, 170);
        Mezzo tram1 = new Mezzo(MezzoType.TRAM,140);
        Mezzo tram2 = new Mezzo(MezzoType.TRAM,110);
/*      ---->addMezzo     aggiunge un mezzo a una tratta    */
        eur.addMezzo(arpa1);
        eur.addMezzo(arpa2);
        eur.addMezzo(tram1);
        eur.addMezzo(tram2);
        trattaDAO.save(eur);
        mezzoDAO.save(tram1);
        mezzoDAO.save(tram2);
        mezzoDAO.save(arpa1);
        mezzoDAO.save(arpa2);

//        trattaDAO.save(colosseo);
//        trattaDAO.save(eur);
//        mezzoDAO.save(tram1);
//        mezzoDAO.save(tram2);
//        mezzoDAO.save(arpa1);
//        mezzoDAO.save(arpa2);


        Viaggio viaggio1 = new Viaggio();
        viaggio1.setMezzo(arpa1);
        viaggio1.aggiornaTargaMezzo();
        viaggio1.setTratta(eur);
        viaggio1.setOraPartenza(LocalDateTime.now());
        viaggio1.setOraArrivo(LocalDateTime.now().plusMinutes(38));
        viaggioDAO.save(viaggio1);

        Viaggio viaggio2 = new Viaggio();
        viaggio2.setMezzo(arpa1);
        viaggio2.aggiornaTargaMezzo();
        viaggio2.setTratta(eur);
        viaggio2.setOraPartenza(LocalDateTime.now().plusMinutes(60));
        viaggio2.setOraArrivo(LocalDateTime.now().plusMinutes(98));
        viaggioDAO.save(viaggio2);





//********************************************* fine  MEZZI - TRATTE - VIAGGI *************************************************************************************

        // DistributorefisicoDAO df= new DistributorefisicoDAO(entityManager);
        //
        // Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
        // df.save(ds);

        // creazione utente
        User user1 = new User("Gianni", "Morandi", LocalDate.of(1975, 10, 3), "Roma, via Bianchi");
        UserDAO userDAO = new UserDAO(entityManager);
        // userDAO.save(user1);

        User gianni = userDAO.findById(1);

        // creazione tessera
        Card card1 = new Card("023", LocalDate.of(2022, 10, 15), gianni);
        CardDAO cardDAO = new CardDAO(entityManager);
        // cardDAO.create(card1);

        Card cardGianni = cardDAO.findById(1);

        // creazione abbonamento
        Abbonamento abb1 = new Abbonamento(LocalDate.of(2023, 10, 15), Tipologia_abbonamento.MENSILE, 25.50,
                LocalDate.of(2023, 10, 15).plusMonths(1), cardGianni);
        AbbonamentoDAO abbDAO = new AbbonamentoDAO(entityManager);
        // abbDAO.create(abb1);

        Abbonamento abbGianni = abbDAO.findById(2);
        // verifica validità abbonamento
        boolean isValid = abbDAO.verificaValidita("023");
        System.out.println(isValid);

        System.out.println("ciaone");

        entityManager.close();
        managerFactory.close();
    }

}
