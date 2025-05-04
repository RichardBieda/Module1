package Maze.SwingComponents;

import Maze.Fields.Field;
import Maze.Graphics.UIView;

import javax.swing.*;
import java.awt.*;

public class FieldLabel extends JLabel {

    public FieldLabel(Field field) {
        setBackground(UIView.getLabelColor(field));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setOpaque(true);
    }
}
