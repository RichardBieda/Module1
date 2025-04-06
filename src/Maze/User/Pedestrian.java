package Maze.User;

import Maze.Fields.Barrier;
import Maze.Fields.Field;
import Maze.Interfaces.Movable;

public class Pedestrian implements Movable {

    public Pedestrian() {}

    public boolean canMove(Field field) {
        if (field instanceof Barrier) {
            return false;
        }
        return true;
    }
}
