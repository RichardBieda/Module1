package Maze.User;
import Maze.Fields.*;

public class Pedestrian implements Movable {

    @Override
    public boolean canMove(Field field) {
        if (field instanceof NoFlyZone || field instanceof Bridge || field instanceof EmptyField) {
            return true;
        }
        return false;
    }
}
