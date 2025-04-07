package Maze.Graphics;

import Maze.Fields.*;

public enum ConsoleView {

    WALL(" X ", 0),
    DESTINATION(" D ", 1),
    PATH(" + ", 2),
    START(" S ", 3),
    WATER(" \u2248 ", 4),
    NoFlyZone(" § ", 5),
    EMPTY_FIELD("   ", 6),
    BRIDGE(" n ", 7);

    private final String SIGN;

    ConsoleView(String sign, int number) {
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
            case null, default -> "   ";
        };
    }
}
