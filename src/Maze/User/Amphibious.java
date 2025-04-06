package Maze.User;

import Maze.Fields.Field;
import Maze.Fields.Wall;
import Maze.Interfaces.Movable;

public class Amphibious implements Movable  {
    @Override
    public boolean canMove(Field field) {
        if (field instanceof Wall) {
            return false;
        }
        return true;
    }
}
