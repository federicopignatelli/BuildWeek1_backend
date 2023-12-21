package org.example;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.EntitiesDAO.AbbonamentoDAO;
import org.example.EntitiesDAO.BigliettoDAO;
import org.example.EntitiesDAO.DistributoreDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bw1812");
    public static Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        EntityManager entityManager = managerFactory.createEntityManager();
        DistributoreDAO dm = new DistributoreDAO(entityManager);
        BigliettoDAO bid = new BigliettoDAO(entityManager);
        AbbonamentoDAO abb = new AbbonamentoDAO(entityManager);
        Biglietto biglietto;

        /*dm.save(da);*/

        Distributoreautomatico da = new Distributoreautomatico();
        try {
            Distributore df = new Distributorefisico("Napoli", "FISICO", "stazione.napoli");
            /*Biglietto napoliCagliari = new Biglietto("NOVANTAMINUTI", 5.45);*/
            /*da = new Distributoreautomatico("Milano Centrale", "AUTOMATICO", "BOTH");*/
            dm.save(df);
            /*bid.erogBiglietto("SESSANTAMINUTI", da);*/
            /*bid.getDistributore(df);*/
            try{

                biglietto=new Biglietto("NOVANTAMINUTI",  df);
                bid.save(biglietto,df);

            }catch(Exception e){
                logger.error(e.getMessage(), e);
            }


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


        entityManager.close();
        managerFactory.close();

    }

}
