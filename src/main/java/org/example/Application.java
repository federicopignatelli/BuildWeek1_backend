package org.example;



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

                /*
                 * try {
                 * Distributore distributori_fisico = new
                 * Distributorefisico("Milano","FISICO","Biglietteria al Mare");
                 * Distributore distributori_automatici = new Distributoreautomatico("Milano",
                 * "AUTOMATICO", "BOTH");
                 * Biglietto biglietto1 = new Biglietto("SESSANTAMINUTI");
                 * //********************************************* MEZZI - TRATTE - VIAGGI -
                 * MANUTENZIONI
                 * *****************************************************************************
                 * ********
                 * MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
                 * TrattaDAO trattaDAO = new TrattaDAO(entityManager);
                 * ViaggioDAO viaggioDAO = new ViaggioDAO(entityManager);
                 * ManutenzioneDAO manutDao = new ManutenzioneDAO(entityManager);
                 * 
                 * Tratta colosseo = new Tratta("Colosseo","Testaccio",19);
                 * Tratta eur = new Tratta("Termini","Trevi",9);
                 * Tratta pescara = new Tratta("Pescara","chieti",20);
                 * 
                 * Mezzo arpa1 = new Mezzo(MezzoType.AUTOBUS, 100);
                 * Mezzo arpa2 = new Mezzo(MezzoType.AUTOBUS, 170);
                 * Mezzo tram1 = new Mezzo(MezzoType.TRAM,140);
                 * Mezzo tram2 = new Mezzo(MezzoType.TRAM,110);
                 * /* ---->addMezzo aggiunge un mezzo a una tratta
                 */
                // eur.addMezzo(arpa1);
                // colosseo.addMezzo(tram2);
                // pescara.addMezzo(arpa2);
                //
                // trattaDAO.save(eur);
                // trattaDAO.save(colosseo);
                // trattaDAO.save(pescara);
                //
                // mezzoDAO.save(tram1);
                // mezzoDAO.save(tram2);
                // mezzoDAO.save(arpa1);
                // mezzoDAO.save(arpa2);
                //
                // Viaggio viaggio1 = new
                // Viaggio(arpa1,eur,LocalDateTime.now(),LocalDateTime.now().plusMinutes(50));
                // viaggioDAO.save(viaggio1);
                // Viaggio viaggio1b = new
                // Viaggio(arpa1,pescara,LocalDateTime.now().plusMinutes(200),LocalDateTime.now().plusMinutes(312));
                // viaggioDAO.save(viaggio1b);
                // Viaggio viaggio1c = new
                // Viaggio(arpa1,eur,LocalDateTime.now().plusMinutes(300),LocalDateTime.now().plusMinutes(342));
                // viaggioDAO.save(viaggio1c);
                // Viaggio viaggio2 = new
                // Viaggio(tram2,colosseo,LocalDateTime.now(),LocalDateTime.now().plusMinutes(50));
                // viaggioDAO.save(viaggio2);
                // Viaggio viaggio3 = new
                // Viaggio(arpa2,pescara,LocalDateTime.now(),LocalDateTime.now().plusMinutes(50));
                // viaggioDAO.save(viaggio3);
                //
                //
                // Manutenzione pistone = new
                // Manutenzione(arpa2,"Sanauto",LocalDate.now(),LocalDate.now().plusDays(15),"Pistone
                // rotto");
                // arpa2.addManutenzione(pistone);
                // manutDao.save(pistone);

               
                viaggioDAO.stampaTotTappeEtempoEffTratta();

                Long mezzoId = 7L;
                mezzoDAO.stampaInfoManutenzioneMezzo(mezzoId);
                // ********************************************* fine MEZZI - TRATTE - VIAGGI -
                // MANUTENZIONI
                // *************************************************************************************
                try {
                        Distributore distributori_fisico = new Distributorefisico("Firenze", "FISICO",
                                        "Biglietti dai fratelli Gimmy");
                        /*
                         * Distributore distributori_automatici = new Distributoreautomatico("Milano",
                         * "AUTOMATICO", "BOTH");
                         */
                        Biglietto biglietto1 = new Biglietto("SESSANTAMINUTI");
                        bid.save(biglietto1, distributori_fisico);
                        // try {
                        // /*Distributore distributori_fisico = new
                        // Distributorefisico("Milano","FISICO","BigliettiANDBiglietti");*/
                        // Distributore distributori_automatici = new Distributoreautomatico("Milano",
                        // "AUTOMATICO", "BOTH");
                        //
                        //
                        // bid.save(biglietto1, distributori_automatici);

                        bid.save(biglietto1, distributori_fisico);

                } catch (Exception e) {
                        logger.error(e.getMessage());
                        e.printStackTrace();
                }

                bid.timbraBiglietto(255L);

                /*
                 * Abbonamento ab = new Abbonamento(LocalDate.now(), "MENSILE", 50.50,
                 * LocalDate.now().plusMonths(1));
                 * User gimmy= new User("Gimmy", "DellaMontagna", LocalDate.of(1880,2,23),
                 * "Via dei Gimmy GimmyA");
                 * user.save(gimmy);
                 * Card card = new Card(LocalDate.now(), gimmy);
                 * cardDAO.create(card);
                 */

                /* abb.verificaValidita("54378455"); */
                /*
                 * Distributore distributori_fisico = new
                 * Distributorefisico("Firenze","FISICO","Biglietti dai fratelli Gimmy");
                 * dm.save(distributori_fisico);
                 * abb.create(ab , card , distributori_fisico );
                 */

                bid.findAll("Biglietteria al Mare");

                /*
                 * System.out.println("Inserisci il codice macchina: ");
                 * String codiceMacchina = scan.nextLine();
                 */

                /* bid.findCountTicketByMezzo(MezzoType.AUTOBUS); */

                /*
                 * MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
                 * TrattaDAO trattaDAO = new TrattaDAO(entityManager);
                 * ViaggioDAO viaggioDAO = new ViaggioDAO(entityManager);
                 * Tratta colosseo = new Tratta("Colosseo", "Testaccio", 19);
                 * Tratta eur = new Tratta("Termini", "Trevi", 9);
                 * Tratta pescara = new Tratta("Pescara", "chieti", 20);
                 * 
                 * Mezzo arpa1 = new Mezzo(MezzoType.AUTOBUS, 100);
                 * Mezzo arpa2 = new Mezzo(MezzoType.AUTOBUS, 170);
                 * Mezzo tram1 = new Mezzo(MezzoType.TRAM, 140);
                 * Mezzo tram2 = new Mezzo(MezzoType.TRAM, 110);
                 *//* ---->addMezzo aggiunge un mezzo a una tratta *//*
                                                                      * // eur.addMezzo(arpa1);
                                                                      * // colosseo.addMezzo(tram2);
                                                                      * // pescara.addMezzo(arpa2);
                                                                      * //
                                                                      * // trattaDAO.save(eur);
                                                                      * // trattaDAO.save(colosseo);
                                                                      * // trattaDAO.save(pescara);
                                                                      * //
                                                                      * // mezzoDAO.save(tram1);
                                                                      * // mezzoDAO.save(tram2);
                                                                      * // mezzoDAO.save(arpa1);
                                                                      * // mezzoDAO.save(arpa2);
                                                                      * //
                                                                      * // Viaggio viaggio1 = new
                                                                      * // Viaggio(arpa1,eur,LocalDateTime.now(),
                                                                      * LocalDateTime.now().plusMinutes(50));
                                                                      * // viaggioDAO.save(viaggio1);
                                                                      * // Viaggio viaggio1b = new
                                                                      * // Viaggio(arpa1,pescara,LocalDateTime.now().
                                                                      * plusMinutes(200),LocalDateTime.now().plusMinutes
                                                                      * (312));
                                                                      * // viaggioDAO.save(viaggio1b);
                                                                      * // Viaggio viaggio1c = new
                                                                      * // Viaggio(arpa1,eur,LocalDateTime.now().
                                                                      * plusMinutes(300),LocalDateTime.now().plusMinutes
                                                                      * (342));
                                                                      * // viaggioDAO.save(viaggio1c);
                                                                      * // Viaggio viaggio2 = new
                                                                      * // Viaggio(tram2,colosseo,LocalDateTime.now(),
                                                                      * LocalDateTime.now().plusMinutes(50));
                                                                      * // viaggioDAO.save(viaggio2);
                                                                      * // Viaggio viaggio3 = new
                                                                      * // Viaggio(arpa2,pescara,LocalDateTime.now(),
                                                                      * LocalDateTime.now().plusMinutes(50));
                                                                      * // viaggioDAO.save(viaggio3);
                                                                      */

                /* viaggioDAO.stampaTotTappeEtempoEffTratta(); */

                // DistributorefisicoDAO df= new DistributorefisicoDAO(entityManager);
                //
                // Distributorefisico ds= new Distributorefisico("Padova", "FISICO", 30, 34);
                // df.save(ds);

                // creazione utente
                /*
                 * User user1 = new User("Gianni", "Morandi", LocalDate.of(1975, 10, 3),
                 * "Roma, via Bianchi");
                 * UserDAO userDAO = new UserDAO(entityManager);
                 * // userDAO.save(user1);
                 * 
                 * User gianni = userDAO.findById(1);
                 * 
                 * // creazione tessera
                 * Card card1 = new Card("023", LocalDate.of(2022, 10, 15), gianni);
                 * CardDAO cardDAO = new CardDAO(entityManager);
                 * // cardDAO.create(card1);
                 * 
                 * Card cardGianni = cardDAO.findById(1);
                 * 
                 * // creazione abbonamento
                 * Abbonamento abb1 = new Abbonamento(LocalDate.of(2023, 10, 15),
                 * Tipologia_abbonamento.MENSILE, 25.50,
                 * LocalDate.of(2023, 10, 15).plusMonths(1), cardGianni);
                 * AbbonamentoDAO abbDAO = new AbbonamentoDAO(entityManager);
                 * // abbDAO.create(abb1);
                 * 
                 * Abbonamento abbGianni = abbDAO.findById(2);
                 * // verifica validità abbonamento
                 * boolean isValid = abbDAO.verificaValidita("023");
                 * System.out.println(isValid);
                 */
                // User user1 = new User("Gianni", "Morandi", LocalDate.of(1975, 10, 3), "Roma,
                // via Bianchi");
                // UserDAO userDAO = new UserDAO(entityManager);
                // // userDAO.save(user1);
                //
                // User gianni = userDAO.findById(1);
                //
                // // creazione tessera
                // Card card1 = new Card("023", LocalDate.of(2022, 10, 15), gianni);
                // CardDAO cardDAO = new CardDAO(entityManager);
                // // cardDAO.create(card1);
                //
                // Card cardGianni = cardDAO.findById(1);
                //
                // // creazione abbonamento
                // Abbonamento abb1 = new Abbonamento(LocalDate.of(2023, 10, 15),
                // Tipologia_abbonamento.MENSILE, 25.50,
                // LocalDate.of(2023, 10, 15).plusMonths(1), cardGianni);
                // AbbonamentoDAO abbDAO = new AbbonamentoDAO(entityManager);
                // // abbDAO.create(abb1);
                //
                // Abbonamento abbGianni = abbDAO.findById(2);
                // // verifica validità abbonamento
                // boolean isValid = abbDAO.verificaValidita("023");
                // System.out.println(isValid);*/

                System.out.println("ciaone");

                entityManager.close();
                managerFactory.close();

        }

}
