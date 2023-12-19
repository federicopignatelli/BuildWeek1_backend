package org.example.Entities;
import org.example.Entities.ENUM.Tipologia_biglietto;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "biglietti")
public class Biglietto {
    @Id
    @GeneratedValue
    private Long id_biglietto;
    private Tipologia_biglietto tipologia_biglietto;
    private Double prezzo;
    private LocalDate dataemissioneBiglietto;
    private boolean vidimazione;

    @ManyToOne
    @JoinColumn(name="users")
    User users;

    @OneToMany (mappedBy="biglietti")
    private List<Tratta> tratta;

    @ManyToOne
    @JoinColumn(name="biglietterie_automatiche")
    private Distributoreautomatico distributori_automatici;

    @ManyToOne
    @JoinColumn(name="biglietterie_fisiche")
    private Distributorefisico distributori_fisico;


    //COSTRUTTORI
    public Biglietto() {
    }

    public Biglietto(Tipologia_biglietto tipologia_biglietto, Double prezzo, LocalDate dataemissioneBiglietto, /*Tratta tratta,*/ boolean vidimazione) {
        this.id_biglietto = getId_biglietto();
        this.tipologia_biglietto = tipologia_biglietto;
        this.prezzo = prezzo;
        this.dataemissioneBiglietto = dataemissioneBiglietto;
//        this.tratta = tratta;
        this.vidimazione = vidimazione;
    }

    public Biglietto(Distributoreautomatico distributori_automatici) {
        this.distributori_automatici = distributori_automatici;
    }

    public Biglietto(Distributorefisico distributori_fisico) {
        this.distributori_fisico = distributori_fisico;
    }


    /*    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }*/

    public Long getId_biglietto() {
        return id_biglietto;
    }

    public Tipologia_biglietto getTipologia_biglietto() {
        return tipologia_biglietto;
    }

    public void setTipologia_biglietto(Tipologia_biglietto tipologia_biglietto) {
        this.tipologia_biglietto = tipologia_biglietto;
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

    public void setdataemissioneBiglietto(LocalDate dataemissioneBiglietto) {
        this.dataemissioneBiglietto = dataemissioneBiglietto;
    }

/*    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }*/

    public boolean isVidimazione() {
        return vidimazione;
    }

    public void setVidimazione(boolean vidimazione) {
        this.vidimazione = vidimazione;
    }
}


