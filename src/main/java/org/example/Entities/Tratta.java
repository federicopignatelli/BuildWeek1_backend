package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tratta")
public class Tratta {
    @Id
    @GeneratedValue
    private long id_tratta;  // Chiave primaria
        private String zonaPartenza;
        private String capolineaArrivo;
        private LocalDate durataTratta;
        private LocalDate durataMediaPercorsa;
        private double kmTratta;
        private List<String> mezziTratta;

        public Tratta (){
        }

    public Tratta(long id_tratta, String zonaPartenza, String capolineaArrivo, LocalDate durataTratta, LocalDate durataMediaPercorsa, double kmTratta, List<String> mezziTratta) {
        this.id_tratta = id_tratta;
        this.zonaPartenza = zonaPartenza;
        this.capolineaArrivo = capolineaArrivo;
        this.durataTratta = durataTratta;
        this.durataMediaPercorsa = durataMediaPercorsa;
        this.kmTratta = kmTratta;
        this.mezziTratta = mezziTratta;
    }

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

    public LocalDate getDurataTratta() {
        return durataTratta;
    }

    public void setDurataTratta(LocalDate durataTratta) {
        this.durataTratta = durataTratta;
    }

    public LocalDate getDurataMediaPercorsa() {
        return durataMediaPercorsa;
    }

    public void setDurataMediaPercorsa(LocalDate durataMediaPercorsa) {
        this.durataMediaPercorsa = durataMediaPercorsa;
    }

    public double getKmTratta() {
        return kmTratta;
    }

    public void setKmTratta(double kmTratta) {
        this.kmTratta = kmTratta;
    }

    public List<String> getMezziTratta() {
        return mezziTratta;
    }

    public void setMezziTratta(List<String> mezziTratta) {
        this.mezziTratta = mezziTratta;
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
                ", mezziTratta=" + mezziTratta +
                '}';
    }
}
