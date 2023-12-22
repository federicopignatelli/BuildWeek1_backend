package org.example;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributorefisico;
import org.example.EntitiesDAO.AbbonamentoDAO;
import org.example.EntitiesDAO.BigliettoDAO;
import org.example.EntitiesDAO.CardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;
import java.util.Scanner;


public class Demo {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    public static Logger logger = LoggerFactory.getLogger(Application.class);
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        CardDAO cardDAO = new CardDAO(entityManager);
        BigliettoDAO bd=new BigliettoDAO(entityManager);
        AbbonamentoDAO abbonamentoDAO=new AbbonamentoDAO(entityManager);
        //Validita tessera
        try{
            System.out.println("Inserisci un codice tessera");
            String codiceTessera = scan.nextLine();
            cardDAO.scadenzaTessera(codiceTessera);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        // codice tessera 34780792
        // codice tessera 54378455

        try{
            bd.numeroBigliettiData(LocalDate.now());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        //Codice macchina per cercare i biglietti venduti --> LHCXLMSE
        //BigliettiANDBiglietti --> nome venditore

        try{
            System.out.println("Inserisci il nome del venditore:");
            String name = scan.nextLine();
            bd.findAll(name);
            System.out.println("Inserisci codice macchiana:");
            String machineCode = scan.nextLine();
            bd.findAllDa(machineCode);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
//34780792 -->numero tessera
        try{
            System.out.println("Inserisci il codice tessera per verificare la scadenza: ");
            String codiceTessera = scan.nextLine();
            cardDAO.scadenzaTessera(codiceTessera);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

      //-->  34780792
        try{
            System.out.println("Inserisci il codice tessera e verificheremo se l'abbonamento è valido: ");
            String codiceTessera = scan.nextLine();
            abbonamentoDAO.verificaValidita(codiceTessera);

        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        Biglietto biglietto = new Biglietto("SESSANTAMINUTI");
        bd.save(biglietto, new Distributorefisico("Padova", "FISICO", "Federico Biglietti"));

        try{
            System.out.println("Siamo nel buss....");
            System.out.println("Timbrare biglietto: si/no");
            String risposta = scan.nextLine();
            if (risposta.equalsIgnoreCase("si")) {
                System.out.println("Inserisci l'id biglietto: ");
                bd.timbraBiglietto(Long.parseLong(scan.nextLine()));
            }else{
                System.out.println("Se non hai il biglietto puoi comprarlo dall'autista");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
