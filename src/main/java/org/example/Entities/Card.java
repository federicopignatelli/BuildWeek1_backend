package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table (name = "card")
@NamedQueries ({@NamedQuery (name = "getCard", query = "select c from Card c where c.cardNumber = :cardNumber")})
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

    public Card( LocalDate issueDate, User user) {
        this.cardNumber = genCardNumber();
        this.issueDate = issueDate;
        this.stopDate = issueDate.plusYears(1);
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

    public void setUser(User user) {
        this.user = user;
    }


    /*---------------------------< Metodi >-----------------------------*/

    public String genCardNumber() {
        Random random = new Random();
        String codiceMacchina = "";
        String characters = "1234567890";
        for (int i = 0; i < 8; i++) {
            codiceMacchina += characters.charAt(random.nextInt(1, 10));
        }
        System.out.println(codiceMacchina);
        return codiceMacchina;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", issueDate=" + issueDate +
                ", stopDate=" + stopDate +
                ", user=" + user +
                ", abbonamenti=" + abbonamenti +
                '}';
    }
}
