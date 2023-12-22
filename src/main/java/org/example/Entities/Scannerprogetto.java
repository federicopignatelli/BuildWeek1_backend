package org.example.Entities;
import org.example.Entities.*;
import org.example.EntitiesDAO.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class Scannerprogetto {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    static Scanner scannersistema = new Scanner(System.in);
    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        DistributoreDAO dd = new DistributoreDAO(entityManager);
        UserDAO ud = new UserDAO(entityManager);
        CardDAO cd = new CardDAO(entityManager);
        BigliettoDAO bd = new BigliettoDAO(entityManager);
        AbbonamentoDAO ad = new AbbonamentoDAO(entityManager);

        System.out.println("Scegli distributore fisico o automatico? (scrivi fisico o automatico)");
        String tipodistributore = scannersistema.nextLine();;

        if (tipodistributore.equals("automatico")){
            System.out.println("Collegati al distributore");
            System.out.println("Inserisci dove ti trovi");
            String locationdistr = scannersistema.nextLine();
            Distributore distr = new Distributoreautomatico(locationdistr, "AUTOMATICO","BOTH" );

            System.out.println("Ciao, sei già nostro cliente? (rispondere si o no)");
            String seigiacliente = scannersistema.nextLine();

            switch (seigiacliente.toLowerCase()) {
                case "si" -> {
                    System.out.println("inserisci il tuo numero tessera");
                    String numtessera = scannersistema.nextLine();
                    if (cd.getUserByUserByCard(numtessera)){
                        //utente trovato quindi passa alla prossima operazione

                        System.out.println("vuoi comprare un biglietto o un abbonamento? (digitare abbonamento o biglietto)");
                        String tipoprodotto = scannersistema.nextLine();

                        switch (tipoprodotto.toLowerCase()) {
                            case "biglietto" -> {
                                System.out.println("che tipo di biglietto vuoi creare? inserisci: SESSANTAMINUTI, NOVANTAMINUTI, CENTOVENTIMINUTI, GIORNALIERO.");
                                String tipobiglietto = scannersistema.nextLine();
                                Biglietto biglietto = new Biglietto(tipobiglietto);
                                bd.save(biglietto, distr);
                                System.out.println("biglietto creato");
                            }

                            case "abbonamento" -> {
                                System.out.println("che tipo di abbonamento vuoi creare? inserisci: SETTIMANALE, MENSILE, SEMESTRALE, ANNUALE.");
                                String tipoabbonamento = scannersistema.nextLine();
                                Abbonamento abbonamento = new Abbonamento(LocalDate.now(), tipoabbonamento, 5.5, LocalDate.now());
                                System.out.println("Abbonamento creato:"+abbonamento);
                            }
                        }
                    }
                    else {
                        System.out.println("Utente non trovato, reinserisci il tuo id utente");
                    }
                }
                case "no" -> {
                    System.out.println("Creiamo un nuovo profilo");
                    System.out.println("Inserisci il tuo nome");
                    String Nome = scannersistema.nextLine();
                    System.out.println("Inserisci il tuo cognome");
                    String Cognome = scannersistema.nextLine();
                    System.out.println("Inserisci la tua data di nascità in questo formato (dd/MM/yyyy)");
                    String DataNascitaInserita = scannersistema.nextLine();
                    DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate DataDiNascita = LocalDate.parse(DataNascitaInserita, DateFormat);
                    System.out.println("Inserisci il tuo indirizzo");
                    String Indirizzo = scannersistema.nextLine();

                    User user = new User(Nome, Cognome, DataDiNascita, Indirizzo);
                    ud.save(user);
                    System.out.println("Il tuo profilo è stato salvato correttamente");
                    Card card = new Card(LocalDate.now(), user);
                    cd.create(card);
                    System.out.println("La tua tessera è stata creata correttamente");

                    System.out.println("i tuoi dati del profilo " + user.toString());
                    System.out.println("i tuoi dati della tessera " + card.toString());


                    //utente creato quindi passa alla prossima operazione

                    System.out.println("vuoi comprare un biglietto o un abbonamento? (digitare abbonamento o biglietto)");
                    String tipoprodotto = scannersistema.nextLine();

                    switch (tipoprodotto.toLowerCase()) {
                            case "biglietto" -> {
                                System.out.println("che tipo di biglietto vuoi creare? inserisci: SESSANTAMINUTI, NOVANTAMINUTI, CENTOVENTIMINUTI, GIORNALIERO.");
                                String tipobiglietto = scannersistema.nextLine();
                                Biglietto biglietto = new Biglietto(tipobiglietto);
                                bd.save(biglietto, distr);
                                System.out.println("biglietto creato");
                            }

                            case "abbonamento" -> {
                                System.out.println("che tipo di abbonamento vuoi creare? inserisci: SETTIMANALE, MENSILE, SEMESTRALE, ANNUALE.");
                                String tipoabbonamento = scannersistema.nextLine();
                                Abbonamento abbonamento = new Abbonamento(LocalDate.now(), tipoabbonamento, 5.5, LocalDate.now());
                                System.out.println("Abbonamento creato:"+abbonamento);
                            }
                    }


                }
            }
        }


        else if (tipodistributore.equals("fisico")){
            System.out.println("Collegati al distributore");
            System.out.println("Inserisci dove ti trovi");
            String locationdistr = scannersistema.nextLine();
            Distributore distr = new Distributorefisico(locationdistr, "AUTOMATICO","BOTH" );

            System.out.println("Ciao, sei già nostro cliente? (rispondere si o no)");
            String seigiacliente = scannersistema.nextLine();

            switch (seigiacliente.toLowerCase()) {
                case "si" -> {
                    System.out.println("inserisci il tuo numero tessera");
                    String numtessera = scannersistema.nextLine();
                    if (cd.getUserByUserByCard(numtessera)){
                        //utente trovato quindi passa alla prossima operazione

                        System.out.println("vuoi comprare un biglietto o un abbonamento? (digitare abbonamento o biglietto)");
                        String tipoprodotto = scannersistema.nextLine();

                        switch (tipoprodotto.toLowerCase()) {
                            case "biglietto" -> {
                                System.out.println("che tipo di biglietto vuoi creare? inserisci: SESSANTAMINUTI, NOVANTAMINUTI, CENTOVENTIMINUTI, GIORNALIERO.");
                                String tipobiglietto = scannersistema.nextLine();
                                Biglietto biglietto = new Biglietto(tipobiglietto);
                                bd.save(biglietto, distr);
                                System.out.println("biglietto creato");
                            }

                            case "abbonamento" -> {
                                System.out.println("che tipo di abbonamento vuoi creare? inserisci: SETTIMANALE, MENSILE, SEMESTRALE, ANNUALE.");
                                String tipoabbonamento = scannersistema.nextLine();
                                Abbonamento abbonamento = new Abbonamento(LocalDate.now(), tipoabbonamento, 5.5, LocalDate.now());
                                System.out.println("Abbonamento creato:"+abbonamento);
                            }
                        }
                    }
                    else {
                        System.out.println("Utente non trovato, reinserisci il tuo id utente");
                    }
                }
                case "no" -> {
                    System.out.println("Creiamo un nuovo profilo");
                    System.out.println("Inserisci il tuo nome");
                    String Nome = scannersistema.nextLine();
                    System.out.println("Inserisci il tuo cognome");
                    String Cognome = scannersistema.nextLine();
                    System.out.println("Inserisci la tua data di nascità in questo formato (dd/MM/yyyy)");
                    String DataNascitaInserita = scannersistema.nextLine();
                    DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate DataDiNascita = LocalDate.parse(DataNascitaInserita, DateFormat);
                    System.out.println("Inserisci il tuo indirizzo");
                    String Indirizzo = scannersistema.nextLine();

                    User user = new User(Nome, Cognome, DataDiNascita, Indirizzo);
                    ud.save(user);
                    System.out.println("Il tuo profilo è stato salvato correttamente");
                    Card card = new Card(LocalDate.now(), user);
                    cd.create(card);
                    System.out.println("La tua tessera è stata creata correttamente");

                    System.out.println("i tuoi dati del profilo " + user.toString());
                    System.out.println("i tuoi dati della tessera " + card.toString());


                    //utente creato quindi passa alla prossima operazione

                    System.out.println("vuoi comprare un biglietto o un abbonamento? (digitare abbonamento o biglietto)");
                    String tipoprodotto = scannersistema.nextLine();

                    switch (tipoprodotto.toLowerCase()) {
                        case "biglietto" -> {
                            System.out.println("che tipo di biglietto vuoi creare? inserisci: SESSANTAMINUTI, NOVANTAMINUTI, CENTOVENTIMINUTI, GIORNALIERO.");
                            String tipobiglietto = scannersistema.nextLine();
                            Biglietto biglietto = new Biglietto(tipobiglietto);
                            bd.save(biglietto, distr);
                            System.out.println("biglietto creato");
                        }

                        case "abbonamento" -> {
                            System.out.println("che tipo di abbonamento vuoi creare? inserisci: SETTIMANALE, MENSILE, SEMESTRALE, ANNUALE.");
                            String tipoabbonamento = scannersistema.nextLine();
                            Abbonamento abbonamento = new Abbonamento(LocalDate.now(), tipoabbonamento, 5.5, LocalDate.now());
                            System.out.println("Abbonamento creato:"+abbonamento);
                        }
                    }


                }
            }
        }

        else{System.out.println("tipo distributore sbagliato");}

       managerFactory.close();
       scannersistema.close();
    }
}
