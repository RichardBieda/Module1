package Maze.Fields;

import java.awt.*;

public enum Look {

    WALL(Color.RED),
    GOAL(Color.ORANGE),
    PATH(Color.GRAY),
    START(Color.YELLOW),
    WATER(Color.BLUE),
    NO_FLY_ZONE(Color.PINK),
    EMPTY_FIELD(new Color(248, 255, 255)),
    BRIDGE(new Color(150, 75,0));

    private final Color COLOR;

    Look(Color color) {
        this.COLOR = color;
    }

    public Color getCOLOR() {
        return COLOR;
    }

    public static Color getLabelColor(Field field) {
        return switch (field) {
            case Start start -> START.COLOR;
            case Wall wall -> WALL.COLOR;
            case Water water -> WATER.COLOR;
            case NoFlyZone noFlyZone -> NO_FLY_ZONE.COLOR;
            case Bridge bridge -> BRIDGE.COLOR;
            case Path path -> PATH.COLOR;
            case Goal goal -> GOAL.COLOR;
            default -> EMPTY_FIELD.COLOR;
        };
    }
}
