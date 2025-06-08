package Maze.Swing;

import Maze.Look;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Cell extends JButton {

    private final static Color BORDER_COLOR = new Color(200,200,200);
    private final static Color CELL_BACKGROUND_COLOR = new Color(248, 255, 255);
    private final static int BORDER_THICKNESS = 1;
    final static Border BORDER_FACTORY = BorderFactory.createLineBorder(BORDER_COLOR, BORDER_THICKNESS);
    private boolean isChecked;
    private Look look;
    private Cell caller;
    private final int CX;
    private final int CY;

    Cell(Look look, int y, int x) {
        this.look = look;
        this.CY = y;
        this.CX = x;
        setBackground(CELL_BACKGROUND_COLOR);
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

    public Look Getlook() {
        return look;
    }

    public Cell getCaller() {
        return caller;
    }

    public void setCaller(Cell cell) {
        this.caller = cell;
    }

    public void setLook(Look newLook) {
        look = newLook;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(CELL_BACKGROUND_COLOR);
        g.drawImage(look.getIMAGE(), 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public String toString() {
        return " " + this.getClass().getSimpleName();
    }
}
