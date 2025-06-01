package Maze.User;
import Maze.Look;

public class Pedestrian implements Movable {

    @Override
    public boolean canMove(Look look) {
        if (look == Look.NO_FLY_ZONE || look == Look.BRIDGE || look == Look.EMPTY_FIELD) {
            return true;
        }
        return false;
    }
}
