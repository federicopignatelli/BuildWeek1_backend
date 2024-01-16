package org.example.frames.View.SidePAnel;

import javax.swing.*;

public class SidePanel extends JPanel {

    public SidePanel() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(new SideComp("Gestione parco Mezzi"));

    }
}
