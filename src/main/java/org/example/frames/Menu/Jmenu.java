package org.example.frames.Menu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Jmenu extends JMenuBar {

    private MezziMenu mezzi;
    private AbbonamentiMenu abbonamenti;
    Color DarkGray = new Color(47, 47, 47);
    Border empty;

    public Jmenu() {
        empty = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    }
    public JMenuBar menubar() {
        setBorder(empty);
        mezzi=new MezziMenu();
        abbonamenti=new AbbonamentiMenu();
        JMenu Distribuzioni = new JMenu("Distribuzioni");
        JMenu Biglietti = new JMenu("Biglietti");

        /*Abbonamenti*/
        JMenuItem AggiungiBiglietto = new JMenuItem("Aggiungi Biglietto");
        JMenuItem VisualizzaBiglietto = new JMenuItem("Visualizza Biglietti");
        /*Biglietti*/

        /*Mezzi*/
        JMenuItem MezziDisponibili = new JMenuItem("Mezzi Disponibili");
        JMenuItem MezziInManutenzione = new JMenuItem("Mezzi In Manutenzione");
        JMenuItem AggiungiMezzo = new JMenuItem("Aggiungi Mezzo");
        JMenuItem VisualizzaMezzi = new JMenuItem("Visualizza Mezzi");
        /*Distributori*/
        JMenuItem DistributoriAutorizzati = new JMenuItem("Distributori Autorizzati");
        JMenuItem DistributoriAutomatici = new JMenuItem("Distributori Automatici");


        Distribuzioni.add(DistributoriAutorizzati);
        Distribuzioni.add(DistributoriAutomatici);


        Biglietti.add(VisualizzaBiglietto);
        Biglietti.add(AggiungiBiglietto);


        add(mezzi.mezziMenu());
        add(abbonamenti.getAbbonamentiMenu());
        add(Distribuzioni);
        add(Biglietti);


        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setBackground(Color.DARK_GRAY);
        return menubar();
    }

}
