package org.example.frames.Scene;

import javax.swing.*;
import java.awt.*;

public class Textarea extends JPanel{
    private JTextArea textarea;
    public Textarea(){
        textarea = new JTextArea();
        setLayout(new BorderLayout());
        add(textarea, BorderLayout.CENTER);
        textarea.setEditable(true);
        textarea.setVisible(true);
        textarea.append("ciao");

    }
}
