package Maze.FieldLabel;

import Maze.Graphics.UIView;

public class EmptyField extends Field {
    public EmptyField() {
        setBackground(UIView.getLabelColor(this));
        setBorder(Field.BORDER_FACTORY);
        setOpaque(true);
    }
}
