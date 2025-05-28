package Maze.Swing;

import Maze.MazeLabels.FieldGraphics;

import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {

    MenuPanel() {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(3, 0));
        setOpaque(true);
        setPreferredSize(new Dimension(480, 1020));

        JPanel panel1 = new JPanel();
        panel1.setBackground(MainFrame.DEFAULT_BACKGROUND);

        FieldGraphics[] fields = FieldGraphics.values();
        JComboBox<FieldGraphics> box = new JComboBox<>(fields);
        box.setSelectedIndex(6);
        box.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        box.setBackground(Color.WHITE);

        JSlider slider = new JSlider(1, 5, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel1.add(box);
        panel1.add(slider);

        add(panel1);
    }

}
