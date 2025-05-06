package Maze.SwingComponents;

import Maze.FieldLabel.Field;
import Maze.Graphics.UIView;

import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {

    MenuPanel() {
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(3, 0));
        setOpaque(true);

        JPanel panel1 = new JPanel();
        panel1.setBackground(MazeUI.DEFAULT_BACKGROUND);
        UIView[] fields = UIView.values();
        JComboBox<UIView> box = new JComboBox<>(fields);
        box.setSelectedIndex(6);
        JSlider slider = new JSlider();
        panel1.add(box);
        panel1.add(slider);

        add(panel1);
    }
}
