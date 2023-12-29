package org.example.frames.Menu;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Jmenu extends JMenuBar {
    private MezziMenu mezzi;
    private AbbonamentiMenu abbonamenti;
    private DistributoriMenu distribuzioni;
    private BigliettiMenu biglietti;
    Color DarkGray = new Color(47, 47, 47);
    Border empty;

    public Jmenu() {

        setLayout(new FlowLayout());
        setBorder(empty = BorderFactory.createEmptyBorder());
        mezzi = new MezziMenu();
        abbonamenti = new AbbonamentiMenu();
        biglietti = new BigliettiMenu();
        distribuzioni = new DistributoriMenu();


        add(mezzi.mezziMenu(), FlowLayout.LEFT);
        add(abbonamenti.getAbbonamentiMenu());
        add(biglietti.BigliettiMenu());
        add(distribuzioni.getDistributoriMenu());
        setBackground(Color.DARK_GRAY);

        setVisible(true);
    }



}
