package Maze.User;
import Maze.Fields.*;

public class Amphibious implements Movable  {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof Wall);
    }
}
