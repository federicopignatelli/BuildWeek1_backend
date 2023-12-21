package org.example.EntitiesDAO;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    //Funzione che assegna Distributore al biglietto controllando il tipo di distributore passato;

    public void create(Biglietto bi, Distributore distributore) {
        Long valueIn = 1L;
        em.getTransaction().begin();

        //VERIFICO CHE ESISTA GIA IL VENDITORE
        Query qEsistenzaInDistributoreAutomatico = em.createQuery("update Distributoreautomatico f set f" +
                ".bigliettivenduti=f.bigliettivenduti  + :valoreIn where f.id = :id");

        Query qEsistenzaInDistributoreFisico = em.createQuery("update Distributorefisico g set g" +
                ".bigliettivenduti=g.bigliettivenduti + " + ":valoreIn where g.id =:id");
        //DA CORREGGERE
        Query esistenza = em.createQuery("select d from Distributoreautomatico d where d.id = :thisid");
        /*Query esistenzaDf = em.createQuery("select d from Distributorefisico d where d.id = :thisid");*/
        esistenza.setParameter("thisid", distributore.getIdBiglietteria());
        List resul = esistenza.getResultList();

        if (resul.size() != 1) /*LA LISTA è VUOTA QUINDI CREO ANCHE IL BIGLIETTO CON IL NUOVO DISTRIBUTORE*/ {
            /*CONTROLLO L'ISTANZA DI DISTRIBUTORE SE è AUTOMATICO O FISSO*/
            if (distributore instanceof Distributorefisico) {
                /*--> QUESTO SERVE PER CREARE IL VALORE ID NELLA TABELLA BIGLIETTO*/
                bi.setDistributori_fisico((Distributorefisico) distributore);
                distributore.setBigliettivenduti(distributore.getBigliettivenduti());
                System.out.println("Biglietto salvato");
            } else {
                /*--> QUESTO SERVE PER CREARE IL VALORE ID NELLA TABELLA BIGLIETTO*/
                bi.setDistributori_automatico((Distributoreautomatico) distributore);
                distributore.setBigliettivenduti(distributore.getBigliettivenduti());
                System.out.println("Biglietto salvato");

            }
        } else /* IN QUESTO CASO ESISTE IL VENDITORE */ {
            if (distributore instanceof Distributoreautomatico) {
                System.out.println("Esisto già");
                Distributoreautomatico c = (Distributoreautomatico) resul.get(0);
                Long idBigl = c.getIdBiglietteria();
                qEsistenzaInDistributoreAutomatico.setParameter("valoreIn", valueIn);
                qEsistenzaInDistributoreAutomatico.setParameter("id", idBigl);
                qEsistenzaInDistributoreAutomatico.executeUpdate();

            } else {
                Distributorefisico c = (Distributorefisico) resul.get(0);
                Long idBigl = c.getIdBiglietteria();
                qEsistenzaInDistributoreFisico.setParameter("valoreIn", valueIn);
                qEsistenzaInDistributoreFisico.setParameter("id", idBigl);
                qEsistenzaInDistributoreFisico.executeUpdate();
            }

        }
        em.persist(bi);
        em.getTransaction().commit();
    }

    public void delete(Biglietto bi) {
    }

}
