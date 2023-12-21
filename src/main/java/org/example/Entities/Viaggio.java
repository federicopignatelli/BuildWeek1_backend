package org.example.Entities;

import org.example.Entities.Mezzo;
import org.example.Entities.Tratta;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;
    @Column(name = "targa_mezzo")
    private String targaMezzo;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    private LocalDateTime oraPartenza;
    private LocalDateTime oraArrivo;


    public Viaggio() {
    }

    public Long getId() {
        return id;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public LocalDateTime getOraPartenza() {
        return oraPartenza;
    }

    public LocalDateTime getOraArrivo() {
        return oraArrivo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public void setOraPartenza(LocalDateTime oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public void setOraArrivo(LocalDateTime oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public void aggiornaTargaMezzo(){
        if(this.mezzo != null){
            this.targaMezzo =this.mezzo.getTarga();
        } else{
            this.targaMezzo = null ;
        }
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", tratta=" + tratta +
                ", oraPartenza=" + oraPartenza +
                ", oraArrivo=" + oraArrivo +
                '}';
    }
}
