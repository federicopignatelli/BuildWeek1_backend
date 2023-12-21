package org.example.EntitiesDAO;

import org.example.Entities.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViaggioDAO {
    private final EntityManager em;
    public ViaggioDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Viaggio viaggio) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(viaggio);
        transaction.commit();
        System.out.println("Viaggio " +  " di id: " + viaggio.getId()+ "  aggiunto al db");
    }
    public void delete(Viaggio viaggio) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(viaggio);
        transaction.commit();
        System.out.println("Viaggio " + viaggio.getId()  + " rimosso dal db");
    }

    public List getTotDiTratteDiMezzo(){
        return em.createNamedQuery("Viaggio.totDiTratteDiMezzo").getResultList();
    }
    public List durataSingoliViaggi(){
        return em.createNamedQuery("Viaggio.durataSingoliViaggi").getResultList();
    }
    public void stampaTotTappeEtempoEffTratta(){
        // Ottieni il conteggio totale dei viaggi
        List<Object[]> conteggiViaggi = this.getTotDiTratteDiMezzo();
        Map<Long, Long> mappaConteggiTotali = new HashMap<>();
        for (Object[] conteggio : conteggiViaggi) {
            Long idMezzo = (Long) conteggio[0];
            Long numeroViaggi = (Long) conteggio[1];
            mappaConteggiTotali.put(idMezzo, numeroViaggi);
        }

        // Mappa per tenere traccia del numero sequenziale di ogni viaggio per mezzo
        Map<Long, Integer> mappaConteggiSequenzialiPerMezzo = new HashMap<>();

        // Ottieni la durata di ogni singolo viaggio
        List<Object[]> durateViaggi = this.durataSingoliViaggi();
        for (Object[] durata : durateViaggi) {
            Long idMezzo = (Long) durata[0];
            Long idTratta = (Long) durata[1];
            Double durataViaggio = ((Number) durata[2]).doubleValue();

            // Aggiorna e ottieni il numero sequenziale del viaggio per il mezzo
            int numeroViaggioSequenziale = mappaConteggiSequenzialiPerMezzo.getOrDefault(idMezzo, 0) + 1;
            mappaConteggiSequenzialiPerMezzo.put(idMezzo, numeroViaggioSequenziale);

            System.out.println("Mezzo: " + idMezzo + ", Tratta: " + idTratta + ", Numero Totale Viaggi: " + mappaConteggiTotali.getOrDefault(idMezzo, 0L));
            System.out.println("Durata Viaggio " + numeroViaggioSequenziale + ": " + durataViaggio + " minuti");
            System.out.println("----------------------");
        }
    }
}
