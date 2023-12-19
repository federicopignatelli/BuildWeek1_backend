package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Manutenzione {
    @Id
    @Column(name = "manutenzione_id")
    private Long manutenzioneId;
    @Column ( nullable = false, insertable = true)
    private int numero_manutenzione;
    @Enumerated(EnumType.STRING)
    private VeicoloType veicoloType;
    @Column ( nullable = false, insertable = true, length = 30)
    private String officina;
    @Column ( nullable = false, insertable = true, length = 10)
    private LocalDate data_inizio;
    @Column ( nullable = false, insertable = true, length = 10)
    private LocalDate data_fine;
    @Column ( nullable = false, insertable = true, length = 20)
    private String descrizione_manutenzione;
    @Column ( nullable = false, insertable = true)
    private double costo;
    @ManyToOne
    @JoinColumn(name = "manutenzione")
    private Mezzo mezzi;
    /*----------------------< Costruttori >---------------------------*/

    public Manutenzione() {
    }

    public Manutenzione( VeicoloType veicoloType, String officina, LocalDate data_inizio, LocalDate data_fine, String descrizione_manutenzione, double costo) {
        this.numero_manutenzione = getNumero_manutenzione();
        this.veicoloType = veicoloType;
        this.officina = officina;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.descrizione_manutenzione = descrizione_manutenzione;
        this.costo = costo;
    }

    /*--------------------< Getter and Setter >--------------------------*/

    public int getNumero_manutenzione() {
        return numero_manutenzione;
    }

    public VeicoloType getVeicoloType() {
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
    /*---------------------------< Metodi >-----------------------------*/





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
