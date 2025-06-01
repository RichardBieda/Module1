package Maze.User;
import Maze.Fields.*;

public class Boat implements Movable {
    @Override
    public boolean canMove(Field field) {
        return field instanceof Water || field instanceof Bridge;
    }
}
