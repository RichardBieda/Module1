package Maze.User;

import Maze.Fields.Field;
import Maze.Fields.NoFlyZone;
import Maze.Movable;

public class Airplane implements Movable {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof NoFlyZone);
    }
}
