package Maze.User;

import Maze.Fields.Bridge;
import Maze.Fields.Field;
import Maze.Fields.Water;
import Maze.Movable;

public class Boat implements Movable {
    @Override
    public boolean canMove(Field field) {
        return field instanceof Water || field instanceof Bridge;
    }
}
