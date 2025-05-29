package Maze.Swing;

import javax.swing.*;
import java.awt.*;
import Maze.MazeLabels.Field;
import Maze.User.Movable;
import Maze.Maze;
import Maze.User.User;
public class MazePanel extends JPanel {

    private final static int DEFAULT_MAZE_SIZE = 10;
    private final static int DEFAULT_MAZEPANEL_WIDTH = 1120;
    private final static int DEFAULT_MAZEPANEL_HEIGHT = 1020;

    private int mazeWidth;
    private int mazeHeight;
    private final Field[][] fields;
    private Movable movable;

    MazePanel(int width, int height) {
        this.mazeWidth = width;
        this.mazeHeight = height;
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(mazeWidth, mazeHeight));
        setOpaque(true);
        setPreferredSize(new Dimension(DEFAULT_MAZEPANEL_WIDTH,DEFAULT_MAZEPANEL_HEIGHT));

        fields = Maze.createNewMaze(mazeHeight, mazeWidth);
        movable = User.getMovable(User.PEDESTRIAN);
    }
    MazePanel() {
        this(DEFAULT_MAZE_SIZE, DEFAULT_MAZE_SIZE);
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

    public Movable getMovable() {
        return movable;
    }
}
