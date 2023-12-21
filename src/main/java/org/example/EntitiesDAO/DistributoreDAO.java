package org.example.EntitiesDAO;

import org.example.Entities.Distributore;
import org.example.Entities.Distributoreautomatico;
import org.example.Entities.Distributorefisico;
import org.example.Entities.Tipologia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class DistributoreDAO {
    Logger logger= LoggerFactory.getLogger(DistributoreDAO.class);
    public final EntityManager em;

    public DistributoreDAO(EntityManager em){this.em = em;}
    public void save(Distributore distributore){
        //generazione o no di distributore se eseiste o meno
        em.getTransaction().begin();
        if(em.getTransaction().isActive()){
            controlodistributore(distributore);
        }else{
            EntityTransaction tra = em.getTransaction();
            try {
                tra.begin();
                controlodistributore(distributore);
                tra.commit();
            }catch (Exception e){
                if(tra.isActive()){
                    tra.rollback();
                }
            }
        }

    }

    public void controlodistributore(Distributore distributore){
        if (distributore instanceof Distributoreautomatico){
            TypedQuery<Distributoreautomatico> queryex=em.createNamedQuery("existbyMachineCode", Distributoreautomatico.class);
            queryex.setParameter("codiceMacchina", ((Distributoreautomatico) distributore).getCodiceMacchina());
            List<Distributoreautomatico> listex=queryex.getResultList();
            if (listex.isEmpty()){
                em.persist(distributore);
                em.getTransaction().commit();
            }else{
                logger.error("Distributore automatico già esistente");
            }
        } else if (distributore instanceof Distributorefisico) {
            TypedQuery<Distributorefisico> queryDf=em.createNamedQuery("existsByCompanyNameLike", Distributorefisico.class);
            queryDf.setParameter("name", ((Distributorefisico) distributore).getCompanyName());
            List<Distributorefisico> list=queryDf.getResultList();
            if (list.isEmpty()){
                em.persist(distributore);
                em.getTransaction().commit();
            }else{
                logger.error("Distributore fisico già esistente");
            }
        }
    }

    //Ritorna il distributore dando l'id
    public Distributorefisico getDi(Long id) {
        return em.find(Distributorefisico.class,id);
    }


}
