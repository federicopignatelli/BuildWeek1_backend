package org.example.frames.Menu;

import javax.swing.*;
import java.awt.*;

public class BigliettiMenu extends JMenuBar {
    private JMenu Biglietti;
    public BigliettiMenu() {
    }

    public JMenu BigliettiMenu() {
        Biglietti=new JMenu("Biglietti");

        JMenuItem AggiungiBiglietto = new JMenuItem("Aggiungi Biglietto");
        JMenuItem VisualizzaBiglietto = new JMenuItem("Visualizza Biglietti");

        Biglietti.add(VisualizzaBiglietto);
        Biglietti.add(AggiungiBiglietto);
        Biglietti.setForeground(Color.LIGHT_GRAY);
        return Biglietti;
    }
}
