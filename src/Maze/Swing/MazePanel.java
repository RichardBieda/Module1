package Maze.Swing;

import Maze.Fields.*;
import Maze.InvalidSizeException;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import Maze.User.Movable;
import Maze.User.User;

class MazePanel extends JPanel {

    private final static int DEFAULT_MAZEPANEL_WIDTH = 1120;
    private final static int DEFAULT_MAZEPANEL_HEIGHT = 1020;
    final static int DEFAULT_MAZE_SIZE = 10;
    private final static int MIN_MAZE_SIZE = 1;
    private final static int MAX_MAZE_SIZE = 50;
    private Cell[][] fields;
    private Cell start;
    private Cell goal;


    MazePanel(int width, int height) {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setOpaque(true);
        setPreferredSize(new Dimension(DEFAULT_MAZEPANEL_WIDTH,DEFAULT_MAZEPANEL_HEIGHT));
        setLayout(new GridLayout(height, width));
    }

    static void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < MIN_MAZE_SIZE || sizeX < MIN_MAZE_SIZE || sizeY > MAX_MAZE_SIZE || sizeX > MAX_MAZE_SIZE) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_MAZE_SIZE);
        }
    }

    void createMaze(int width, int height, MazeActionListener listener) {
        Cell[][] result = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell tmp = new Cell(new EmptyField(), i, j);
                tmp.addActionListener(listener);
                result[i][j] = tmp;
                add(tmp);
            }
        }
        fields = result;
    }

    void insertPathToMaze(List<Cell> path) {
        for (Cell c : path) {
            c.setField(new Path());
        }
    }

    void refreshCells() {
        for (Cell[] field : fields) {
            for (int j = 0; j < field.length; j++) {
                field[j].setCaller(null);
                field[j].setChecked(false);
            }
        }
    }

    Cell[][] getFields() {
        return fields;
    }

    Cell getStart() {
        return start;
    }

    void setStart(int y, int x) {
        if (this.start != null) {
            fields[this.start.getCY()][this.start.getCX()].setField(new EmptyField());
        }
        fields[y][x].setField(new Start());
        start = fields[y][x];
    }

    Cell getGoal() {
        return goal;
    }

    void setGoal(int y, int x) {
        if (this.goal != null) {
            fields[this.goal.getCY()][this.goal.getCX()].setField(new EmptyField());
        }
        fields[y][x].setField(new Goal());
        goal = fields[y][x];
    }
}
