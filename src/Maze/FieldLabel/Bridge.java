package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class Bridge extends Barrier {
    public Bridge() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
