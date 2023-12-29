package org.example.frames.Scene;

import org.example.frames.FramePrincipale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardContainer extends JPanel {
    JPanel card1;
    JPanel card2;
    JPanel card3;
    CardLayout cardLayout = new CardLayout();
    JPanel cardCont = new JPanel();

    JPanel w;
    Distributoriautomatici ds=new Distributoriautomatici();

    public CardContainer() {
        setLayout(cardLayout);

        JPanel main = new JPanel();
        add(ds);

        card2= new JPanel();
        card3 = new JPanel();


        card2.setBackground(Color.RED);
        card3.setBackground(Color.BLUE);
        main.add(Navpane());
        cardCont.add(main);

        add(main);
        add(ds);
        add(card2);
        add(card3);

        add(cardCont);

        setVisible(true);
    }

    private JPanel Navpane() {
        JPanel navpane = new JPanel();
        JButton about = new JButton("About");
        JButton next = new JButton("Next");

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCardLayout().maximumLayoutSize(FramePrincipale.getFrames()[0]);
                getCardLayout().next(CardContainer.this);
            }
        });



        navpane.add(next);
        navpane.add(about);
        return navpane;
    }

    public JPanel getCard2() {
        return card2;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}

