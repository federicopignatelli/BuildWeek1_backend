package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
    @JoinColumn (name = "tratta_id")
    private Tratta tratte;

    @Column
    private LocalTime durata_tratta;
    @Column
    private String targa;

    /*----------------------< Costruttori >---------------------------*/
    public Mezzo() {
    }

    public Mezzo(MezzoType mezzoType, int capienza, LocalDate periodo_servizio) {
        this.mezzoType = mezzoType;
        this.capienza = capienza;
        this.periodo_servizio = periodo_servizio;
//        this.tratte = tratte;
//        this.durata_tratta = tratte.getDurataTratta();
        this.targa = generaTarga();
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

    public void setTratte(Tratta tratte) {
        this.tratte = tratte;
        if (tratte != null) {
            this.durata_tratta = tratte.getDurataTratta();
        }
    }

    /*---------------------------< Metodi >-----------------------------*/
    public static void eseguiTratta(){

    }
    public String generaTarga(){
        Random rm = new Random();
        StringBuilder targa = new StringBuilder(7);
        for(int i = 0; i<2; i++){
            char lettera = (char)('A'+ rm.nextInt(26));
            targa.append(lettera);
        }
        targa.append(" ");
        for(int i = 0; i<3; i++){
            int numero = rm.nextInt(10);
            targa.append(numero);
        }
        targa.append(" ");
        for(int i = 0; i<2; i++){
            char lettera = (char)('A'+ rm.nextInt(26));
            targa.append(lettera);
        }
        return targa.toString();
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
