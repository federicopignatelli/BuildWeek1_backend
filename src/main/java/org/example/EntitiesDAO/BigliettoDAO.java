package org.example.EntitiesDAO;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributorefisico;

import javax.persistence.EntityManager;


public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto, Distributore fisico) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
       /* Distributorefisico distributore = biglietto.getDistributori_fisico();
        if (distributore.getIdBiglietteria() == null && distributore != null) {
            Distributorefisico distributoreFisico = em.find(Distributorefisico.class, fisico.getIdBiglietteria());

        }*/
        biglietto.setDistributori_fisico((Distributorefisico) fisico);

        double prezzo = switch (biglietto.getTipologia_biglietto()) {
            case NOVANTAMINUTI -> 1.55;
            case SESSANTAMINUTI -> 1.25;
            case GIORNALIERO -> 15.00;
            case CENTOVENTIMINUTI -> 5.45;
        };
        biglietto.setPrezzo(prezzo);
        em.persist(biglietto);
        em.getTransaction().commit();
    }

    public void asignDistributore(Distributore dis, Biglietto biglietto) {
        em.getTransaction().begin();

        biglietto.setDistributori_fisico((Distributorefisico) dis);
        em.persist(biglietto);
        em.getTransaction().commit();
    }

    //Funzione che assegna Distributore al biglietto controllando il tipo di distributore passato;
    /*public void creaBiglietto(Biglietto bi, Distributore distributore) {
        // DOVE LO HA ACQUISTATO E FARE QUERY PER VEDERE IL NUMERO DI BIGLIETTI VENDUTI;
        em.getTransaction().begin();
        em.persist(bi);
        em.getTransaction().commit();
        em.getTransaction().begin();
        try {
            if (distributore instanceof Distributorefisico) {
                //qui entro
                bi.setDistributori_fisico((Distributorefisico) distributore);
                Distributorefisico dist = bi.getDistributori_fisico();

            } else {
                bi.setDistributori_automatico((Distributoreautomatico) distributore);
                if (bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("NOVANTAMINUTI")) || bi
                .getTipologia_biglietto().equals(Tipologia_biglietto.getType("SESSANTAMINUTI"))) {
                    bi.setMezzo(MezzoType.getName("AUTOBUS"));
                    em.persist(bi);

                } else if (bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("GIORNALIERO")) || bi
                .getTipologia_biglietto().equals(Tipologia_biglietto.getType("CENTOVENTIMINUTI"))) {
                    bi.setMezzo(MezzoType.getName("TRAM"));
                    em.persist(bi);
                    System.out.println("sono dentro");
                }
                em.getTransaction().commit();
            } else{
                bi.setDistributori_automatico((Distributoreautomatico) distributore);
                if (bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("NOVANTAMINUTI")) || bi
                .getTipologia_biglietto().equals(Tipologia_biglietto.getType("SESSANTAMINUTI"))) {
                    bi.setMezzo(MezzoType.getName("AUTOBUS"));
                    em.persist(bi);
                    em.getTransaction().commit();
                } else if (bi.getTipologia_biglietto().equals(Tipologia_biglietto.getType("GIORNALIERO")) || bi
                .getTipologia_biglietto().equals(Tipologia_biglietto.getType("CENTOVENTIMINUTI"))) {
                    bi.setMezzo(MezzoType.getName("TRAM"));
                    em.persist(bi);
                    System.out.println("sono dentro");
                    em.getTransaction().commit();
                }

                em.getTransaction().commit();
            } catch(Exception e){
                logger.error(e.getMessage(), e);
                e.printStackTrace();
            } finally{
                System.out.println("Biglietto aggiunto");
            }

        }*/


    /*public void erogBiglietto(String tipo, Distributore distributore) {
        EntityTransaction transaction = em.getTransaction().begin();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        DistributoreDAO dao = new DistributoreDAO(em);
        Distributore di = dao.getDi(distributore.getIdBiglietteria());
        System.out.println(di);
        try {
            double prezzo = 0.0;
            switch (tipo) {
                case "NOVANTAMINUTI":
                    prezzo = 1.55;
                    break;
                case "SESSANTAMINUTI":
                    prezzo = 1.25;
                    break;
                case "GIORNALIERO":
                    prezzo = 15.00;
                    break;
                case "CENTOVENTIMINUTI":
                    prezzo = 5.45;
                    break;
            }


            System.out.println(di);
            Biglietto biglietto = new Biglietto(tipo, prezzo);
            em.persist(biglietto);
            Distributorefisico dis = em.find(Distributorefisico.class, di);


            if (transaction.isActive()) if (dis != null) {
                biglietto.setDistributori_fisico(((Distributorefisico) distributore));
                em.persist(biglietto);
                System.out.println(biglietto.toString());
                transaction.commit();
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

    } else

    {


        Biglietto biglietto = new Biglietto(tipo, prezzo);
        em.persist(biglietto);
        biglietto.setDistributori_fisico((Distributorefisico) distributore);
        em.persist(biglietto);
        System.out.println(biglietto.toString());
        transaction.commit();
    } catch(
    RuntimeException e)

    {
        logger.error(e.getMessage(), e);
        e.printStackTrace();
    }*/


}


