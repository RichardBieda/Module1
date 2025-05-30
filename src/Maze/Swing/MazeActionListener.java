package Maze.Swing;

import Maze.MazeLabels.EmptyField;
import Maze.MazeLabels.Field;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MazeActionListener implements ActionListener {

    private final int aWidth;
    private final int aHeight;
    private final MazePanel mazePanel;
    private boolean ori = true;
    private int sliderValue = 1;
    private Class<? extends Field> aClass = EmptyField.class;
    MazeActionListener(MazePanel mazePanel) {
        this.aWidth = mazePanel.getMazeWidth();
        this.aHeight = mazePanel.getMazeHeight();
        this.mazePanel = mazePanel;
        System.out.println("constructor " + aWidth + " " + aHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Field tmp = (Field) e.getSource();
        int xCor = tmp.getFX();
        int yCor = tmp.getFY();

        int count = sliderValue;
        try {
            //xCor < frame.getMainPanel().getMazePanel().getMazeWidth() && yCor < frame.getMainPanel().getMazePanel().getMazeHeight()
            Constructor<?> con = aClass.getConstructor();
            System.out.println("while " + aWidth + " " + aHeight);
            while (count-- > 0 && xCor < aWidth && yCor < aHeight) {
                Field newField = (Field) con.newInstance();
                newField.addActionListener(this);
                mazePanel.getFields()[yCor][xCor] = newField;
                if (ori)
                    xCor++;
                else
                    yCor++;
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    void setOri(boolean ori) {
        this.ori = ori;
    }

    void setSliderValue(int sliderValue) {
        this.sliderValue = sliderValue;
    }

    void setAClass(Class<? extends Field> aClass) {
        this.aClass = aClass;
    }
}
