package Maze.User;
import Maze.Look;

public class Amphibious implements Movable  {

    @Override
    public boolean canMove(Look look) {
        return !(look == Look.WALL);
    }
}
