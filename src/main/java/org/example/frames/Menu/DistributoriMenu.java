package org.example.frames.Menu;

import javax.swing.*;
import java.awt.*;

public class DistributoriMenu extends JMenuBar {
    private JMenu Distribuzioni;

    public DistributoriMenu() {
    }

    public JMenu getDistributoriMenu() {
        Distribuzioni = new JMenu("Distribuzioni");
        JMenuItem menu = new JMenuItem("Distributori Autorizzati");
        JMenuItem menu2 = new JMenuItem("Distributori Automatici");

        Distribuzioni.add(menu);
        Distribuzioni.add(menu2);
        Distribuzioni.setForeground(Color.LIGHT_GRAY);
        return Distribuzioni;
    }
}
