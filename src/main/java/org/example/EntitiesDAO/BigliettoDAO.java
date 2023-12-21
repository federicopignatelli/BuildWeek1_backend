package org.example.EntitiesDAO;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributorefisico;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.List;

import static org.example.Application.logger;


public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto, Distributore fisico) {
        DistributoreDAO dis= new DistributoreDAO(em);
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
            try{
                Distributorefisico d = esistenzaDistributoreFisico(biglietto.getDistributori_fisico().getCompanyName());
                if(esistenzaDistributoreFisico(biglietto.getDistributori_fisico().getCompanyName())==null) {
                    dis.save(fisico);
                    System.out.println(d);
                    System.out.println("Il rivenditore " + ((Distributorefisico) fisico).getCompanyName() + " è stato creato con successo: ");
                }else{
                    biglietto.setDistributori_fisico(d);

                }
                em.persist(biglietto);
            }catch(RuntimeException e){
                logger.error(e.getMessage());
                em.getTransaction().rollback();
            }finally {
                em.getTransaction().commit();
                System.out.println("Biglietto: " + "con id " + biglietto.getId_biglietto() + " acquistato con successo");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
        }




    }

    public Distributorefisico esistenzaDistributoreFisico(String companyName) {
        TypedQuery<Distributorefisico> query = em.createNamedQuery("existsByCompanyNameLike",Distributorefisico.class);
        query.setParameter("name", companyName);
        List<Distributorefisico> distributorefisico = query.getResultList();
        /*System.out.println(d);*/
        if(distributorefisico.isEmpty()) {
            return null;
        }
        else {
            return distributorefisico.get(0);
        }
    }



}


