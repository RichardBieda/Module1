package Maze.Swing;

import Maze.MazeLabels.Field;
import Maze.MazeLabels.FieldGraphics;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


class FieldButton extends JButton {

    private final static Color BORDER_COLOR = new Color(200,200,200);
    private final static int BORDER_THICKNESS = 1;
    final static Border BORDER_FACTORY = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS);
    private Field caller;
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

    Field getField() {
        return field;
    }

    void setField(Field newField) {
        field = newField;
        repaint();
    }

    void setFY(int y) {
        fY = y;
    }

    void setFX(int x) {
        fX = x;
    }

    Field getCaller() {
        return caller;
    }

    boolean isChecked() {
        return isChecked;
    }

    int getFY() {
        return fY;
    }

    int getFX() {
        return fX;
    }

    void setCaller(Field caller) {
        this.caller = caller;
    }

    void setChecked(boolean checked) {
        isChecked = checked;
    }

    int getRightF() {
        return fX + 1;
    }

    int getLeftF() {
        return fX - 1;
    }

    int getAboveF() {
        return fY - 1;
    }

    int getBelowF() {
        return fY + 1;
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
