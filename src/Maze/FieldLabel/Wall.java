package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class Wall extends Barrier {
    public Wall() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
