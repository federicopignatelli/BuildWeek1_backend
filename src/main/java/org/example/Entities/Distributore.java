package org.example.Entities;

import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "biglietterie")
public class Distributore {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "distributore_seq")
    @SequenceGenerator (name = "distributore_seq", sequenceName = "distributore_seq", allocationSize = 1)
    protected Long idBiglietteria;
    @Column (name = "locazione", nullable = false, length = 50, insertable = true, updatable = true)
    protected String locazione;
    @Column (name = "tipologia", insertable = true, nullable = false)
    @Enumerated (EnumType.STRING)
    protected Tipologia tipologia;

    //da AGGIUNGERE CONTATORE OGNI VOLTA CHE SI AGGIUNGE UN BIGLIETTO


    public Distributore() {
    }

    public Distributore(String locazione, String tipologia) {
        this.locazione = locazione;
        this.tipologia = Tipologia.getName(tipologia);

    }

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


    //--> Setter



    /*---------------------------< Metodi >-----------------------------*/


}
