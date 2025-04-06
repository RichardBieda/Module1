package Maze.User;

import Maze.Fields.Field;
import Maze.Fields.Water;
import Maze.Interfaces.Movable;

public class Boat implements Movable {
    @Override
    public boolean canMove(Field field) {
        return field instanceof Water;
    }
}
