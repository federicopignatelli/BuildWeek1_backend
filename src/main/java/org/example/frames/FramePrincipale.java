package org.example.frames;

import org.example.frames.View.SideMenu;
import org.example.frames.View.SidePAnel.SidePanel;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private SideMenu menu=new SideMenu();
    private SidePanel sidePanel=new SidePanel();


    public FramePrincipale() {
        super("GestioneTrasporti");
        setLayout(new BorderLayout());


        add(sidePanel, BorderLayout.WEST);




        setJMenuBar(menu);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}


