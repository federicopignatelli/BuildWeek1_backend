package org.example.Entities.Interface;

import org.example.Entities.Biglietto;
import org.example.Entities.Distributorefisico;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public interface Emissione {
    Biglietto emettiBiglietto(String tipologia, Double price);
}
