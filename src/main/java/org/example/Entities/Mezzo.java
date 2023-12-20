package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {
    @Id
    @GeneratedValue
    @Column (name = "mezzo_id")
    private Long mezzoId;
    @Enumerated(EnumType.STRING)
    private MezzoType mezzoType;
    @Column ( nullable = false, insertable = true)
    private int capienza;
//    @ManyToOne
//    @JoinColumn(name = "mezzi_tratta")
//    private Tratta tratte;
//    @ManyToOne
//    @JoinColumn(name = "mezzi_tratta")
//    private boolean manutenzione;
    @Column ( nullable = false, insertable = true, length = 10)
    private LocalDate periodo_servizio;
    @Column ( nullable = false, insertable = true)
    private int tot_biglietti_vidimati;
    @OneToMany(mappedBy = "mezzi")
    private List<Manutenzione> manutenzione;
    @ManyToOne
    @JoinColumn (name = "tratte")
    private Tratta tratte;

    @Column
    private LocalTime durata_tratta;

    /*----------------------< Costruttori >---------------------------*/
    public Mezzo() {
    }

    public Mezzo(MezzoType mezzoType, int capienza, LocalDate periodo_servizio, Tratta tratte) {
        this.mezzoType = mezzoType;
        this.capienza = capienza;
        this.periodo_servizio = periodo_servizio;
        this.tratte = tratte;
        this.durata_tratta = tratte.getDurataTratta();
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

/*    public Tratta getTratte() {
        return tratte;
    }

    public boolean isManutenzione() {
        return manutenzione;
    }*/

    public LocalDate getPeriodo_servizio() {
        return periodo_servizio;
    }

    public int getTot_biglietti_vidimati() {
        return tot_biglietti_vidimati;
    }
    /*---------------------------< Metodi >-----------------------------*/
    public static void eseguiTratta(){

    }


    /*---------------------------< Override >-----------------------------*/
    @Override
    public String toString() {
        return "Mezzo{" +
                "mezzoId=" + mezzoId +
                ", mezzoType=" + mezzoType +
                ", capienza=" + capienza +
                /*", tratte=" + tratte +
                ", manutenzione=" + manutenzione +*/
                ", periodo_servizio=" + periodo_servizio +
                ", tot_biglietti_vidimati=" + tot_biglietti_vidimati +
                '}';
    }
}
