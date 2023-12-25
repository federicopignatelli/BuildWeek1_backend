package org.example.frames.Menu;


import org.example.frames.FramePrincipale;
import org.example.frames.Scene.Distributoriautomatici;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DistributoriMenu{
    private JMenu Distribuzioni;
    private JTextArea text=new JTextArea();
    private Distributoriautomatici distributoriautomatici;

    public DistributoriMenu() {
    }

    public JMenu getDistributoriMenu() {
        Distribuzioni = new JMenu("Distribuzioni");
        JMenuItem menu = new JMenuItem("Distributori Autorizzati");
        JMenuItem menu2 = new JMenuItem("Distributori Automatici");
        menu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                FramePrincipale.getInstance().add(new Distributoriautomatici(),BorderLayout.CENTER);
            }
        });

        Distribuzioni.add(menu);
        Distribuzioni.add(menu2);
        Distribuzioni.setForeground(Color.LIGHT_GRAY);
        return Distribuzioni;
    }
}
