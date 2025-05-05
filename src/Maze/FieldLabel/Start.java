package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class Start extends Barrier {
    public Start() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
