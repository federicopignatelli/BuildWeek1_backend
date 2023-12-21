package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@Entity
public class Manutenzione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manutenzione_id")
    private Long manutenzioneId;
    @Column ( nullable = false, insertable = true)
    private int numero_manutenzione;
    @Enumerated(EnumType.STRING)
    private MezzoType veicoloType;
    @Column ( nullable = false, insertable = true, length = 30)
    private String officina;
    @Column ( nullable = false, insertable = true, length = 10)
    private LocalDate data_inizio;
    @Column ( nullable = false, insertable = true, length = 10)
    private LocalDate data_fine;
    @Column ( nullable = false, insertable = true, length = 40)
    private String descrizione_manutenzione;
    @Column ( nullable = false, insertable = true)
    private double costo;
    @ManyToOne
    @JoinColumn(name = "mezzi")
    private Mezzo mezzi;
    @Column(name = "targa_mezzo")
    private String targaMezzo;
    /*----------------------< Costruttori >---------------------------*/

    public Manutenzione() {
    }

    public Manutenzione( Mezzo mezzi, String officina, LocalDate data_inizio, LocalDate data_fine, String descrizione_manutenzione) {
        Random rm = new Random();
        this.numero_manutenzione = rm.nextInt(15,1500000);
        this.officina = officina;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.descrizione_manutenzione = descrizione_manutenzione;
        this.costo = 100 + rm.nextInt(901);
        setMezzi(mezzi);
    }

    /*--------------------< Getter and Setter >--------------------------*/

    public int getNumero_manutenzione() {
        return numero_manutenzione;
    }

    public MezzoType getVeicoloType() {
        return veicoloType;
    }

    public String getOfficina() {
        return officina;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public LocalDate getData_fine() {
        return data_fine;
    }

    public String getDescrizione_manutenzione() {
        return descrizione_manutenzione;
    }

    public double getCosto() {
        return costo;
    }

    public void setMezzi(Mezzo mezzi) {
        this.mezzi = mezzi;
        aggiornaTarga();
        aggiornaVeicoloType();
    }

    /*---------------------------< Metodi >-----------------------------*/
    public void aggiornaTarga(){
        if(this.mezzi != null){
            this.targaMezzo =this.mezzi.getTarga();
        } else{
            this.targaMezzo = null ;
        }
    }
    public void aggiornaVeicoloType() {
        if (this.mezzi != null) {
            this.veicoloType = this.mezzi.getMezzoType();
        } else {
            this.veicoloType = null;
        }
    }


    /*---------------------------< Override >-----------------------------*/
    @Override
    public String toString() {
        return "Manutenzione{" +
                "manutenzioneId=" + manutenzioneId +
                ", numero_manutenzione=" + numero_manutenzione +
                ", veicoloType=" + veicoloType +
                ", officina='" + officina + '\'' +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                ", descrizione_manutenzione='" + descrizione_manutenzione + '\'' +
                ", costo=" + costo +
                '}';
    }
}
