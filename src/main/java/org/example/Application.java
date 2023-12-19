package org.example;

import org.example.Entities.Mezzo;
import org.example.Entities.MezzoType;
import org.example.Entities.Tratta;
import org.example.EntitiesDAO.MezzoDAO;
import org.example.EntitiesDAO.TrattaDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

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

//********************************************* MEZZI - TRATTE *************************************************************************************
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
        TrattaDAO trattaDAO = new TrattaDAO(entityManager);
        Tratta colosseo = new Tratta("Colosseo","Testaccio", LocalTime.of(0,20,41),19);
        Tratta eur = new Tratta("Termini","Trevi", LocalTime.of(1,1,21),39);
//        trattaDAO.save(colosseo);
//        trattaDAO.save(eur);
        Mezzo arpa = new Mezzo(MezzoType.TRAM, 50, LocalDate.of(2022,7,2),colosseo);
        Mezzo tram1 = new Mezzo(MezzoType.TRAM,140,LocalDate.of(2023,9,6),eur);
//        mezzoDAO.save(tram1);
//        mezzoDAO.save(tram1);

        System.out.println("ciaone");

        entityManager.close();
        managerFactory.close();
    }
}
