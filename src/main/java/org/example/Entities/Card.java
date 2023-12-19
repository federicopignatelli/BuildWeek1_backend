package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table (name = "card")
public class Card {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "card_id")
    private Long id;
    @Column (name = "card_number", unique = true, nullable = false, length = 16)
    private String cardNumber;

    @Column (name = "issue_date", nullable = false, length = 10)
    private LocalDate issueDate;
    @Column (name = "stop_date", nullable = false, length = 10)
    private LocalDate stopDate; //Di default +1 anno dalla data di rilascio
    @OneToOne (fetch = FetchType.EAGER)
    private User user;

    @OneToMany (mappedBy = "card")
    private Set<Abbonamento> abbonamenti = new LinkedHashSet<>();




    /*----------------------< Costruttori >---------------------------*/

    public Card() {
    }

    public Card(Long id, String cardNumber, LocalDate issueDate, LocalDate stopDate, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.stopDate = stopDate;
        this.user = user;
    }

    //DA VERIFICARE SE EFFETIVAMENTE SERVE UN COSTRUTTORE SOLO CON LA CARD
    // VERIFICA FATTA DOPO L'IMPLEMENTAZIONE DEI METODI
    public Card(User user) {
        this.user = user;
    }

    /*--------------------< Getter and Setter >--------------------------*/

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public User getUser() {
        return user;
    }

    /*---------------------------< Metodi >-----------------------------*/
}
