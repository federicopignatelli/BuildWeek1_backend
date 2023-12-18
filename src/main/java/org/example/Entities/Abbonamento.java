package org.example.Entities;

import org.example.Entities.ENUM.Tipologia_abbonamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Abbonamento {
    @Id
    @GeneratedValue
    private Long id_abbondamento;
    private User user;
    private LocalDate dataemissioneAbbondamento;
    private Tipologia_abbonamento tipologia_abbonamento;
    private Mezzo mezzo;
    private Tratta tratta;
    private Double prezzo;
    private LocalDate dataScadenzaAbbondamento;

    public Abbonamento() {
    }

    public Abbonamento(User user, LocalDate dataemissioneAbbondamento, Tipologia_abbonamento tipologia_abbonamento, Mezzo mezzo, Tratta tratta, Double prezzo, LocalDate dataScadenzaAbbondamento) {
        this.id_abbondamento = getId_abbondamento();
        this.user = user;
        this.dataemissioneAbbondamento = dataemissioneAbbondamento;
        this.tipologia_abbonamento = tipologia_abbonamento;
        this.mezzo = mezzo;
        this.tratta = tratta;
        this.prezzo = prezzo;
        this.dataScadenzaAbbondamento = dataScadenzaAbbondamento;
    }

    public Long getId_abbondamento() {
        return id_abbondamento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDataemissioneAbbondamento() {
        return dataemissioneAbbondamento;
    }

    public void setDataemissioneAbbondamento(LocalDate dataemissioneAbbondamento) {
        this.dataemissioneAbbondamento = dataemissioneAbbondamento;
    }

    public Tipologia_abbonamento getTipologia_abbonamento() {
        return tipologia_abbonamento;
    }

    public void setTipologia_abbonamento(Tipologia_abbonamento tipologia_abbonamento) {
        this.tipologia_abbonamento = tipologia_abbonamento;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public LocalDate getDataScadenzaAbbondamento() {
        return dataScadenzaAbbondamento;
    }

    public void setDataScadenzaAbbondamento(LocalDate dataScadenzaAbbondamento) {
        this.dataScadenzaAbbondamento = dataScadenzaAbbondamento;
    }
}
