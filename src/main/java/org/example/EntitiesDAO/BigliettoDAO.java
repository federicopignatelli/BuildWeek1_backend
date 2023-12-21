package org.example.EntitiesDAO;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;

import javax.persistence.EntityManager;


public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    //Funzione che assegna Distributore al biglietto controllando il tipo di distributore passato;
    public void creaBiglietto(Biglietto bi, Distributore distributore) {


    }

    public void delete(Biglietto bi) {
    }

}
