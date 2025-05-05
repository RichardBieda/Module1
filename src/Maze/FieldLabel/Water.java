package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class Water extends Barrier {
    public Water() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
