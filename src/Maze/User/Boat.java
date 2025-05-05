package Maze.User;

import Maze.FieldLabel.Bridge;
import Maze.FieldLabel.Field;
import Maze.FieldLabel.Water;
import Maze.Movable;

public class Boat implements Movable {
    @Override
    public boolean canMove(Field field) {
        return field instanceof Water || field instanceof Bridge;
    }
}
