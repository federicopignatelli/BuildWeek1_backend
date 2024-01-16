package org.example.frames.View.SidePAnel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SideComp extends JPanel {
    private JLabel label;

    public SideComp(String lableText) {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        label = new JLabel(lableText);
        add(label);

        addOption("Mezzi");
        addOption("Mezzi in manutenzione");
        addOption("Manutenzioni");
        addOption("Tratte");
    }

    public void addOption(String option){
        JButton optionBtn=new JButton(option);

        optionBtn.setOpaque(false);
        optionBtn.setContentAreaFilled(false);

        Border empty=new EmptyBorder(0,0,0,0);


        optionBtn.setBorder(empty);
        add(optionBtn);
    }
}
