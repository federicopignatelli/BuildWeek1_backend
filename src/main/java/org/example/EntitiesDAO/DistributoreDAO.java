package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.Entities.Tipologia;

import javax.persistence.EntityManager;

public class DistributoreDAO {
    public final EntityManager em;

    public DistributoreDAO(EntityManager em){this.em = em;}
    public void save(Distributore dis){
        em.getTransaction().begin();

        if(dis instanceof Distributorefisico) {
            DistributorefisicoDAO df = new DistributorefisicoDAO(em);
            df.save(dis);
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
