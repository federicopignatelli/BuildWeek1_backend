package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column (name = "user_name", nullable = false, insertable = true, length = 30)
    private String userName;

    @Column (name = "user_last_name", nullable = false, insertable = true, length = 30)
    private String userLastName;

    @Column (name = "birth_date", nullable = false, insertable = true, length = 10)
    LocalDate birthDate;

    @Column (name = "residential_address", nullable = false, insertable = true, length = 100)
    private String residentialAddress;

    //FETCH TYPE EAGER PERCHE VOGLIO RECUPERARE ANCHE I DATI RELATIVI ALLA TESSERE UTENTE
    @OneToOne (fetch = FetchType.EAGER)
    private Card card;

    @OneToMany (fetch = FetchType.LAZY , mappedBy = "users")
    private List<Biglietto> biglietto;

    /*----------------------< Costruttori >---------------------------*/
    public User() {
    }

    public User(String userName, String userLastName, LocalDate birthDate, String residentialAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.birthDate = birthDate;
        this.residentialAddress = residentialAddress;

    }

    //DA VERIFICARE SE EFFETIVAMENTE SERVE UN COSTRUTTORE SOLO CON LA CARD
    // VERIFICA FATTA DOPO L'IMPLEMENTAZIONE DEI METODI
    public User(Card card) {
        this.card = card;
    }

    /*--------------------< Getter and Setter >--------------------------*/
    //--> GETTER
    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public Card getCard() {
        return card;
    }


    /*---------------------------< Metodi >-----------------------------*/

}
