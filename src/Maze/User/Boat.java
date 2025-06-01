package Maze.User;
import Maze.Look;

public class Boat implements Movable {

    @Override
    public boolean canMove(Look look) {
        return look == Look.WATER || look == Look.BRIDGE;
    }
}
