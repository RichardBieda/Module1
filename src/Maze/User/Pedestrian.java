package Maze.User;
import Maze.MazeLabels.*;

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
