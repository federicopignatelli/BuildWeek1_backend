package org.example.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity (name = "distributori_automatici")
public class Distributoreautomatico extends Distributore {

   /*@Column (name = "codice_macchina", insertable = false, updatable = false, nullable = false, unique = true)
    private String codiceMacchina;*/
    @Column (name = "servizi")
    @Enumerated (EnumType.STRING)
    Servizi servizi;


    /*----------------------< Costruttori >---------------------------*/
    public Distributoreautomatico() {
    }

    public Distributoreautomatico(String locazione, String tipologia, long bigliettivenduti, long abbonamentiVenduti,
                                  String servizi) {
        this.idBiglietteria = getIdBiglietteria();
        this.locazione = locazione;
        this.tipologia = Tipologia.getName(tipologia);
        /*this.codiceMacchina=generateCode();*/
        this.bigliettivenduti = bigliettivenduti;
        this.abbonamentiVenduti = abbonamentiVenduti;
        this.servizi = Servizi.getName(servizi);
    }

    /*----------------------< Getter and Setter >---------------------------*/

  /*  public String getCodiceMacchina() {
        return codiceMacchina;
    }*/

    public Servizi getServizi() {
        return servizi;
    }

    @Override
    public String toString() {
        return "----------------------------------" +
                "\n" + "|> id:" + getIdBiglietteria() + "\n" + "|> Locazione: "
                + getLocazione() + "\n" + "|> tipologia:" + getTipologia() + "\t" + "\n" + "|> bigliettivenduti: "
                + getBigliettivenduti() + "\n" + "|> abbonamentiVenduti: " + getAbbonamentiVenduti() + "\n"
                + "|> Servizi: " + getServizi() + "\n" + "--------------------------------";
    }
}
