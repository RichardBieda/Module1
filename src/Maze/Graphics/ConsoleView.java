package Maze.Graphics;

import Maze.Fields.*;

public enum ConsoleView {

    WALL(" X "),
    DESTINATION(" D "),
    PATH(" + "),
    START(" S "),
    WATER(" \u2248 "),
    NoFlyZone(" § "),
    EMPTY_FIELD(" . "),
    BRIDGE(" n ");

    private final String SIGN;

    ConsoleView(String sign) {
        this.SIGN = sign;
    }

    public static String getSign(Field field) {
        return switch (field) {
            case Start start -> START.SIGN;
            case Wall wall -> WALL.SIGN;
            case Water water -> WATER.SIGN;
            case NoFlyZone noFlyZone -> NoFlyZone.SIGN;
            case Bridge bridge -> BRIDGE.SIGN;
            case Path path -> PATH.SIGN;
            case Destination destination -> DESTINATION.SIGN;
            default -> EMPTY_FIELD.SIGN;
        };
    }
}
