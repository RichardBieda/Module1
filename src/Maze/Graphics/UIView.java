package Maze.Graphics;

import Maze.Fields.*;
import java.awt.*;

public enum UIView {

    WALL(Color.RED),
    DESTINATION(Color.ORANGE),
    PATH(Color.GRAY),
    START(Color.YELLOW),
    WATER(Color.BLUE),
    NoFlyZone(Color.BLACK),
    EMPTY_FIELD(new Color(248, 255, 255)),
    BRIDGE(new Color(150, 75,0));

    private final Color COLOR;

    UIView(Color color) {
        this.COLOR = color;
    }

    public static Color getLabelColor(Field field) {
        return switch (field) {
            case Start start -> START.COLOR;
            case Wall wall -> WALL.COLOR;
            case Water water -> WATER.COLOR;
            case NoFlyZone noFlyZone -> NoFlyZone.COLOR;
            case Bridge bridge -> BRIDGE.COLOR;
            case Path path -> PATH.COLOR;
            case Destination destination -> DESTINATION.COLOR;
            default -> EMPTY_FIELD.COLOR;
        };
    }
}
