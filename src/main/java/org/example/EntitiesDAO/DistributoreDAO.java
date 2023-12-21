package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.Entities.Tipologia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class DistributoreDAO {
    Logger logger= LoggerFactory.getLogger(DistributoreDAO.class);
    public final EntityManager em;

    public DistributoreDAO(EntityManager em){this.em = em;}
    public void save(Distributore dis){
        DistributorefisicoDAO df = new DistributorefisicoDAO(em);
        em.getTransaction().begin();
        if(dis instanceof Distributorefisico ){
            Distributorefisico ds= (Distributorefisico) dis;
            logger.error("sono dentro");
            df.save(ds);
            }else{
            DistributoreautomaticoDAO da=new DistributoreautomaticoDAO(em);
            da.save(dis);
        }

        em.getTransaction().commit();
    }


    //Ritorna il distributore dando l'id
    public Distributore getDi(long id){
        return em.find(Distributore.class,id);
    }


}
