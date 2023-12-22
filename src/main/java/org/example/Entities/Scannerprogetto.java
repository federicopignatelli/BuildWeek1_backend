package org.example.Entities;
import org.example.Entities.*;
import org.example.EntitiesDAO.BigliettoDAO;
import org.example.EntitiesDAO.CardDAO;
import org.example.EntitiesDAO.DistributoreDAO;
import org.example.EntitiesDAO.UserDAO;

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

        System.out.println("Scegli distributore fisico o automatico? (scrivi fisico o automatico)");
        String tipodistributore = scannersistema.nextLine();;

        if (tipodistributore.equals("automatico")){
            System.out.println("Collegati al distributore");
            System.out.println("Inserisci dove ti trovi");
            String locationdistr = scannersistema.nextLine();
            Distributore distr = new Distributoreautomatico(locationdistr, "AUTOMATICO","BOTH" );
            dd.save(distr);

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
                                System.out.println("che tipo di biglietto vuoi creare: SESSANTEMINUTI.... ");
//                                String tipoprodotto = scannersistema.nextLine();
                                Biglietto biglietto = new Biglietto("SESSANTAMINUTI");
                                bd.save(biglietto, distr);
                                System.out.println("biglietto creato");
                            }

                            case "abbonamento" -> {

                            }
                        }
                    }
                    else {
                        System.out.println("Utente non trovato, reinserisci il tuo id utente");
                        //ripete il case "si" DA SISTEMARE
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
                }
            }
        }

        else{System.out.println("tipo distributore sbagliato");}

       managerFactory.close();
       scannersistema.close();
    }
}
