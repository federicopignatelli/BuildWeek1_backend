package org.example.EntitiesDAO;

import org.example.Entities.*;
import org.example.Entities.ENUM.Tipologia_biglietto;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.example.Application.logger;


public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto, Distributore fisico) {
        DistributoreDAO dis = new DistributoreDAO(em);
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        try {

            double prezzo = switch (biglietto.getTipologia_biglietto()) {
                case NOVANTAMINUTI -> 1.55;
                case SESSANTAMINUTI -> 1.25;
                case GIORNALIERO -> 15.00;
                case CENTOVENTIMINUTI -> 5.45;
            };
            biglietto.setPrezzo(prezzo);
            if (fisico instanceof Distributoreautomatico) {
                logger.error("sono automatic");
                try {
                    if (esistenzaDistributoreAutomatico(((Distributoreautomatico) fisico).getCodiceMacchina()) == null) {
                        dis.save(fisico);
                        System.out.println("Il rivenditore automatico " + ((Distributoreautomatico) fisico).getCodiceMacchina() + " è stato creato con successo");
                        biglietto.setDistributori_automatico((Distributoreautomatico) fisico);
                        //----------------------------//
                        biglietto.setMezzo(calculateMezzo(biglietto));
                    } else {
                        Distributoreautomatico d =
                                esistenzaDistributoreAutomatico(biglietto.getDistributori_automatici().getCodiceMacchina());

                        biglietto.setDistributori_automatico(d);
                        //----------------------------//
                        biglietto.setMezzo(calculateMezzo(biglietto));

                    }
                    /**/
                    em.persist(biglietto);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    em.getTransaction().rollback();

                } finally {
                    em.getTransaction().commit();
                    System.out.println("Biglietto: " + "con id " + biglietto.getId_biglietto() + " acquistato con " + "successo");
                }
            } else {
                /*---------------------------- controllo istance distributore
                fisico-----------------------------------*/
                try {
                    if (esistenzaDistributoreFisico(((Distributorefisico) fisico).getCompanyName()) == null) {
                        dis.save(fisico);
                        biglietto.setDistributori_fisico((Distributorefisico) fisico);
                        //----------------------------//
                        biglietto.setMezzo(calculateMezzo(biglietto));
                        System.out.println((Distributorefisico) fisico);
                        System.out.println("Il rivenditore " + ((Distributorefisico) fisico).getCompanyName() + " è " + "stato creato con successo! ");
                    } else {
                        Distributorefisico d =
                                esistenzaDistributoreFisico(((Distributorefisico) fisico).getCompanyName());
                        biglietto.setDistributori_fisico(d);
                        //----------------------------//
                        biglietto.setMezzo(calculateMezzo(biglietto));

                    }
                    em.persist(biglietto);
                } catch (RuntimeException e) {
                    logger.error(e.getMessage());
                    em.getTransaction().rollback();
                } finally {
                    em.getTransaction().commit();
                    System.out.println("Biglietto: " + "con id " + biglietto.getId_biglietto() + " acquistato con " + "successo");
                }
            }
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            em.getTransaction().rollback();
        }
    }

    public Distributorefisico esistenzaDistributoreFisico(String companyName) {
        TypedQuery<Distributorefisico> query = em.createNamedQuery("existsByCompanyNameLike", Distributorefisico.class);
        query.setParameter("name", companyName);
        List<Distributorefisico> distributorefisico = query.getResultList();
        /*System.out.println(d);*/
        if (distributorefisico.isEmpty()) {
            return null;
        } else {
            return distributorefisico.get(0);
        }
    }

    public Distributoreautomatico esistenzaDistributoreAutomatico(String code) {
        TypedQuery<Distributoreautomatico> query = em.createNamedQuery("existbyMachineCode",
                Distributoreautomatico.class);
        query.setParameter("codiceMacchina", code);
        List<Distributoreautomatico> distributoreautomatico = query.getResultList();

        if (distributoreautomatico.isEmpty()) {
            return null;
        } else {
            return distributoreautomatico.get(0);
        }
    }

    /*--------------------------------< Conteggio Biglietti >---------------------------------*/
    //Conteggi biglietti per singolo venditore attribuendo o codice macchina o companyName
    public MezzoType calculateMezzo(Biglietto biglietto) {
        if ((biglietto.getTipologia_biglietto() == Tipologia_biglietto.NOVANTAMINUTI) || (biglietto.getTipologia_biglietto() == Tipologia_biglietto.SESSANTAMINUTI)) {
            return MezzoType.TRAM;
        } else {
            return MezzoType.AUTOBUS;
        }
    }

    public void findAll(String name) {
        TypedQuery<Long> query = em.createNamedQuery("findAllBiglietti", Long.class);
        query.setParameter("companyName", name);
        List<Long> result = query.getResultList();
        System.out.println("Sono stati trovati " + result.size() + " biglietti corrispondenti al rivenditore " + name);
    }

    public void findAllDa(String name) {
        TypedQuery<Distributoreautomatico> query = em.createNamedQuery("existbyMachineCode",
                Distributoreautomatico.class);
        query.setParameter("codiceMacchina", name);
        List<Distributoreautomatico> result = query.getResultList();
        System.out.println("Sono stati trovati " + result.size() + " biglietti corrispondenti al rivenditore " + name);
    }
    /*---------------------------------------------------------------------------------------*/

    public void findCountTicketByMezzo(MezzoType mezzo){
        TypedQuery<Biglietto> query = em.createNamedQuery("findByVeicle", Biglietto.class);
        query.setParameter("mezzo", mezzo);
        List<Biglietto> result = query.getResultList();
        System.out.println("Sono stati trovati " + result.size() + " biglietti corrispondenti al mezzo " + mezzo);
    }
}


