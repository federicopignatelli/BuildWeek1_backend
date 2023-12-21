package org.example.Entities;

import org.example.Entities.ENUM.Tipologia_biglietto;
import org.example.Entities.Interface.Emissione;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;

@Entity
@Table (name = "biglietti")
@NamedQueries(
        {@NamedQuery(name = "findAllBiglietti", query = "SELECT biglietto.id_biglietto " +
                "FROM Biglietto biglietto JOIN biglietto.distributori_fisico df " +
                "WHERE df.companyName LIKE :companyName")})
public class Biglietto {
    @Id
    @GeneratedValue
    private Long id_biglietto;
    @Enumerated (EnumType.STRING)
    private Tipologia_biglietto tipologia_biglietto;
    @Enumerated (EnumType.STRING)
    private MezzoType mezzo;
    private Double prezzo;
    private LocalDate dataemissioneBiglietto;

    private boolean vidimazione;


    @OneToMany (mappedBy = "biglietti")
    private List<Tratta> tratta;

    @ManyToOne
    @JoinColumn (name = "biglietterie_automatiche")
    private Distributoreautomatico distributori_automatici;

    @ManyToOne
    @JoinColumn (name = "biglietterie_fisiche")
    private Distributorefisico distributori_fisico;


    //COSTRUTTORI
    public Biglietto() {
    }

    public Biglietto(String tipologia_biglietto) {
        this.id_biglietto = getId_biglietto();
        this.tipologia_biglietto = Tipologia_biglietto.valueOf(tipologia_biglietto);
        /*this.prezzo = prezzo;*/
        this.dataemissioneBiglietto = LocalDate.now();
        this.vidimazione = false;
        /*this.setDistributori_automatico( (Distributoreautomatico) distributori_automatici);*/
    }
    /*public Biglietto(String tipologia_biglietto, Distributore distributori_fisico) {
        this.id_biglietto = getId_biglietto();
        this.tipologia_biglietto = Tipologia_biglietto.valueOf(tipologia_biglietto);
        this.dataemissioneBiglietto = LocalDate.now();
        this.vidimazione = false;
        *//*this.setDistributori_fisico( (Distributorefisico) distributori_automatici);*//*
    }*/


    public Biglietto(Distributorefisico distributori_fisico) {
        this.distributori_fisico = distributori_fisico;
    }

    /*    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }*/


    /*----------------------< Getter and Setter >---------------------------*/
    // --> GETTER
    public Long getId_biglietto() {
        return id_biglietto;
    }

    public Tipologia_biglietto getTipologia_biglietto() {
        return tipologia_biglietto;
    }

    public void setTipologia_biglietto(Tipologia_biglietto tipologia_biglietto) {
        this.tipologia_biglietto = tipologia_biglietto;
    }

    public Distributorefisico getDistributori_fisico() {
        return distributori_fisico;
    }

    public Distributoreautomatico getDistributori_automatici() {
        return distributori_automatici;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public LocalDate getdataemissioneBiglietto() {
        return dataemissioneBiglietto;
    }

    //--> SETTER
    public void setdataemissioneBiglietto(LocalDate dataemissioneBiglietto) {
        this.dataemissioneBiglietto = dataemissioneBiglietto;
    }

    public void setDistributori_fisico(Distributorefisico distributori_fisico) {
        this.distributori_fisico = distributori_fisico;
    }

    public void setDistributori_automatico(Distributoreautomatico distributori_automatici) {
        this.distributori_automatici = distributori_automatici;
    }

    public boolean isVidimazione() {
        return vidimazione;
    }

    public void setVidimazione(boolean vidimazione) {
        this.vidimazione = vidimazione;
    }

    public void setMezzo(MezzoType mezzo) {
        this.mezzo = mezzo;
    }


    @Override
    public String toString() {
        return "Biglietto{" + "id_biglietto=" + id_biglietto + ", tipologia_biglietto=" + tipologia_biglietto + ", mezzo=" + mezzo + ", prezzo=" + prezzo +  " vidimazione=" + vidimazione + ", tratta=" + tratta + ", distributori_automatici=" + distributori_automatici + ", distributori_fisico=" + distributori_fisico + '}';
    }
}


