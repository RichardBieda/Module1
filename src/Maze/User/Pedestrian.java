package Maze.User;

import Maze.Fields.Barrier;
import Maze.Fields.Bridge;
import Maze.Fields.Field;
import Maze.Fields.NoFlyZone;
import Maze.Movable;

public class Pedestrian implements Movable {

    @Override
    public boolean canMove(Field field) {
        if (field instanceof Bridge || field instanceof NoFlyZone) {
            return true;
        } else if (field instanceof Barrier) {
            return false;
        }
        return true;
    }
}
