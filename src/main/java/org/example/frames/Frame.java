package org.example.frames;

import org.example.frames.Menu.Jmenu;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private Jmenu menu;
    public Frame() {
        super("Gestione Trasporti");
        menu = new Jmenu();
        setJMenuBar(menu.menubar());





        add(menu, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
