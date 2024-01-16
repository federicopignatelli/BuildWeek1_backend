package org.example.frames;

import org.example.frames.View.SideMenu;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private SideMenu menu=new SideMenu();



    public FramePrincipale() {
        super("GestioneTrasporti");
        setLayout(new BorderLayout());



        setJMenuBar(menu);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}


