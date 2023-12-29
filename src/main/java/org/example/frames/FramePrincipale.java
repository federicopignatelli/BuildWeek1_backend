package org.example.frames;

import org.example.frames.Menu.Jmenu;
import org.example.frames.Scene.CardContainer;
import org.example.frames.Scene.Distributoriautomatici;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FramePrincipale extends JFrame {
    private CardContainer cardContainer;
    private JPanel sezioni;
    private Distributoriautomatici distributoriautomatici;
    private Jmenu menu;
    private JPanel cardContainerPanel=new JPanel();

    public FramePrincipale() {
        setTitle("GestioneTrasporti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        sezioni = new JPanel();
        CardLayout cardLayout = new CardLayout();
        sezioni.setLayout(cardLayout);
        sezioni.setBackground(Color.BLACK);





        setLayout(new BorderLayout());
        add(new Jmenu(), BorderLayout.PAGE_START);
        add(sezioni, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /*public static FramePrincipale getInstance() {

        return instance.;
    }*/
    public Distributoriautomatici getDistributoriautomatici() {
        return distributoriautomatici;
    }
}
