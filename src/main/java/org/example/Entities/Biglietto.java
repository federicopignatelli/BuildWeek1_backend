package org.example.Entities;

import org.example.Entities.ENUM.Tipologia_biglietto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table (name = "biglietti")
@NamedQueries ({@NamedQuery (name = "findAllBiglietti", query = "" + "SELECT biglietto.id_biglietto " + "FROM " + "Biglietto biglietto JOIN biglietto.distributori_fisico df " + "WHERE df.companyName LIKE :companyName"),

                @NamedQuery (name = "findByVeicle", query = "select d from Biglietto d WHERE d.mezzo =:mezzo"),

            @NamedQuery (name = "findBigliettoByID", query = "SELECT b FROM Biglietto b WHERE b.id_biglietto =:thisIdB "),

        @NamedQuery (name = "vidima", query = "update Biglietto b set b.vidimazione = true where b.id_biglietto = :thisIdb")})
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

    @ManyToOne
    @JoinColumn (name = "mezzo_id", updatable = true, nullable = true)
    private Mezzo mezzo_id;


    //COSTRUTTORI
    public Biglietto() {
    }

    public Biglietto(String tipologia_biglietto) {
        this.id_biglietto = getId_biglietto();
        this.tipologia_biglietto = Tipologia_biglietto.valueOf(tipologia_biglietto);
        this.dataemissioneBiglietto = LocalDate.now();
        this.vidimazione = false;
    }


    public Biglietto(Distributorefisico distributori_fisico) {
        this.distributori_fisico = distributori_fisico;
    }



    /*----------------------< Getter and Setter >---------------------------*/
    // --> GETTER
    public Mezzo getMezzo_id() {
        return mezzo_id;
    }

    public void setMezzo_id(Mezzo mezzo_id) {
        this.mezzo_id = mezzo_id;
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

    public boolean getVidimazione() {
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
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        return "-----------------------------------\n" +
                "ID Biglietto |> " + id_biglietto + "\n" +
                "Biglietto |> " + tipologia_biglietto + "\n" +
                "Mezzo |>" + mezzo + "\n" +
                "Prezzo |> " +  prezzo + "\n"+
                "Timbrato |> " + vidimazione + "\n" +
                /*"Tratta |>" + tratta + "\n" +*/
                "Allle ore: " + LocalTime.now().format(formatter) + "\n" +
                "-----------------------------------";
    }
}


