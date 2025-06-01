package Maze.Swing;

import Maze.Look;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MazeActionListener implements ActionListener {

    private final MainPanel mainPanel;

    MazeActionListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cell tmp = (Cell) e.getSource();
        int xCor = tmp.getCX();
        int yCor = tmp.getCY();

        int aWidth = mainPanel.getMazePanel().getFields()[0].length;
        int aHeight = mainPanel.getMazePanel().getFields().length;

        int count = mainPanel.getMenuPanel().getSlider().getValue();
        Look tmpLook = mainPanel.getMenuPanel().getLooks();
        if (tmpLook == Look.START) {
            mainPanel.getMazePanel().setStart(yCor, xCor);
            return;
        }
        if (tmpLook == Look.GOAL) {
            mainPanel.getMazePanel().setGoal(yCor, xCor);
            return;
        }
        while (count-- > 0 && xCor < aWidth && yCor < aHeight) {
            mainPanel.getMazePanel().getFields()[yCor][xCor].setLook(tmpLook);
            if (mainPanel.getMenuPanel().getOrientation())
                xCor++;
            else
                yCor++;
        }
    }
}
