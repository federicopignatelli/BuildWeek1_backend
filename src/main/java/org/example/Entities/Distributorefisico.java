package org.example.Entities;

import org.example.Entities.Interface.iva;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "distributore_fisico")
@NamedQueries ({@NamedQuery (name = "existsByCompanyNameLike", query = "select d " + "from Distributorefisico d " +
        "where" + " d.companyName like :name")})
public class Distributorefisico extends Distributore implements iva {
    @Column (name = "name_company", nullable = false)
    private String companyName;

    @Column (name = "p_iva", unique = true, nullable = false, length = 30)
    private String pIva;
    @OneToMany (mappedBy = "distributori_fisico", cascade = CascadeType.ALL)
    private List<Biglietto> biglietti;

    /*---------------------------< Costruttori >----------------------*/

    public Distributorefisico() {
    }

    public Distributorefisico(String locazione, String tipologia, String companyName) {
        this.idBiglietteria = getIdBiglietteria();
        this.locazione = locazione;
        this.tipologia = Tipologia.getName(tipologia);
        this.companyName = companyName;
        this.pIva = generatePiva();
    }

    /*--------------------< Getter and setter >-----------------------------------*/
    public String getCompanyName() {
        return companyName;
    }
    /*---------------------------< Metodi >----------------------*/


    @Override
    public String generatePiva() {
        StringBuilder stringBuilder = new StringBuilder(16);
        String charateString = "1234567890";
        Set<String> ivaList = new HashSet<>();
        do {
            //mi genera una piva
            for (int i = 0; i < 16; i++) {
                SecureRandom random = new SecureRandom();
                int numRand = random.nextInt(charateString.length());
                stringBuilder.append(charateString.charAt(numRand));
            }
            //controllo che non esista gia
            for (int i = 0; i < ivaList.size(); i++) {
                if (!ivaList.contains(stringBuilder.toString())) {
                    ivaList.add(stringBuilder.toString());
                } else {
                    System.out.println("Esiste già");
                }
            }
            ivaList.add(stringBuilder.toString());
        } while (!ivaList.contains(stringBuilder.toString()));

        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "Distributorefisico{" + "companyName='" + companyName + '\'' + ", pIva='" + pIva + '\'' + ", biglietti"
                + "=" + biglietti + ", idBiglietteria=" + idBiglietteria + ", locazione='" + locazione + '\'' + ", " + "tipologia=" + tipologia + '}';
    }
}
