package org.example.Entities;

import org.example.Entities.ENUM.Tipologia_abbonamento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "abbonamenti")
@NamedQueries ({@NamedQuery (name = "existsByCardCardNumber", query = "select card from " +
        "Abbonamento card where card.card.cardNumber = :cardNumber")})

public class Abbonamento {
    @Id
    @GeneratedValue
    private Long id_abbondamento;

    private LocalDate dataemissioneAbbondamento;
    @Enumerated (EnumType.STRING)
    private Tipologia_abbonamento tipologia_abbonamento;
    private Double prezzo;
    private LocalDate dataScadenzaAbbondamento;

    @ManyToOne
    @JoinColumn (name = "tratte")
    private Tratta tratte;

    @ManyToOne
    @JoinColumn (name = "distributore_automatico")
    private Distributoreautomatico distributoreautomatico;
    @ManyToOne
    @JoinColumn (name = "distributore_fisico")
    private Distributorefisico distributorefisico;

    @ManyToOne (optional = false)
    @JoinColumn (name = "card_id", nullable = false)
    private Card card;


    public Abbonamento() {
    }

    public Abbonamento(/*User user,*/ LocalDate dataemissioneAbbondamento,
                                      Tipologia_abbonamento tipologia_abbonamento, Double prezzo,
                                      LocalDate dataScadenzaAbbondamento) {
        this.id_abbondamento = getId_abbondamento();
        this.dataemissioneAbbondamento = dataemissioneAbbondamento;
        this.tipologia_abbonamento = tipologia_abbonamento;
        this.prezzo = prezzo;
        this.dataScadenzaAbbondamento = dataScadenzaAbbondamento;

    }

    public Long getId_abbondamento() {
        return id_abbondamento;
    }

   /* public User getUser() {
        return user;
    }*/

    /*public void setUser(User user) {
        this.user = user;
    }*/

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

    public void setDistributorefisico(Distributorefisico distributorefisico) {
        this.distributorefisico = distributorefisico;
    }

    public void setDistributoreautomatico(Distributoreautomatico distributoreautomatico) {
        this.distributoreautomatico = distributoreautomatico;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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
//    public Mezzo getMezzo() {
//        return mezzo;
//    }

//    public void setMezzo(Mezzo mezzo) {
//        this.mezzo = mezzo;
//    }

/*    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }*/

}
