package Maze.SwingComponents;

import Maze.Graphics.UIView;

import javax.swing.*;
import java.awt.*;

public class MazeLabel extends JLabel {

    private int y;
    private int x;
    public MazeLabel(int y, int x) {
        this.y = y;
        this.x = x;
        setBackground(UIView.EMPTY_FIELD.getCOLOR());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setOpaque(true);
    }
}
