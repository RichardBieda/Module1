package Maze.Swing;

import Maze.InvalidSizeException;
import javax.swing.*;
import java.awt.*;
import Maze.MazeLabels.EmptyField;
import Maze.MazeLabels.Goal;
import Maze.MazeLabels.Start;
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
    private FieldButton[][] fields;
    private Movable movable;
    private FieldButton start;
    private FieldButton goal;

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
    }

    static void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < MIN_MAZE_SIZE || sizeX < MIN_MAZE_SIZE || sizeY > MAX_MAZE_SIZE || sizeX > MAX_MAZE_SIZE) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_MAZE_SIZE);
        }
    }

    void setFields(MazeActionListener listener) {
        FieldButton[][] result = new FieldButton[mazeHeight][mazeWidth];
        for (int i = 0; i < mazeHeight; i++) {
            for (int j = 0; j < mazeWidth; j++) {
                FieldButton tmp = new FieldButton(new EmptyField());
                tmp.setFX(j);
                tmp.setFY(i);
                tmp.addActionListener(listener);
                result[i][j] = tmp;
                add(tmp);
            }
        }
        fields = result;
    }

    void setMovable(Movable movable) {
        this.movable = movable;
    }

    Movable getMovable() {
        return movable;
    }

    FieldButton[][] getFields() {
        return fields;
    }

    int getMazeWidth() {
        return mazeWidth;
    }

    int getMazeHeight() {
        return mazeHeight;
    }

    FieldButton getStart() {
        return start;
    }

    void setStart(int y, int x) {
        if (this.start != null) {
            fields[this.start.getFY()][this.start.getFX()].setField(new EmptyField());
        }
        fields[y][x].setField(new Start());
        start = fields[y][x];
    }

    FieldButton getGoal() {
        return goal;
    }

    void setGoal(int y, int x) {
        if (this.goal != null) {
            fields[this.goal.getFY()][this.goal.getFX()].setField(new EmptyField());
        }
        fields[y][x].setField(new Goal());
        goal = fields[y][x];
    }
}
