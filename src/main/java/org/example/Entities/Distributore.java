package org.example.Entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "biglietterie")
public abstract class Distributore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distributore_seq")
    @SequenceGenerator(name = "distributore_seq", sequenceName = "distributore_seq", allocationSize = 1)
    protected Long idBiglietteria;
    @Column (name = "locazione", nullable = false, length = 50, insertable = true, updatable = true)
    protected String locazione;
    @Column (name = "tipologia",insertable = true, nullable = false)
    @Enumerated(EnumType.STRING)
    protected Tipologia tipologia;
    @Column(name = "biglietti_venduti", columnDefinition = "INTEGER DEFAULT 0", nullable = false, insertable = true, updatable = true)
    protected long bigliettivenduti;
    //da AGGIUNGERE CONTATORE OGNI VOLTA CHE SI AGGIUNGE UN BIGLIETTO
    @Column(name = "abbonamenti_venduti", columnDefinition = "INTEGER DEFAULT 0", nullable = false, insertable = true, updatable = true)
    protected long abbonamentiVenduti;

    @OneToMany(mappedBy = "biglietterie")
    private List<Biglietto> biglietti;

    public Distributore() {}

    /*----------------------< Getter and Setter >---------------------------*/
    //--> Getter
    public Long getIdBiglietteria() {
        return idBiglietteria;
    }

    public String getLocazione() {
        return locazione;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public long getBigliettivenduti() {
        return bigliettivenduti;
    }

    public long getAbbonamentiVenduti() {
        return abbonamentiVenduti;
    }
    //--> Setter

    /*---------------------------< Metodi >-----------------------------*/



}
