package Maze.Swing;

import Maze.MazeLabels.Field;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MazeActionListener implements ActionListener {

    private final MainFrame frame;
    private final int width;
    private final int height;
    MazeActionListener(MainFrame frame) {
        this.frame = frame;
        this.width = frame.getMainPanel().getMazePanel().getMazeWidth();
        this.height = frame.getMainPanel().getMazePanel().getMazeHeight();
        System.out.println("constructor "  +  frame.getMainPanel().getMazePanel().getMazeWidth() + " -- " + frame.getMainPanel().getMazePanel().getMazeHeight() + this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("start");
        Field tmp = (Field) e.getSource();
        int xCor = tmp.getFX();
        int yCor = tmp.getFY();
        boolean ori = frame.getMainPanel().getMenuPanel().getOrientation();
        System.out.println("inits: " + tmp + "--" + xCor + "--" + yCor + "--" + ori);

        Class<? extends Field> fClass = frame.getMainPanel().getMenuPanel().getFieldClass();
        int count = frame.getMainPanel().getMenuPanel().getSliderValue();
        System.out.println("getFieldClass: " + fClass + " -- " + count);
        try {
            Constructor<?> con = fClass.getConstructor();
            while (count-- > 0 && xCor < frame.getMainPanel().getMazePanel().getMazeWidth() && yCor < frame.getMainPanel().getMazePanel().getMazeHeight()) {
                Field newField = (Field) con.newInstance();
                newField.addActionListener(this);
                frame.getMainPanel().getMazePanel().getFields()[yCor][xCor] = newField;
                if (ori)
                    xCor++;
                else
                    yCor++;
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
