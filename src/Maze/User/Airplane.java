package Maze.User;

import Maze.FieldLabel.Field;
import Maze.FieldLabel.NoFlyZone;
import Maze.Movable;

public class Airplane implements Movable {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof NoFlyZone);
    }
}
