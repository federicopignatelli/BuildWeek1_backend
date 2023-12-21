package org.example.EntitiesDAO;

import org.example.Entities.*;
import org.example.Entities.ENUM.Tipologia_biglietto;

import javax.persistence.EntityManager;


public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    //Funzione che assegna Distributore al biglietto controllando il tipo di distributore passato;
    public void creaBiglietto(Biglietto bi, Distributore distributore) {
        // DOVE LO HA ACQUISTATO E FARE QUERY PER VEDERE IL NUMERO DI BIGLIETTI VENDUTI;
        em.getTransaction().begin();
        if (distributore instanceof Distributorefisico) {
            bi.setDistributori_fisico((Distributorefisico) distributore);
            em.persist(bi);
        } else {
            bi.setDistributori_automatico((Distributoreautomatico) distributore);
            if (bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("NOVANTAMINUTI")) || bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("SESSANTAMINUTI"))) {
                bi.setMezzo(MezzoType.getName("AUTOBUS"));
            }else if(bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("GIORNALIERO")) || bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("CENTOVENTIMINUTI"))){
                bi.setMezzo(MezzoType.getName("TRAM"));
            }
            em.persist(bi);
        }

        em.getTransaction().commit();

    }

    public void delete(Biglietto bi) {
    }

}
