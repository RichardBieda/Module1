package Maze.SwingComponents;

import Maze.MazeToLabel;
import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel implements Runnable {

    private int panelX;
    private int panelY;
    private MazeToLabel mazeToLabel;
    MazePanel(int y, int x) {
        panelX = x;
        panelY = y;
        mazeToLabel = new MazeToLabel(panelY, panelX);
        setBackground(new Color(235, 235, 255));
        setLayout(new GridLayout(panelY, panelX));
        setOpaque(true);
    }

    void insertLabels() {
        FieldLabel[][] labels = mazeToLabel.getLabels();
        for (int i = 0; i < panelY; i++) {
            for (int j = 0; j < panelX; j++) {
                add(labels[i][j]);
            }
        }
    }

    @Override
    public void run() {
        insertLabels();
        revalidate();
        repaint();
    }
}
