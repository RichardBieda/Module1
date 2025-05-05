package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class NoFlyZone extends Barrier {
    public NoFlyZone() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
