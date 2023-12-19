package org.example.Entities;

import org.example.EntitiesDAO.DistributorefisicoDAO;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity (name = "distributore_fisico")

public class Distributorefisico extends Distributore {
    @Column (name = "name_company", nullable = false, unique = true)
    private String companyName;

    @Column (name = "p_iva", unique = true, nullable = false, length = 11)
    private String pIva;




public Distributorefisico(){}

    public Distributorefisico(String locazione, String tipologia, long bigliettivenduti, long abbonamentiVenduti) {
        this.idBiglietteria = getIdBiglietteria();
        this.locazione = locazione;
        this.tipologia = Tipologia.getName(tipologia);
        this.bigliettivenduti = bigliettivenduti;
        this.abbonamentiVenduti = abbonamentiVenduti;
    }

    /*---------------------------< Metodi >----------------------*/

//    public String generatePiva(){
//        String number="1234567890";
//        String piva = "";
//        Random rd=new Random();
//        DistributorefisicoDAO de=new DistributorefisicoDAO(em);
//        /*do {
//
//
//        }while()*/
//        System.out.println(piva);
//        return piva;
//    }
}
