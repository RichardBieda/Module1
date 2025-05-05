package Maze.SwingComponents;

import Maze.FieldLabel.*;
import Maze.Maze;

import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel implements Runnable {

    private final Field[][] fields;

    MazePanel(int y, int x) {
        fields = Maze.createNewMaze(y, x);
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(y, x));
        setOpaque(true);
    }

    void addAllFields() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                add(fields[i][j]);
            }
        }
    }

    @Override
    public void run() {
        addAllFields();
        revalidate();
        repaint();
    }
}
