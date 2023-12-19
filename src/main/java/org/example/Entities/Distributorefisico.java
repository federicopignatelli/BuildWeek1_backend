package org.example.Entities;

import org.example.EntitiesDAO.DistributorefisicoDAO;

import javax.persistence.*;
import java.util.Random;

@Entity (name = "distributore_fisico")

public class Distributorefisico extends Distributore {
    @Column (name = "name_company", nullable = false, unique = true)
    private String companyName;

    @Column (name = "p_iva", unique = true, nullable = false, length = 11)
    private String pIva;



public Distributorefisico(){}













    /*---------------------------< Metodi >----------------------*/

   /* public String generatePiva(){
        String number="1234567890";
        String piva = "";
        Random rd=new Random();
        DistributorefisicoDAO de=new DistributorefisicoDAO(em);
        *//*do {


        }while()*//*
        System.out.println(piva);
        return piva;
    }*/
}
