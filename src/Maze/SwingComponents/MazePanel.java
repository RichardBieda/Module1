package Maze.SwingComponents;

import Maze.MazeToLabel;
import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel implements Runnable {

    private int panelX;
    private int panelY;
    private MazeLabel[][] labels;
    MazePanel(int y, int x) {
        panelX = x;
        panelY = y;
        labels = new MazeLabel[panelY][panelX];
        setBackground(new Color(235, 235, 255));
        setLayout(new GridLayout(panelY, panelX));
        setOpaque(true);
    }

    void insertLabels() {
        for (int i = 0; i < panelY; i++) {
            for (int j = 0; j < panelX; j++) {
                MazeLabel tmp = new MazeLabel(i, j);
                labels[i][j] = tmp;
                add(tmp);
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
