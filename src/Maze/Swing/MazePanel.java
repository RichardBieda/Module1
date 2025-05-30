package Maze.Swing;

import Maze.InvalidSizeException;
import javax.swing.*;
import java.awt.*;

import Maze.MazeLabels.EmptyField;
import Maze.MazeLabels.Field;
import Maze.User.Movable;
import Maze.User.User;

class MazePanel extends JPanel {

    private final static int DEFAULT_MAZE_SIZE = 10;
    private final static int DEFAULT_MAZEPANEL_WIDTH = 1120;
    private final static int DEFAULT_MAZEPANEL_HEIGHT = 1020;
    private final static int MIN_MAZE_SIZE = 1;
    private final static int MAX_MAZE_SIZE = 50;
    private final int mazeWidth;
    private final int mazeHeight;
    private Field[][] fields;
    private Movable movable;

    MazePanel() {
        this(DEFAULT_MAZE_SIZE, DEFAULT_MAZE_SIZE);
    }

    MazePanel(int mazeWidth, int mazeHeight) {
        this.mazeWidth = mazeWidth;
        this.mazeHeight = mazeHeight;
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(this.mazeWidth, this.mazeHeight));
        setOpaque(true);
        setPreferredSize(new Dimension(DEFAULT_MAZEPANEL_WIDTH,DEFAULT_MAZEPANEL_HEIGHT));
        movable = User.getMovable(User.PEDESTRIAN);
        setFields();
    }

    static void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < MIN_MAZE_SIZE || sizeX < MIN_MAZE_SIZE || sizeY > MAX_MAZE_SIZE || sizeX > MAX_MAZE_SIZE) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_MAZE_SIZE);
        }
    }

    private void setFields() {
        Field[][] result = new Field[mazeHeight][mazeWidth];
        for (int i = 0; i < mazeHeight; i++) {
            for (int j = 0; j < mazeWidth; j++) {
                Field tmp = new EmptyField();
                tmp.setFX(j);
                tmp.setFY(i);
                result[i][j] = tmp;
                add(tmp);
            }
        }
        fields = result;
    }

    void addMazeAction(MainFrame frame) {
        MazeActionListener mazeActionListener = new MazeActionListener(frame);
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j].addActionListener(mazeActionListener);
            }
        }
    }

    void setMovable(Movable movable) {
        this.movable = movable;
    }

    Movable getMovable() {
        return movable;
    }

    Field[][] getFields() {
        return fields;
    }

    int getMazeWidth() {
        return mazeWidth;
    }

    int getMazeHeight() {
        return mazeHeight;
    }
}
