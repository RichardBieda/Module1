package Maze.User;

import Maze.FieldLabel.Bridge;
import Maze.FieldLabel.Field;
import Maze.FieldLabel.Wall;
import Maze.Movable;

public class Amphibious implements Movable  {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof Wall);
    }
}
