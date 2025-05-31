package Maze.Swing;

import Maze.MazeLabels.Field;
import Maze.MazeLabels.FieldGraphics;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class FieldButton extends JButton {

    private final static Color BORDER_COLOR = new Color(200,200,200);
    private final static int BORDER_THICKNESS = 1;
    final static Border BORDER_FACTORY = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS);
    private FieldButton caller;
    private boolean isChecked;
    private int fY;
    private int fX;
    private Field field;

    FieldButton(Field field) {
        this.field = field;
        setBackground(FieldGraphics.getLabelColor(this.field));
        setBorder(BORDER_FACTORY);
        setOpaque(true);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field newField) {
        field = newField;
        repaint();
    }

    void setFY(int y) {
        fY = y;
    }

    void setFX(int x) {
        fX = x;
    }

    public FieldButton getCaller() {
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

    public void setCaller(FieldButton caller) {
        this.caller = caller;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(FieldGraphics.getLabelColor(this.field));
    }

    @Override
    public String toString() {
        return " " + field.getClass().getSimpleName() + " ";
    }
}
