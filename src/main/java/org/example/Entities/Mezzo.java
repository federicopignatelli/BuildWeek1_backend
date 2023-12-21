package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "mezzi")
public class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "mezzo_id")
    private Long mezzoId;
    @Enumerated(EnumType.STRING)
    private MezzoType mezzoType;
    @Column ( nullable = false, insertable = true)
    private int capienza;
    @Column ( nullable = false, insertable = true)
    private int tot_biglietti_vidimati;
    @OneToMany(mappedBy = "mezzi")
    private List<Manutenzione> manutenzione = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "mezzo_tratta",
            joinColumns = @JoinColumn(name = "mezzo_id"),
            inverseJoinColumns = @JoinColumn(name = "tratta_id")
    )
    private List<Tratta> tratte = new ArrayList<>();

    @Column(unique = true)
    private String targa;
    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi = new ArrayList<>();

    /*----------------------< Costruttori >---------------------------*/
    public Mezzo() {
    }

    public Mezzo(MezzoType mezzoType, int capienza) {
        this.mezzoType = mezzoType;
        this.capienza = capienza;
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

    public List<Tratta> getTratte() {
        return tratte;
    }
    public int getTot_biglietti_vidimati() {
        return tot_biglietti_vidimati;
    }

    public void setTratte(List<Tratta> tratte) {
        this.tratte = tratte;
    }
    public void addTratta(Tratta tratta){
        if(tratte == null){
            tratte = new ArrayList<>();
        }
        tratte.add(tratta);
        if(!tratta.getMezzi().contains(this)){
            tratta.addMezzo(this);
        }
    }

    public String getTarga(){return targa;}

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    /*---------------------------< Metodi >-----------------------------*/
    public void addViaggio(Viaggio viaggio){
        viaggi.add(viaggio);
        viaggio.setMezzo(this);
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

    public void addManutenzione(Manutenzione newMan){
        if(manutenzione == null){
            manutenzione = new ArrayList<>();
        }
        manutenzione.add(newMan);
        newMan.setMezzi(this);
        System.out.println("Il Mezzo ora si trova in manutenzione!");
    }
    /*---------------------------< Override >-----------------------------*/

    @Override
    public String toString() {
        return "Mezzo{" +
                "mezzoId=" + mezzoId +
                ", mezzoType=" + mezzoType +
                ", capienza=" + capienza +
                ", tot_biglietti_vidimati=" + tot_biglietti_vidimati +
                ", manutenzione=" + manutenzione +
                ", tratte=" + tratte +
                ", targa='" + targa + '\'' +
                ", viaggi=" + viaggi +
                '}';
    }
}
