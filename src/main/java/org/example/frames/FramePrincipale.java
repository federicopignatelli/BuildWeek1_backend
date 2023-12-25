package org.example.frames;

import org.example.frames.Menu.Jmenu;
import org.example.frames.Scene.Distributoriautomatici;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private static FramePrincipale instance;
    private Distributoriautomatici distributoriautomatici;
    private Jmenu menu;
    JPanel panel;

    public FramePrincipale() {
        setTitle("GestioneTrasporti");
        setLayout(new BorderLayout());
        menu = new Jmenu();
        setJMenuBar(menu.menubar());


        add(menu, BorderLayout.PAGE_START);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static FramePrincipale getInstance() {

        return instance.;
    }
    public Distributoriautomatici getDistributoriautomatici() {
        return distributoriautomatici;
    }
}
