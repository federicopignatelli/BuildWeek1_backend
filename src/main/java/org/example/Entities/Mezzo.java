package org.example.Entities;

import java.time.LocalDate;

public class Mezzo {
    private Long mezzoId;
    private MezzoType mezzoType;
    private int capienza;
    private Tratta tratte;
    private boolean manutenzione;
    private LocalDate periodo_servizio;
    private int tot_biglietti_vidimati;

    /*----------------------< Costruttori >---------------------------*/
    public Mezzo() {
    }

    public Mezzo( MezzoType mezzoType, int capienza, Tratta tratte, boolean manutenzione, LocalDate periodo_servizio, int tot_biglietti_vidimati) {
        this.mezzoId = getMezzoId();
        this.mezzoType = mezzoType;
        this.capienza = capienza;
        this.tratte = tratte;
        this.manutenzione = manutenzione;
        this.periodo_servizio = periodo_servizio;
        this.tot_biglietti_vidimati = tot_biglietti_vidimati;
    }
    /*--------------------< Getter and Setter >--------------------------*/

    public Long getMezzoId() {
        return mezzoId;
    }

    public MezzoType getMezzoType() {
        return mezzoType;
    }

    public int getCapienza() {
        return capienza;
    }

    public Tratta getTratte() {
        return tratte;
    }

    public boolean isManutenzione() {
        return manutenzione;
    }

    public LocalDate getPeriodo_servizio() {
        return periodo_servizio;
    }

    public int getTot_biglietti_vidimati() {
        return tot_biglietti_vidimati;
    }
    /*---------------------------< Metodi >-----------------------------*/

}
