package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class Path extends Field {
    public Path() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
