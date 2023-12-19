package org.example.EntitiesDAO;

import org.example.Entities.Biglietto;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BigliettoDAO {

    EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Biglietto bi, Long idDistributore){




    }

    public void delete(Biglietto bi){}

        private LocalDate dataVidimazione;

        public BigliettoDAO(LocalDate dataVidimazione) {
            this.dataVidimazione = dataVidimazione;
        }

        public LocalDate getDataVidimazione() {
            return dataVidimazione;
        }
    }

    class MezzoDiTrasporto {
        private String nome;
        private List<Biglietto> biglietti;

        public MezzoDiTrasporto(String nome) {
            this.nome = nome;
            this.biglietti = new ArrayList<>();
        }

        public void aggiungiBiglietto(Biglietto biglietto) {
            biglietti.add(biglietto);
        }

        public int contaBigliettiVidimati(LocalDate inizioPeriodo, LocalDate finePeriodo) {
            int conteggio = 0;
            for (Biglietto biglietto : biglietti) {
                LocalDate dataVidimazione = biglietto.getDataVidimazione();
                if (dataVidimazione.isEqual(inizioPeriodo) || (dataVidimazione.isAfter(inizioPeriodo) && dataVidimazione.isBefore(finePeriodo))) {
                    conteggio++;
                }
            }
            return conteggio;
        }
    }


