package Maze.Swing;

import Maze.Fields.Look;
import Maze.Fields.Field;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Cell extends JButton {

    private final static Color BORDER_COLOR = new Color(200,200,200);
    private final static int BORDER_THICKNESS = 1;
    final static Border BORDER_FACTORY = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS);
    private boolean isChecked;
    private Field field;
    private Cell caller;
    private final int CX;
    private final int CY;

    Cell(Field field, int y, int x) {
        this.field = field;
        this.CY = y;
        this.CX = x;
        setBackground(Look.getLabelColor(field));
        setBorder(BORDER_FACTORY);
        setOpaque(true);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getCX() {
        return CX;
    }

    public int getCY() {
        return CY;
    }

    public Field getField() {
        return field;
    }

    public Cell getCaller() {
        return caller;
    }

    public void setCaller(Cell cell) {
        this.caller = cell;
    }

    public void setField(Field newField) {
        field = newField;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Look.getLabelColor(field));
    }

    @Override
    public String toString() {
        return " " + this.getClass().getSimpleName();
    }
}
