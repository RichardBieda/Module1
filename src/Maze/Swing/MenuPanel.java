package Maze.Swing;

import Maze.MazeLabels.FieldGraphics;

import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {

    MenuPanel() {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(3, 0));
        setOpaque(true);
//        setSize(new Dimension(480, 1020));
        setPreferredSize(new Dimension(480, 1020));
//        setMaximumSize(new Dimension(480, 1020));
//        setMinimumSize(new Dimension(480, 1020));
        JPanel panel1 = new JPanel();
        panel1.setBackground(MainFrame.DEFAULT_BACKGROUND);

        FieldGraphics[] fields = FieldGraphics.values();
        JComboBox<FieldGraphics> box = new JComboBox<>(fields);
        box.setSelectedIndex(6);

        JSlider slider = new JSlider();

        panel1.add(box);
        panel1.add(slider);

        add(panel1);
    }

}
