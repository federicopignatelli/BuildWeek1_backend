package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tratta;  // Chiave primaria
    @Column(name = "zona_partenza",nullable = false)
        private String zonaPartenza;
    @Column(name = "capolinea_arrivo",nullable = false)
        private String capolineaArrivo;
    @Column(name = "durata_tratta",nullable = false)
        private LocalTime durataTratta;
    @Column(name = "durata_media_percorsa",nullable = true)
        private LocalTime durataMediaPercorsa;
    @Column(name = "km_tratta",precision = 10, scale=2)
        private double kmTratta;
//        private List<Mezzo> mezziTratta;
@ManyToMany(mappedBy = "tratte")
private List <Mezzo> mezzi = new ArrayList<>();

@ManyToOne
@JoinColumn (name = "biglietti")
private Biglietto biglietti;

@OneToMany(mappedBy="tratte")
private List<Abbonamento> abbonamenti;
@OneToMany(mappedBy = "tratta")
private List<Viaggio> viaggi = new ArrayList<>();

    /*----------------------< Costruttori >---------------------------*/

    public Tratta (){
        }

    public Tratta( String zonaPartenza, String capolineaArrivo, LocalTime durataTratta, double kmTratta) {
        this.zonaPartenza = zonaPartenza;
        this.capolineaArrivo = capolineaArrivo;
        this.durataTratta = durataTratta;
        this.kmTratta = kmTratta;
    }
    /*--------------------< Getter and Setter >--------------------------*/

    public long getId_tratta() {
        return id_tratta;
    }

    public void setId_tratta(long id_tratta) {
        this.id_tratta = id_tratta;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolineaArrivo() {
        return capolineaArrivo;
    }

    public void setCapolineaArrivo(String capolineaArrivo) {
        this.capolineaArrivo = capolineaArrivo;
    }

    public LocalTime getDurataTratta() {
        return durataTratta;
    }

    public void setDurataTratta(LocalTime durataTratta) {
        this.durataTratta = durataTratta;
    }

    public LocalTime getDurataMediaPercorsa() {
        return durataMediaPercorsa;
    }

    public void setDurataMediaPercorsa(LocalTime durataMediaPercorsa) {
        this.durataMediaPercorsa = durataMediaPercorsa;
    }

    public List<Mezzo> getMezzi() {
        return mezzi;
    }

    public double getKmTratta() {
        return kmTratta;
    }

    public void setKmTratta(double kmTratta) {
        this.kmTratta = kmTratta;
    }

/*    public List<Mezzo> getMezziTratta() {
        return mezziTratta;
    }

    public void setMezziTratta(List<Mezzo> mezziTratta) {
        this.mezziTratta = mezziTratta;
    }*/


/*---------------------------< Metodi >-----------------------------*/
    public void addViaggio(Viaggio viaggio){
        viaggi.add(viaggio);
        viaggio.setTratta(this);
    }
public void addMezzo(Mezzo mezzo){
    mezzi.add(mezzo);
    if(mezzi==null){
        mezzi = new ArrayList<>();
    }
    mezzi.add(mezzo);
    if(!mezzo.getTratte().contains(this)){
        mezzo.addTratta(this);
    }
}

    @Override
    public String toString() {
        return "Tratta{" +
                "id_tratta=" + id_tratta +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", capolineaArrivo='" + capolineaArrivo + '\'' +
                ", durataTratta=" + durataTratta +
                ", durataMediaPercorsa=" + durataMediaPercorsa +
                ", kmTratta=" + kmTratta +
//                ", mezziTratta=" + mezziTratta +
                '}';
    }
}
