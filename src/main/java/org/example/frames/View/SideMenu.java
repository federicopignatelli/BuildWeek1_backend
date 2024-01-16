package org.example.frames.View;

import org.example.frames.View.JmenuItem.JmenuCreator;

import javax.swing.*;
import java.awt.*;

public class SideMenu extends JMenuBar {


    public SideMenu() {

        JmenuCreator file = new JmenuCreator("File");
        JmenuCreator edit = new JmenuCreator("Edit");
        JmenuCreator settings = new JmenuCreator("Settings");
        JmenuCreator info = new JmenuCreator("Info");

        add(file);
        add(edit);
        add(settings);
        add(info);
        //Style JMenu
        file.setForeground(Color.LIGHT_GRAY);
        edit.setForeground(Color.LIGHT_GRAY);
        settings.setForeground(Color.LIGHT_GRAY);
        info.setForeground(Color.LIGHT_GRAY);
        //Style barra
        setBackground(Color.DARK_GRAY);

    }
}
