package Maze.User;

import Maze.Fields.Bridge;
import Maze.Fields.Field;
import Maze.Fields.Wall;
import Maze.Movable;

public class Amphibious implements Movable  {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof Wall);
    }
}
