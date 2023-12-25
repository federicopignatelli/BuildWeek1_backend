package org.example.frames.Menu;

import javax.swing.*;

public class AbbonamentiMenu extends JMenu {
    private JMenu Abbonamenti;
    public AbbonamentiMenu(){};

    public JMenu getAbbonamentiMenu() {
        Abbonamenti=new JMenu("Abbonamenti");

        JMenuItem AbbonamentiDisponibili=new JMenuItem("Abbonamenti Disponibili");
        JMenuItem CercaAbbonamenti=new JMenuItem("Cerca Abbonamenti");

        add(AbbonamentiDisponibili);
        add(CercaAbbonamenti);

        return Abbonamenti;
    }

}
