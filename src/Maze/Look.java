package Maze;

import Maze.Swing.MainFrame;

import java.awt.*;
public enum Look {

    START(MainFrame.START_ICON),
    GOAL(MainFrame.GOAL_ICON),
    BRIDGE(MainFrame.BRIDGE_ICON),
    NO_FLY_ZONE(MainFrame.NO_FLY_ZONE_ICON),
    WALL(MainFrame.WALL_ICON),
    WATER(MainFrame.WATER_ICON),
    BRIDGE_PATH(MainFrame.BRIDGE_PATH_ICON),
    NO_FLY_ZONE_PATH(MainFrame.NO_FLY_ZONE_PATH_ICON),
    WALL_PATH(MainFrame.WALL_PATH_ICON),
    WATER_PATH(MainFrame.WATER_PATH_ICON),
    EMPTY_FIELD(null),
    EMPTY_FIELD_PATH(MainFrame.EMPTY_FIELD_PATH_ICON);

    private final Image IMAGE;

    Look(Image image) {
        this.IMAGE = image;
    }

    public Image getIMAGE() {
        return IMAGE;
    }
}
