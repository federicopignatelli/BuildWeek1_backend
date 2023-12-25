package org.example.frames.Menu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Jmenu extends JMenuBar {
    JMenuBar menubar;
    private MezziMenu mezzi;
    private AbbonamentiMenu abbonamenti;
    private DistributoriMenu distribuzioni;
    private BigliettiMenu biglietti;
    Color DarkGray = new Color(47, 47, 47);
    Border empty;

    public Jmenu() {
    }

    public JMenuBar menubar() {
        menubar = new JMenuBar();
        setBorder(empty);
        mezzi = new MezziMenu();
        abbonamenti = new AbbonamentiMenu();
        biglietti = new BigliettiMenu();
        distribuzioni = new DistributoriMenu();



        menubar.add(mezzi.mezziMenu());
        menubar.add(abbonamenti.getAbbonamentiMenu());
        menubar.add(biglietti.BigliettiMenu());
        menubar.add(distribuzioni.getDistributoriMenu());
        menubar.setBackground(Color.DARK_GRAY);

        return menubar;
    }

}
