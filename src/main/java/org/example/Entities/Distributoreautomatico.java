package org.example.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.example.Entities.Abbonamento;

@Entity
@Table(name = "distributori_automatici")
@NamedQueries (
        {@NamedQuery (name = "existbyMachineCode", query = "select d " +
                "from Distributoreautomatico d where d.codiceMacchina like :codiceMacchina")})
public class Distributoreautomatico extends Distributore {

    @Column (name = "codice_macchina",  unique = true)
    private String codiceMacchina;
    @Column (name = "servizi")
    @Enumerated (EnumType.STRING)
    Servizi servizi;
    @OneToMany(mappedBy = "distributori_automatici")
    private List<Biglietto> biglietti;

    @OneToMany (mappedBy = "distributoreautomatico", orphanRemoval = true)
    private List<Abbonamento> abbonamenti = new ArrayList<>();



    /*----------------------< Costruttori >---------------------------*/
    public Distributoreautomatico() {
    }

    public Distributoreautomatico(String locazione, String tipologia, long abbonamentiVenduti, String codiceMacchina,
                                  String servizi) {
        this.idBiglietteria = getIdBiglietteria();
        this.locazione = locazione;
        this.tipologia = Tipologia.getName(tipologia);
        this.bigliettivenduti = getBigliettivenduti();
        this.codiceMacchina = codiceMacchina;
        this.abbonamentiVenduti = abbonamentiVenduti;
        this.servizi = Servizi.getName(servizi);
    }

    /*----------------------< Getter and Setter >---------------------------*/

    public String getCodiceMacchina() {
        return codiceMacchina;
    }

    public String setCodiceMacchina(String codiceMacchina) {
        return this.codiceMacchina = codiceMacchina;
    }

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

    public String genCode(){
        Random random = new Random();
        String codiceMacchina = "";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 8; i++) {
            codiceMacchina += characters.charAt(random.nextInt(1,26));
        }
        System.out.println(codiceMacchina);
        return codiceMacchina;
    }
}
