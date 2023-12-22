package org.example;

import org.example.Entities.*;
import org.example.EntitiesDAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    public static Logger logger = LoggerFactory.getLogger(Application.class);
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        DistributoreDAO dm = new DistributoreDAO(entityManager);
        BigliettoDAO bid = new BigliettoDAO(entityManager);
        AbbonamentoDAO abb = new AbbonamentoDAO(entityManager);
        Biglietto biglietto;


//********************************************* MEZZI - TRATTE - VIAGGI - MANUTENZIONI *************************************************************************************
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
        TrattaDAO trattaDAO = new TrattaDAO(entityManager);
        ViaggioDAO viaggioDAO = new ViaggioDAO(entityManager);
        ManutenzioneDAO manutDao = new ManutenzioneDAO(entityManager);
//
//        Tratta colosseo = new Tratta("Colosseo","Testaccio",19);
//        Tratta eur = new Tratta("Termini","Trevi",9);
//        Tratta pescara = new Tratta("Pescara","chieti",20);
//
//        Mezzo arpa1 = new Mezzo(MezzoType.AUTOBUS);
//        Mezzo arpa2 = new Mezzo(MezzoType.AUTOBUS);
//        Mezzo tram1 = new Mezzo(MezzoType.TRAM);
//        Mezzo tram2 = new Mezzo(MezzoType.TRAM);
///*      ---->addMezzo     aggiunge un mezzo a una tratta    */
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
//        Manutenzione pistone = new Manutenzione(arpa2,"Sanauto",LocalDate.now(),LocalDate.now().plusDays(15),"Pistone rotto");
//        arpa2.addManutenzione(pistone);
//        manutDao.save(pistone);
//
//
//        viaggioDAO.stampaTotTappeEtempoEffTratta();
//
//        Long mezzoId = 7L;
//        mezzoDAO.stampaInfoManutenzioneMezzo(mezzoId);
        Scanner scanner = new Scanner(System.in);

        // Creazione e salvataggio delle tratte
        System.out.println("Inserisci i dettagli della tratta (formato: origine, destinazione, durata):");
        String[] trattaInput = scanner.nextLine().split(",");
        Tratta tratta = new Tratta(trattaInput[0].trim(), trattaInput[1].trim(), Integer.parseInt(trattaInput[2].trim()));
        trattaDAO.save(tratta);

        // Creazione e salvataggio dei mezzi
        System.out.println("Inserisci il tipo di mezzo (AUTOBUS, TRAM):");
        MezzoType mezzoType = MezzoType.valueOf(scanner.nextLine().toUpperCase());
        Mezzo mezzo = new Mezzo(mezzoType);
        mezzoDAO.save(mezzo);

        // Assegnazione di un mezzo a una tratta
        tratta.addMezzo(mezzo);
        trattaDAO.save(tratta); // Assumendo che esista un metodo di aggiornamento

        // Creazione e salvataggio di un viaggio
        System.out.println("Inserisci l'ora di partenza e di arrivo del viaggio (formato yyyy-MM-ddTHH:mm):");
        String oraPartenzaStr = scanner.nextLine();
        String oraArrivoStr = scanner.nextLine();
        LocalDateTime oraPartenza = LocalDateTime.parse(oraPartenzaStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime oraArrivo = LocalDateTime.parse(oraArrivoStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Viaggio viaggio = new Viaggio(mezzo, tratta, oraPartenza, oraArrivo);
        viaggioDAO.save(viaggio);

        // Creazione e salvataggio di una manutenzione
        System.out.println("Inserisci i dettagli della manutenzione (formato: officina, descrizione, giorni di durata):");
        String[] manutInput = scanner.nextLine().split(",");
        LocalDate dataInizio = LocalDate.now();
        LocalDate dataFine = dataInizio.plusDays(Long.parseLong(manutInput[2].trim()));
        Manutenzione manutenzione = new Manutenzione(mezzo, manutInput[0].trim(), dataInizio, dataFine, manutInput[1].trim());
        mezzo.addManutenzione(manutenzione);
        manutDao.save(manutenzione);

        // Stampa delle informazioni di viaggio e manutenzione
        viaggioDAO.stampaTotTappeEtempoEffTratta();
        mezzoDAO.stampaInfoManutenzioneMezzo(mezzo.getMezzoId());

        // Chiusura dello Scanner e dell'EntityManager
        scanner.close();
//********************************************* fine  MEZZI - TRATTE - VIAGGI - MANUTENZIONI *************************************************************************************
        try {
            Distributore distributori_fisico = new Distributorefisico("Firenze","FISICO","Biglietti dai fratelli Gimmy");
            /*Distributore distributori_automatici = new Distributoreautomatico("Milano", "AUTOMATICO", "BOTH");*/
            Biglietto biglietto1 = new Biglietto("SESSANTAMINUTI");
            bid.save(biglietto1,distributori_fisico);
//        try {
//              /*Distributore distributori_fisico = new
//              Distributorefisico("Milano","FISICO","BigliettiANDBiglietti");*/
//            Distributore distributori_automatici = new Distributoreautomatico("Milano", "AUTOMATICO", "BOTH");
//
//
//            bid.save(biglietto1, distributori_automatici);

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        bid.findAll("Biglietti dai fratelli Gimmy");


        /*System.out.println("Inserisci il codice macchina: ");
        String codiceMacchina = scan.nextLine();*/


        bid.findCountTicketByMezzo(MezzoType.AUTOBUS);



        // DistributorefisicoDAO df= new DistributorefisicoDAO(entityManager);
        //
        // Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
        // df.save(ds);

        // creazione utente
//        User user1 = new User("Gianni", "Morandi", LocalDate.of(1975, 10, 3), "Roma, via Bianchi");
//        UserDAO userDAO = new UserDAO(entityManager);
//        // userDAO.save(user1);
//
//        User gianni = userDAO.findById(1);
//
//        // creazione tessera
//        Card card1 = new Card("023", LocalDate.of(2022, 10, 15), gianni);
//        CardDAO cardDAO = new CardDAO(entityManager);
//        // cardDAO.create(card1);
//
//        Card cardGianni = cardDAO.findById(1);
//
//        // creazione abbonamento
//        Abbonamento abb1 = new Abbonamento(LocalDate.of(2023, 10, 15), Tipologia_abbonamento.MENSILE, 25.50,
//                LocalDate.of(2023, 10, 15).plusMonths(1), cardGianni);
//        AbbonamentoDAO abbDAO = new AbbonamentoDAO(entityManager);
//        // abbDAO.create(abb1);
//
//        Abbonamento abbGianni = abbDAO.findById(2);
//        // verifica validità abbonamento
//        boolean isValid = abbDAO.verificaValidita("023");
//        System.out.println(isValid);*/

        System.out.println("ciaone");

        entityManager.close();
        managerFactory.close();

    }

}

