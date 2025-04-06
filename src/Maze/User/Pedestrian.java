package Maze.User;

import Maze.Fields.Barrier;
import Maze.Fields.Field;
import Maze.Interfaces.Movable;

public class Pedestrian implements Movable {

    @Override
    public boolean canMove(Field field) {
        return !(field instanceof Barrier);
    }
}
