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
//    private Mezzo mezzo;
    private Double prezzo;
    private LocalDate dataemissioneBiglietto;
//    private Tratta tratta;
    private boolean vidimazione;

    @ManyToOne
    @JoinColumn(name="users")
    User users;

    @OneToMany (mappedBy="biglietti")
    private List<Tratta> tratta;

    @ManyToOne
    @JoinColumn(name="biglietterie")
    private Distributoreautomatico biglietterie;

//    @ManyToOne
//    @JoinColumn(name="biglietteriefisiche")
//    private Distributorefisico biglietteriefisiche;


    //COSTRUTTORI
    public Biglietto() {
    }

    public Biglietto(Tipologia_biglietto tipologia_biglietto, /*Mezzo mezzo,*/ Double prezzo, LocalDate dataemissioneBiglietto, /*Tratta tratta,*/ boolean vidimazione) {
        this.id_biglietto = getId_biglietto();
        this.tipologia_biglietto = tipologia_biglietto;
//        this.mezzo = mezzo;
        this.prezzo = prezzo;
        this.dataemissioneBiglietto = dataemissioneBiglietto;
//        this.tratta = tratta;
        this.vidimazione = vidimazione;
    }

    public Long getId_biglietto() {
        return id_biglietto;
    }

    public Tipologia_biglietto getTipologia_biglietto() {
        return tipologia_biglietto;
    }

    public void setTipologia_biglietto(Tipologia_biglietto tipologia_biglietto) {
        this.tipologia_biglietto = tipologia_biglietto;
    }

/*    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }*/

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


