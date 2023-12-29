package org.example.frames.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Distributoriautomatici extends JPanel {
    Textarea textPane;
    JTextField inputPane;
    //Creo nuove cards da aggiungere al panelCardCOntainer
    JPanel distributoreAutomaticoCard = new JPanel();

    public Distributoriautomatici() {
        inputPane = new JTextField();
        inputPane.setColumns(30);
        inputPane.setPreferredSize(new Dimension(300, 30));


        add(inputPane, BorderLayout.WEST);
        setVisible(true);
    }

}
