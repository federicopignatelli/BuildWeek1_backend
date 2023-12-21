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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//********************************************* MEZZI - TRATTE - VIAGGI - MANUTENZIONI *************************************************************************************
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
        TrattaDAO trattaDAO = new TrattaDAO(entityManager);
        ViaggioDAO viaggioDAO = new ViaggioDAO(entityManager);
        ManutenzioneDAO manutDao = new ManutenzioneDAO(entityManager);

        Tratta colosseo = new Tratta("Colosseo","Testaccio",19);
        Tratta eur = new Tratta("Termini","Trevi",9);
        Tratta pescara = new Tratta("Pescara","chieti",20);

        Mezzo arpa1 = new Mezzo(MezzoType.AUTOBUS, 100);
        Mezzo arpa2 = new Mezzo(MezzoType.AUTOBUS, 170);
        Mezzo tram1 = new Mezzo(MezzoType.TRAM,140);
        Mezzo tram2 = new Mezzo(MezzoType.TRAM,110);
/*      ---->addMezzo     aggiunge un mezzo a una tratta    */
//        eur.addMezzo(arpa1);
//        colosseo.addMezzo(tram2);
//        pescara.addMezzo(arpa2);
//
//        trattaDAO.save(eur);
//        trattaDAO.save(colosseo);
//        trattaDAO.save(pescara);
//
//        mezzoDAO.save(tram1);
//        mezzoDAO.save(tram2);
//        mezzoDAO.save(arpa1);
//        mezzoDAO.save(arpa2);
//
//        Viaggio viaggio1 = new Viaggio(arpa1,eur,LocalDateTime.now(),LocalDateTime.now().plusMinutes(50));
//        viaggioDAO.save(viaggio1);
//        Viaggio viaggio1b = new Viaggio(arpa1,pescara,LocalDateTime.now().plusMinutes(200),LocalDateTime.now().plusMinutes(312));
//        viaggioDAO.save(viaggio1b);
//        Viaggio viaggio1c = new Viaggio(arpa1,eur,LocalDateTime.now().plusMinutes(300),LocalDateTime.now().plusMinutes(342));
//        viaggioDAO.save(viaggio1c);
//        Viaggio viaggio2 = new Viaggio(tram2,colosseo,LocalDateTime.now(),LocalDateTime.now().plusMinutes(50));
//        viaggioDAO.save(viaggio2);
//        Viaggio viaggio3 = new Viaggio(arpa2,pescara,LocalDateTime.now(),LocalDateTime.now().plusMinutes(50));
//        viaggioDAO.save(viaggio3);
//
//
//        Manutenzione pistone = new Manutenzione(arpa1,"Sanauto",LocalDate.now(),LocalDate.now().plusDays(15),"Pistone rotto");
//        arpa1.addManutenzione(pistone);
//        manutDao.save(pistone);


        viaggioDAO.stampaTotTappeEtempoEffTratta();
//********************************************* fine  MEZZI - TRATTE - VIAGGI - MANUTENZIONI *************************************************************************************

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
