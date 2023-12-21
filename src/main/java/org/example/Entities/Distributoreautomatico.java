package org.example.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table (name = "distributori_automatici")
@NamedQueries ({@NamedQuery (name = "existbyMachineCode", query = "select d " + "from Distributoreautomatico d where " +
        "d.codiceMacchina like :codiceMacchina")})
public class Distributoreautomatico extends Distributore {

    @Column (name = "codice_macchina", unique = true)
    private String codiceMacchina;
    @Column (name = "servizi")
    @Enumerated (EnumType.STRING)
    Servizi servizi;
    @OneToMany (mappedBy = "distributori_automatici")
    private List<Biglietto> biglietti;

    @OneToMany (mappedBy = "distributoreautomatico", orphanRemoval = true)
    private List<Abbonamento> abbonamenti = new ArrayList<>();


    /*----------------------< Costruttori >---------------------------*/
    public Distributoreautomatico() {
    }

    public Distributoreautomatico(String locazione, String tipologia, String servizi) {
        this.idBiglietteria = getIdBiglietteria();
        this.locazione = locazione;
        this.tipologia = Tipologia.getName(tipologia);
        this.codiceMacchina = genCode();
        this.servizi = Servizi.getName(servizi);
    }

    /*----------------------< Getter and Setter >---------------------------*/

    public String getCodiceMacchina() {
        return codiceMacchina;
    }


    public Servizi getServizi() {
        return servizi;
    }


    @Override
    public String toString() {
        return "----------------------------------" + "\n" + "|> id:" + getIdBiglietteria() + "\n" + "|> Locazione: " + getLocazione() + "\n" + "|> tipologia:" + getTipologia() + "\t" + "\n" + "|> bigliettivenduti: " + "\n" + "|> abbonamentiVenduti: " + "\n" + "|> Servizi: " + getServizi() + "\n" + "--------------------------------";
    }

    public String genCode() {
        Random random = new Random();
        StringBuilder codiceMacchina = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 8; i++) {
            codiceMacchina.append(characters.charAt(random.nextInt(1, 26)));
        }
        System.out.println(codiceMacchina.toString());
        return codiceMacchina.toString();
    }
}
