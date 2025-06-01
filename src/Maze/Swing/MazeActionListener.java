package Maze.Swing;

import Maze.Fields.Field;
import Maze.Fields.Goal;
import Maze.Fields.Start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        try {
            //xCor < frame.getMainPanel().getMazePanel().getMazeWidth() && yCor < frame.getMainPanel().getMazePanel().getMazeHeight()
            Constructor<?> con = mainPanel.getMenuPanel().getfClass().getConstructor();
           if (mainPanel.getMenuPanel().getfClass() == Start.class) {
               mainPanel.getMazePanel().setStart(yCor, xCor);
               return;
           }
            if (mainPanel.getMenuPanel().getfClass() == Goal.class) {
                mainPanel.getMazePanel().setGoal(yCor, xCor);
                return;
            }
            while (count-- > 0 && xCor < aWidth && yCor < aHeight) {
                Field newField = (Field) con.newInstance();
                mainPanel.getMazePanel().getFields()[yCor][xCor].setField(newField);
                if (mainPanel.getMenuPanel().getOrientation())
                    xCor++;
                else
                    yCor++;
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
