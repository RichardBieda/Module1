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
    MazeActionListener(int aWidth, int aHeight, MazePanel mazePanel) {
        this.aWidth = aWidth;
        this.aHeight = aHeight;
        this.mazePanel = mazePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("start");
        Field tmp = (Field) e.getSource();
        int xCor = tmp.getFX();
        int yCor = tmp.getFY();
        System.out.println("inits: " + tmp + "--" + xCor + "--" + yCor + "--" + ori);

        int count = sliderValue;
        System.out.println("getFieldClass: " + aClass + " -- " + count);
        try {
            //xCor < frame.getMainPanel().getMazePanel().getMazeWidth() && yCor < frame.getMainPanel().getMazePanel().getMazeHeight()
            Constructor<?> con = aClass.getConstructor();
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
