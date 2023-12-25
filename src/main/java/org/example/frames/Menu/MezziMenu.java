package org.example.frames.Menu;

import javax.swing.*;

public class MezziMenu extends JMenu {

    public MezziMenu() {
    }

    public JMenu mezziMenu() {
        JMenu Mezzi = new JMenu("Mezzi");

        JMenuItem MezziDisponibili = new JMenuItem("Mezzi Disponibili");
        JMenuItem MezziInManutenzione = new JMenuItem("Mezzi In Manutenzione");
        JMenuItem AggiungiMezzo = new JMenuItem("Aggiungi Mezzo");
        JMenuItem VisualizzaMezzi = new JMenuItem("Visualizza Mezzi");


        Mezzi.add(MezziDisponibili);

        Mezzi.add(MezziInManutenzione);

        Mezzi.add(AggiungiMezzo);

        Mezzi.add(VisualizzaMezzi);

        return Mezzi;
    }

}
