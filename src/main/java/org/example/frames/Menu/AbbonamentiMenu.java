package org.example.frames.Menu;

import javax.swing.*;
import java.awt.*;

public class AbbonamentiMenu extends JMenuBar {
    private JMenu Abbonamenti;
    public AbbonamentiMenu(){};

    public JMenu getAbbonamentiMenu() {
        Abbonamenti=new JMenu("Abbonamenti");

        JMenuItem AbbonamentiDisponibili=new JMenuItem("Abbonamenti Disponibili");
        JMenuItem CercaAbbonamenti=new JMenuItem("Cerca Abbonamenti");

        Abbonamenti.add(AbbonamentiDisponibili);
        Abbonamenti.add(CercaAbbonamenti);
        Abbonamenti.setForeground(Color.LIGHT_GRAY);
        return Abbonamenti;
    }

}
