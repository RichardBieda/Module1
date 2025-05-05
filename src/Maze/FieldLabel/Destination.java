package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class Destination extends Barrier {
    public Destination() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
