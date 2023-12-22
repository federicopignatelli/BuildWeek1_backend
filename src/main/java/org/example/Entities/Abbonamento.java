package org.example.Entities;

import org.example.Entities.ENUM.Tipologia_abbonamento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "abbonamenti")
@NamedQueries ({

        @NamedQuery (name = "existsByCardCardNumber", query = "select card from " + "Abbonamento card where " + "card" +
                ".card.cardNumber = :cardNumber"),

        @NamedQuery (name = "abbonamentoDaRinnovare", query = "select a.id_abbondamento from Abbonamento a JOIN a" +
                ".card c WHERE c" + ".stopDate" + " = :localDateNow OR c.stopDate < :localDatenow"),

        @NamedQuery (name = "getAbbonamentoByIdCard", query = "SELECT a.id_abbondamento " + "FROM Abbonamento a " +
                "JOIN Card c ON a.card.id = :thisId " + "WHERE a.dataScadenzaAbbondamento = :thisDate AND c.id = " +
                ":thisId"),

        @NamedQuery (name = "getAbbonamentiScaduti", query = "SELECT a FROM Abbonamento a WHERE a.dataScadenzaAbbondamento = :thisDate")})



/*SELECT id_abbondamento
FROM public.abbonamenti
JOIN public.card ON public.abbonamenti.card_id = public.card.card_id
WHERE datascadenzaabbondamento = '2024-1-22' AND public.card.card_id=5*/

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

    public Abbonamento(LocalDate dataemissioneAbbondamento, String tipologia_abbonamento, Double prezzo, LocalDate dataScadenzaAbbondamento) {
        this.id_abbondamento = getId_abbondamento();
        this.dataemissioneAbbondamento = dataemissioneAbbondamento;
        this.tipologia_abbonamento = Tipologia_abbonamento.getTypeAbb(tipologia_abbonamento);
        this.prezzo = prezzo;
        this.dataScadenzaAbbondamento = dataScadenzaAbbondamento;

    }

    public Long getId_abbondamento() {
        return id_abbondamento;
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

    @Override
    public String toString() {
        return  "id:" + getId_abbondamento()+ "\n"+
                "Prezzo: " + getPrezzo() + "\n" +
                "Scade il: " + getDataScadenzaAbbondamento()
                + "\n" + "Tipologia: " + getTipologia_abbonamento();
    }
}
