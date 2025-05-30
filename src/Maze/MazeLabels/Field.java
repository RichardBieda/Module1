package Maze.MazeLabels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Field extends JButton {

    private final static Color BORDER_COLOR = new Color(200,200,200);
    private final static int BORDER_THICKNESS = 1;
    final static Border BORDER_FACTORY = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS);
    private Field caller;
    private boolean isChecked;
    private int fY;
    private int fX;


    public Field() {
        setBackground(FieldGraphics.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }

    public void setFY(int y) {
        fY = y;
    }

    public void setFX(int x) {
        fX = x;
    }

    public Field getCaller() {
        return caller;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public int getFY() {
        return fY;
    }

    public int getFX() {
        return fX;
    }

    public void setCaller(Field caller) {
        this.caller = caller;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getRightF() {
        return fX + 1;
    }

    public int getLeftF() {
        return fX - 1;
    }

    public int getAboveF() {
        return fY - 1;
    }

    public int getBelowF() {
        return fY + 1;
    }

    @Override
    public String toString() {
        return " " + this.getClass().getSimpleName() + " ";
    }
}
