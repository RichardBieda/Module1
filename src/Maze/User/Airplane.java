package Maze.User;
import Maze.Look;

public class Airplane implements Movable {
    @Override
    public boolean canMove(Look look) {
        return !(look == Look.NO_FLY_ZONE);
    }
}
