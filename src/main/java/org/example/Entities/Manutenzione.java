package org.example.Entities;

import java.time.LocalDate;

public class Manutenzione {
    private int numero_manutenzione;
    private VeicoloType veicoloType;
    private String officina;
    private LocalDate data_inizio;
    private LocalDate data_fine;
    private String descrizione_manutenzione;
    private double costo;

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
}
