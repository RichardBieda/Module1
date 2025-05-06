package Maze.SwingComponents;

import Maze.FieldLabel.*;
import Maze.Maze;
import Maze.Movable;
import Maze.User.Pedestrian;
import Maze.User.User;

import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel implements Runnable {

    private final Field[][] fields;
    private Movable movable;

    MazePanel(int y, int x) {
        fields = Maze.createNewMaze(y, x);
        movable = User.getMovable(User.PEDESTRIAN);

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

    void setMovable(Movable movable) {
        this.movable = movable;
    }

    Movable getMovable() {
        return movable;
    }

    @Override
    public void run() {
        addAllFields();
        revalidate();
        repaint();
    }
}
