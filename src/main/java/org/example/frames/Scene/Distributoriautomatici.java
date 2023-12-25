package org.example.frames.Scene;

import javax.swing.*;
import java.awt.*;

public class Distributoriautomatici extends JPanel {
    Textarea textPane;
    public Distributoriautomatici(){

        setVisible(false);
        setLayout(new BorderLayout());
        add(textPane = new Textarea(), BorderLayout.CENTER);
    }




}
