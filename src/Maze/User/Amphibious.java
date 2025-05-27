package Maze.User;
import Maze.MazeLabels.*;

public class Amphibious implements Movable  {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof Wall);
    }
}
